/**
 * @Author sdh
 * @Date Created in 2019/3/6 16:41
 * @description
 */

/**
 * 【题目】 n个骰子的点数
 * <p>
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。
 * 输入n，打印出s的所有可能的值出现的概率
 */
public class DicesProbability
{
    /**
     * 骰子点数之和所有可能值的概率
     *
     * @param number 骰子个数
     * @param max    骰子最大值
     */
    public void printProbability(int number, int max)
    {
        if (number < 1 || max < 1)
        {
            return;
        }

        // 初始化
        int[][] probabilities = new int[2][max * number + 1];
        for (int i = 0; i < max * number + 1; i++)
        {
            probabilities[0][i] = 0;
            probabilities[1][i] = 0;
        }

        // 标记当前要使用的是第0个数组还是第1个数组
        int flag = 0;

        // 抛出一个骰子时出现的各种情况
        for (int i = 1; i <= max; i++)
        {
            probabilities[flag][i] = 1;
        }

        // 抛出其它骰子
        for (int k = 2; k <= number; k++)
        {
            // 如果抛出了k个骰子，那么和为[0, k-1]的出现次数为0
            for (int i = 0; i < k; i++)
            {
                probabilities[1 - flag][i] = 0;
            }

            // 抛出k个骰子，所有和的可能
            for (int i = k; i <= max * k; i++)
            {
                probabilities[1 - flag][i] = 0;

                // 每个骰子的出现的所有可能的点数
                for (int j = 1; j <= i && j <= max; j++)
                {
                    // 统计出和为i的点数出现的次数
                    probabilities[1 - flag][i] += probabilities[flag][i - j];
                }
            }
            flag = 1 - flag;
        }

        // 全部骰子的所有排列情况
        double total = 1;
        for (int i = 0; i < number; i++)
        {
            total *= max;
        }

        int maxSum = number * max;
        for (int i = number; i <= maxSum; i++)
        {
            double ratio = probabilities[flag][i] / total;
            System.out.printf("%-8.4f", ratio);
        }
        System.out.println();
    }
}

/**
 * @Author sdh
 * @Date Created in 2019/3/6 18:54
 * @description
 */

/**
 * 【题目】 股票的最大利润
 * <p>
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可获得的最大利润是多少？
 */
public class MaximalProfit
{
    /**
     * 股票的最大利润
     *
     * @param numbers 数组
     * @return 最大利润
     */
    public int maxDiff(int[] numbers)
    {
        if (numbers == null || numbers.length < 2)
        {
            return 0;
        }

        int min = numbers[0], maxDiff = numbers[1] - min;

        for (int i = 2; i < numbers.length; i++)
        {
            // 记录前i-1个数字中的最小值，即之前股票最低价
            if (numbers[i - 1] < min)
            {
                min = numbers[i - 1];
            }
            maxDiff = Math.max(maxDiff, numbers[i] - min);
        }
        return maxDiff;
    }
}

/**
 * @Author sdh
 * @Date Created in 2019/2/23 19:31
 * @description
 */

/**
 * 【题目】 剪绳子
 * <p>
 * 给你一根长度为n绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1）。
 * 每段的绳子的长度记为k[0]、k[1]、……、k[m]。
 * 请问k[0]k[1]…*k[m]可能的最大乘积是多少？
 * 例如当绳子的长度是 8 时，我们把它剪成长度分别为 2、3、3 的三段，此时得到最大的乘积18。
 */
public class CuttingRope
{
    /**
     * 动态规划法
     * f(length) = max(f(i) * f(length-i))
     *
     * @param length 绳长
     * @return 最大乘积
     */
    public int maxProductAfterCuttingWithDP(int length)
    {
        if (length < 2)
        {
            return 0;
        }
        if (length == 2)
        {
            return 1;
        }
        if (length == 3)
        {
            return 2;
        }

        int res[] = new int[length + 1];
        res[1] = 1;
        res[2] = 2;
        res[3] = 3;

        int max = 0;
        for (int i = 4; i <= length; i++)
        {
            max = 0;
            for (int j = 1; j <= i / 2; j++)
            {
                max = Math.max(max, res[j] * res[i - j]);
            }
            res[i] = max;
        }

        return res[length];
    }

    /**
     * 贪心法
     * 根据数学计算得到最优方案
     *
     * @param length 绳长
     * @return 最大乘积
     */
    public int maxProductAfterCuttingWithGreed(int length)
    {
        if (length < 2)
        {
            return 0;
        }
        if (length == 2)
        {
            return 1;
        }
        if (length == 3)
        {
            return 2;
        }

        int timeOf3 = length / 3;
        if (length % 3 == 1)
        {
            timeOf3--;
        }
        int timeOf2 = (length - 3 * timeOf3) >> 1;

        return (int) (Math.pow(3, timeOf3) * Math.pow(2, timeOf2));
    }
}

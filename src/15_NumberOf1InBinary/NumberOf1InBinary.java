/**
 * @Author sdh
 * @Date Created in 2019/2/23 21:44
 * @description
 */

/**
 * 【题目】 二进制中1的个数
 * <p>
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOf1InBinary
{
    /**
     * 常规做法，依次判断 n 的每一位是否为 1
     * 不移动数字 n，而改为移动标记flag，防止 n为负时产生死循环
     *
     * @param n 待计算数字
     * @return 1的个数
     */
    public int numberOfOne(int n)
    {
        int count = 0, flag = 1;
        while (flag != 0)
        {
            if ((n & flag) != 0)
            {
                count++;
            }
            flag <<= 1;
        }
        return count;
    }

    /**
     * 利用公式 n & (n-1)的特性
     * 每次可将n最右边的1变为0
     *
     * @param n 待计算数字
     * @return 1的个数
     */
    public int numberOfOneWithFormula(int n)
    {
        int count = 0;
        while (n != 0)
        {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}

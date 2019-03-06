/**
 * @Author sdh
 * @Date Created in 2019/3/6 19:38
 * @description
 */

/**
 * 【题目】 不用加减乘除做加法
 * <p>
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号
 */
public class AddTwoNumbers
{
    /**
     * 两数加法
     *
     * @param num1 数1
     * @param num2 数2
     * @return 相加结果
     */
    public int add(int num1, int num2)
    {
        int sum = 0, carry = 0;
        while (num2 != 0)
        {
            // 各位相加，不考虑进位
            sum = num1 ^ num2;

            // 计算进位
            carry = (num1 & num2) << 1;

            // 重复上述步骤
            num1 = sum;
            num2 = carry;
        }
        return num1;
    }
}

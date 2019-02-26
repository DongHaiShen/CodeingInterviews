/**
 * @Author sdh
 * @Date Created in 2019/2/26 10:47
 * @description
 */

/**
 * 【题目】 表示数值的字符串
 * <p>
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class NumericStrings
{
    /**
     * 判断字符串是否是数值
     *
     * @param str 字符串
     * @return 判断结果
     */
    public boolean isNumeric(char[] str)
    {
        if (str == null || str.length == 0)
        {
            return false;
        }

        // 标记三个特殊符号，即指数e，正负号和小数点
        boolean hasE = false, hasSign = false, hasPoint = false;
        char cur;

        for (int i = 0; i < str.length; i++)
        {
            cur = str[i];

            // 若当前字符是e，如果已出现过e或e是最后一个字符，则不是整数
            if (cur == 'e' || cur == 'E')
            {
                if (hasE || i == str.length - 1)
                {
                    return false;
                }
                hasE = true;
            }

            // 若当前字符是正负号，则必须位于首位或位于e之后
            else if (cur == '+' || cur == '-')
            {
                if (i != 0 && str[i - 1] != 'e' && str[i - 1] != 'E')
                {
                    return false;
                }
                hasSign = true;
            }

            // 若当前字符是小数点，如果已经出现过小数点或e，则不是整数
            else if (cur == '.')
            {
                if (hasPoint || hasE)
                {
                    return false;
                }
                hasPoint = true;
            }

            // 显然其他字符必须都是0~9之间的数字
            else if (cur < '0' || cur > '9')
            {
                return false;
            }
        }

        return true;
    }
}

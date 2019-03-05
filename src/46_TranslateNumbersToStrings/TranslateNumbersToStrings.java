/**
 * @Author sdh
 * @Date Created in 2019/3/5 10:21
 * @description
 */

/**
 * 【题目】 把数字翻译成字符串
 * <p>
 * 给定一个数字，我们按照如下规则把它翻译为字符串：
 * 0 翻译成 "a"，1 翻译成 "b"，……，11 翻译成 "l"，……，25 翻译成 "z"。
 * 一个数字可能有多个翻译。例如 12258 有 5 种不同的翻译，它们分别是 "bccfi"、"bwfi"、"bczi"、"mcfi"和"mzi"。
 * 请编程实现一个函数用来计算一个数字有多少种不同的翻译方法。
 */
public class TranslateNumbersToStrings
{
    /**
     * 翻译数字的方法个数
     *
     * @param number 数字
     * @return 方法个数
     */
    public int getTranslationCount(int number)
    {
        if (number < 0)
        {
            return 0;
        }

        if (number >= 0 && number <= 9)
        {
            return 1;
        }

        return getTranslationCount(Integer.toString(number));
    }

    /**
     * 转化为字符串进行处理
     *
     * @param number 字符串
     * @return 方法个数
     */
    public int getTranslationCount(String number)
    {
        int f = 1, fMin1 = 1, fMin2 = 0, g = 0;

        // 从后往前计算，只需记录最近的两个值
        for (int i = number.length() - 2; i >= 0; i--)
        {
            g = isInRange(number.charAt(i), number.charAt(i + 1)) ? 1 : 0;

            // 核心递推式
            fMin2 = fMin1 + g * f;

            f = fMin1;
            fMin1 = fMin2;
        }
        return fMin2;
    }

    /**
     * 判断由两个字符组成的数字是否在规定范围内
     *
     * @param x 字符x
     * @param y 字符y
     * @return 判断结果
     */
    public boolean isInRange(char x, char y)
    {
        int n = Integer.parseInt(String.valueOf(x) + String.valueOf(y));
        return n >= 10 && n <= 25;
    }
}
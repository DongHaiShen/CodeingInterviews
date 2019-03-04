/**
 * @Author sdh
 * @Date Created in 2019/3/4 16:57
 * @description
 */

/**
 * 【题目】 整数中1出现的次数
 * <p>
 * 输入一个整数 n，求 1~n 这n个整数的十进制表示中1出现的次数。
 * 例如，输入12，1~12这些整数中包含1的数字有1、10、11和12，1一共出现了5次。
 */
public class NumberOf1
{
    /**
     * 1~n中1出现的次数
     *
     * @param n 最大值n
     * @return 1出现的次数
     */
    public int numberOf1Between1AndN(int n)
    {
        if (n <= 0)
        {
            return 0;
        }

        // 把数字转换为字符数组便于处理
        String value = n + "";
        int[] numbers = new int[value.length()];

        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = value.charAt(i) - '0';
        }

        return numberOf1(numbers, 0);
    }

    /**
     * 统计1的个数
     *
     * @param numbers 转换后的字符数组
     * @return 1的个数
     */
    public int numberOf1(int[] numbers, int curIndex)
    {
        if (numbers == null || curIndex >= numbers.length || curIndex < 0)
        {
            return 0;
        }

        // 要处理的数字的位数
        int length = numbers.length - curIndex;

        // 待处理的第一个数字
        int first = numbers[curIndex];

        // 如果只有一位且这一位是0返回0
        if (length == 1 && first == 0)
        {
            return 0;
        }

        // 如果只有一位且这一位不是0返回1
        if (length == 1 && first > 0)
        {
            return 1;
        }

        // 假设numbers是21345
        // numFirstDigit代表的是数字10000-19999的第一个位中的数目
        int numFirstDigit = 0;

        // 如果最高位不是1，如21345，在[1346, 21345]中，最高位1出现的只在[10000, 19999]中，出现1的次数是10^4方个
        if (first > 1)
        {
            numFirstDigit = (int) Math.pow(10, length - 1);
        }

        // 如果最高位是1，如12345，在[2346, 12345]中，最高位1出现的只在[10000, 12345]中，总计2345+1个
        else if (first == 1)
        {
            numFirstDigit = atoi(numbers, curIndex + 1) + 1;
        }

        // numOtherDigits，是[1346, 21345]中，除了第一位之外（不看21345中的第一位2）的数位中的1的数目
        // 剩下的位数中取一位为1，其余的可以在0~9中任取，同时第一位可取1~first
        int numOtherDigits = first * (length - 1) * (int) Math.pow(10, length - 2);

        // 递归执行，去掉第一位2，numRecursive是1-1345中1的的数目
        int numRecursive = numberOf1(numbers, curIndex + 1);

        return numFirstDigit + numOtherDigits + numRecursive;
    }

    /**
     * 将数字数组转化为一个数字
     *
     * @param numbers 数字数组
     * @param begin   起始位置
     * @return 转换数字
     */
    public int atoi(int[] numbers, int begin)
    {
        int result = 0;
        for (int i = begin; i < numbers.length; i++)
        {
            result = result * 10 + numbers[i];
        }
        return result;
    }
}

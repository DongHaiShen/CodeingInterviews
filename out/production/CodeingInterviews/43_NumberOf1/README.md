[TOC]

## 整数中1出现的次数

输入一个整数 n，求 1~n 这n个整数的十进制表示中1出现的次数。
例如，输入12，1~12这些整数中包含1的数字有1、10、11和12，1一共出现了5次。

### 解法
详细分析 1 出现的规律，以21345为例：
+ 把21345分为 1~1345 和 1346 ~ 21345，对于1346 ~ 21345：
  1. 对于最高位：
    + 若本身不为1，如此处的21345，**则 1 只能出现在 10000~19999中**，共10000个；
    + 若本身为1，如12345，则 1 并没有10000个，**只有除去最高位后剩余数字加1个**，如此处的2345 + 1 = 2346个；
  2. 对于其余位置，**只需要取一位设为1，剩下的可在0~9中任取，同时第一位 n 又可取 1~n**，如此处的1~2，因此此处总共为 2 * 4 * 10^3 = 8000；

+ 对于1~1345，可用上述方式递归执行，最终将全部数字相加

#### 代码
```java
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
```



### 测试用例参考
1. 功能测试（输入1~n的数字）；
2. 特殊输入测试（输入的数字小于0）。
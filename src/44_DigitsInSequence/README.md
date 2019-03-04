[TOC]

## 数字序列中某一位的数字

数字以 0123456789101112131415… 的格式序列化到一个字符序列中。
在这个序列中，第 5 位（从 0 开始计数）是 5，第 13 位是 1，第 19 位是 4，等等。
请写一个函数求任意位对应的数字。

### 解法
以具体例子进行分析，例如求第1001位：
+ 一位数为0~9，共10位，1001 > 10可直接跳过，剩余 1001 - 10 = 991位；
+ 二位数为10~99，共180位，991 > 180可直接跳过，剩余 991 - 180 = 881位；
+ 三位数为100~999，共2700位，2700 > 881，即1001位是某个三位数中的一位；
+ 由于881 = 3 * 270 + 1，即1001位对应的三位数是100开始的第270个，**即370中的一位**，且因为余数为1，所以结果是7

#### 代码
```java
public class DigitsInSequence
{
    /**
     * 求数字序列中某一位的数字
     *
     * @param n 第 n 位
     * @return 第 n 位的数字
     */
    public int digitAtIndex(int n)
    {
        if (n < 0)
        {
            return -1;
        }

        int digits = 1;
        while (true)
        {
            long numbers = countOfIntegers(digits);
            if (n < digits * numbers)
            {
                break;
            }

            // 低位的数字可直接跳过
            n -= numbers * digits;
            ++digits;
        }
        return digitAtIndex(digits, n);
    }

    /**
     * 已知第 n 位落于某digits位数之中，求该数字
     *
     * @param digits 位数
     * @param n      第 n 位
     * @return 第 n 位的数字
     */
    public int digitAtIndex(int digits, int n)
    {
        // n位数的第一位
        int beginNumber = getBeginNumber(digits);

        // 想要查找的位数所在的数字
        int val = beginNumber + n / digits;

        // 位数在该数字中的第几位
        int indexFromRight = digits - n % digits;

        // 获取具体该位上的数字
        for (int i = 1; i < indexFromRight; ++i)
        {
            val /= 10;
        }
        return val % 10;
    }

    /**
     * 统计 n 位的数字总共有多少个
     * 例如 2 位共90个（10~99），3位共900个（100~999）
     *
     * @param digits 位数
     * @return 总个数
     */
    public long countOfIntegers(int digits)
    {
        return digits == 1 ? 10 : (int) (9 * Math.pow(10, digits - 1));
    }

    /**
     * n位数的第一个数字
     * 例如 2 位为 100，3位为 1000
     *
     * @param digits 位数
     * @return 数字
     */
    public int getBeginNumber(int digits)
    {
        return digits == 1 ? 0 : (int) Math.pow(10, digits - 1);
    }
}
```



### 测试用例参考
1. 功能测试（输入 10、190、1000）；
2. 边界值测试（输入 0、1）。
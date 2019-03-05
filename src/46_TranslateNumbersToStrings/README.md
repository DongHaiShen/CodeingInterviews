[TOC]

## 把数字翻译成字符串

给定一个数字，我们按照如下规则把它翻译为字符串：
0 翻译成 "a"，1 翻译成 "b"，……，11 翻译成 "l"，……，25 翻译成 "z"。
一个数字可能有多个翻译。例如 12258 有 5 种不同的翻译，它们分别是 "bccfi"、"bwfi"、"bczi"、"mcfi"和"mzi"。
请编程实现一个函数用来计算一个数字有多少种不同的翻译方法。

### 解法
翻译的方式有两种可能，以12258为例做具体分析：
+ 第一种把首位 1 单独翻译成 “b”，剩余2258；
+ 第二种把前两位 1 和 2 看成整体 “12” 翻译成 "m"，剩余258；
+ 定义 `f(i)` 表示从第 i 位数字开始的不同翻译方法，则递推式为： `f(i) = f(i+1) + g(i,i+1) * f(i+2)`，当第 i 位和第 i + 1位数字组成的整体在10~25范围内，则 `g(i,i+1) = 1` ，否则为 0；
+ 在实现时可以自下而上，先算出较短字符串的翻译方法数，再计算较长字符串


#### 代码
```java
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
```



### 测试用例参考
1. 功能测试（只有一位数字；包含多位数字）；
2. 特殊输入测试（负数；0；包含 25、26 的数字）。
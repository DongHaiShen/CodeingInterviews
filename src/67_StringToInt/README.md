[TOC]

## 把字符串转换成整数

将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)
要求不能使用字符串转换整数的库函数。
数值为0或者字符串不是一个合法的数值则返回0。

### 解法
+ 基本实现过程不难，但是需要考虑的情况较多，主要有：
  1. 字符串前后有空格；
  2. 空串或 null；
  3. 正负号与多个正负号；
  4. 溢出问题；
  5. 非数字字符等


#### 代码
```java
public class StringToInt
{
    /**
     * 字符串转换成整数
     *
     * @param str 字符串
     * @return 整数
     * @throws Exception
     */
    public int strToInt(String str) throws Exception
    {
        if (str == null || str.length() == 0)
        {
            throw new Exception("待转换字符串为null或空串");
        }

        // 溢出范围
        String MAX_INT_PLUS_1 = Integer.toString(Integer.MIN_VALUE).substring(1);

        // 去空格
        StringBuilder stringBuilder = new StringBuilder(str.trim());

        // 记录符号，无符号的正数为2，有符号的正数为1，负数为-1
        int flag = 0;
        if (stringBuilder.charAt(0) == '-')
        {
            flag = -1;
        }
        else if (stringBuilder.charAt(0) == '+')
        {
            flag = 1;
        }
        else if (stringBuilder.charAt(0) >= '0' && stringBuilder.charAt(0) <= '9')
        {
            flag = 2;
        }
        else
        {
            return 0;
        }

        int endIndex = 1;
        while (endIndex < stringBuilder.length() && stringBuilder.charAt(endIndex) >= '0'
                && stringBuilder.charAt(endIndex) <= '9')
        {
            endIndex++;
        }

        if (flag == 2)
        {
            if (stringBuilder.substring(0, endIndex).toString().compareTo(MAX_INT_PLUS_1) >= 0)
            {
                throw new Exception("数值上溢,待转换字符串为" + str);
            }
            return Integer.parseInt(stringBuilder.substring(0, endIndex));
        }
        else
        {
            if (flag == 1 && stringBuilder.substring(1, endIndex).compareTo(MAX_INT_PLUS_1) >= 0)
            {
                throw new Exception("数值上溢,待转换字符串为" + str);
            }

            if (flag == -1 && stringBuilder.substring(1, endIndex).compareTo(MAX_INT_PLUS_1) > 0)
            {
                throw new Exception("数值下溢,待转换字符串为" + str);
            }

            // 这里不能转为绝对值，因为绝对值已经超出正数的最大值
            if (flag == -1 && stringBuilder.substring(1, endIndex).compareTo(MAX_INT_PLUS_1) == 0)
            {
                return Integer.MIN_VALUE;
            }
            return flag * Integer.parseInt(stringBuilder.substring(1, endIndex));
        }
    }
}
```



### 测试用例参考
1. 功能测试（输入的字符串表示正数、负数和0）；
2. 边界值测试（最大的正整数、最小的负整数）；
3. 特殊输入测试（输入的字符串为null；输入的字符串为空字符串；输入的字符串中有非数字字符等）。


[TOC]

## 表示数值的字符串

请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。

### 解法
重点关注三个特殊字符，即**指数 $e$，正负号和小数点**：
+ 若当前字符是 $e​$ ：
  1. **已出现过 $e​$**，不是整数；
  2. **$e$ 是最后一个字符**，不是整数，因为e之后必须要有数值
+ 若当前字符是正负号：
  1. 如果出现在中间，则**前面必须是 $e$**；
  2. 如果前面不是 $e​$，则必须出现在**首位**
+ 若当前字符是小数点：
  1. 已出现过小数点，不是整数；
  2. 已出现过 $e$，不是整数，**因为 $e$ 的指数不能为小数**
+ 其他字符显然必须都是0~9之间的数字


#### 代码
```java
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
```



### 测试用例参考
1. 功能测试（正数或者负数；包含或者不包含整数部分的数值；包含或者不包含效数部分的值；包含或者不包含指数部分的值；各种不能表达有效数值的字符串）；
2. 特殊输入测试（输入字符串和模式字符串是空指针、空字符串）。



[TOC]

## 正则表达式匹配

请实现一个函数用来匹配包括.和*的正则表达式。
模式中的字符.表示任意一个字符，而*表示它前面的字符可以出现任意次（包含0次）。
在本题中，匹配是指字符串的所有字符匹配整个模式。
例如，字符串aaa与模式a.a和ab*ac*a匹配，但是与aa.a和ab*a均不匹配。

### 解法
需要全面考虑匹配中的各种情况，具体如下：
+ 字符串和模式串都到末尾，说明匹配成功；
+ 字符串还有而模式串已到末尾，说明匹配失败；
+ 若模式串下一个字符为 '\*'，如 a\*：
  + 若字符串还未结束，且字符串当前位置与模式串当前位置匹配（包括模式串为'.'），可从以下三种方案中进行选择：
    1. 字符串向后移动1，模式串留在原地（由于'*'可**多次使用**模式串当前字符）；
    2. 字符串向后移动1，模式串向后移动2 （即**只使用一次**模式串当前字符）；
    3. 字符串不动，模式串向后移动2（即**不使用**模式串当前字符，因为'*'允许使用0次）
  + 若字符串已经结束，则只能模式串向后移动2；
+  若模式串下一个字符不为'\*'，同时字符串未结束，且字符串当前位置与模式串当前位置匹配（包括模式串为'.'）：
  + 字符串向后移动1，模式串向后移动1，即常规匹配


#### 代码
```java
public class RegularExpressionsMatching
{
    /**
     * 判断字符串是否与模式串匹配
     *
     * @param str     字符串
     * @param pattern 模式串
     * @return 是否匹配
     */
    public boolean match(char[] str, char[] pattern)
    {
        if (str == null || pattern == null)
        {
            return false;
        }

        return matchCore(str, 0, str.length, pattern, 0, pattern.length);
    }

    /**
     * 递归判断字符串是否与模式串匹配
     *
     * @param str     字符串
     * @param sIndex  字符串当前位置
     * @param len1    字符串长度
     * @param pattern 模式串
     * @param pIndex  模式串当前位置
     * @param len2    模式串长度
     * @return
     */
    public boolean matchCore(char[] str, int sIndex, int len1, char[] pattern, int pIndex, int len2)
    {
        // 字符串和模式串都到末尾，说明匹配成功
        if (sIndex == len1 && pIndex == len2)
        {
            return true;
        }

        // 字符串还有而模式串已到末尾，说明匹配失败
        if (sIndex != len1 && pIndex == len2)
        {
            return false;
        }

        // 若模式串下一个字符为'*'，如a*
        if (pIndex + 1 < len2 && pattern[pIndex + 1] == '*')
        {
            // 字符串还未结束，且字符串当前位置与模式串当前位置匹配（包括模式串为'.'）
            if (sIndex < len1 && (str[sIndex] == pattern[pIndex] || pattern[pIndex] == '.'))
            {
                // 有三种情况：
                // 1. 字符串向后移动1，模式串留在原地（由于*可多次使用模式串当前字符）
                // 2. 字符串向后移动1，模式串向后移动2 （即只使用一次模式串当前字符）
                // 3. 字符串不动，模式串向后移动2（即不使用模式串当前字符，因为'*'允许使用0次）
                return matchCore(str, sIndex + 1, len1, pattern, pIndex, len2) ||
                        matchCore(str, sIndex + 1, len1, pattern, pIndex + 2, len2) ||
                        matchCore(str, sIndex, len1, pattern, pIndex + 2, len2);
            }
            else
            {
                // 字符串已经结束，则只能模式串向后移动2
                return matchCore(str, sIndex, len1, pattern, pIndex + 2, len2);
            }
        }

        // 模式串下一个字符不为'*'，同时字符串未结束，且字符串当前位置与模式串当前位置匹配（包括模式串为'.'）
        if (sIndex < len1 && (str[sIndex] == pattern[pIndex] || pattern[pIndex] == '.'))
        {
            // 字符串向后移动1，模式串向后移动1，即常规匹配
            return matchCore(str, sIndex + 1, len1, pattern, pIndex + 1, len2);
        }

        return false;
    }
}
```



### 测试用例参考
1. 功能测试（模式字符串里包含普通字符、.、*；模式字符串和输入字符串匹配/不匹配）；
2. 特殊输入测试（输入字符串和模式字符串是空指针、空字符串）。



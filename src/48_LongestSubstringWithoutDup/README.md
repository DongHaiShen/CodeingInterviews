[TOC]

## 最长不含重复字符的子字符串

请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
假设字符串中只包含从 a 到 z 的字符。

### 解法
+ 动态规划思想，因为字符的数量有限，可以利用一个数组存储每个字符上一次出现的位置；
+ 设 `f(i)` 表示以第 i 个字符结尾的字符串中不重复子串的最大长度；
+ 对于第 i 个字符，**若之前未出现过**，显然有 `f(i) = f(i-1) + 1`；
+ **若出现过**，则需要比较上一次出现位置到当前位置的距离 `d` 与 `f(i-1)` 的关系：
  1. 若 `d <= f(i-1)`，**说明当前字符已经出现在 `f(i-1)` 对应的最长子串中**，因此 `f(i) = d`；
  2. 若 `d > f(i-1)`，说明当前字符出现在 `f(i-1)` 对应最长子串之前，**现在即使加上也不会重复**，因此 `f(i) = f(i-1) + 1`


#### 代码
```java
public class LongestSubstringWithoutDup
{
    /**
     * 找出最长不重复子串长度
     *
     * @param s 字符串
     * @return 最长子串长度
     */
    public int longestSubstringWithoutDup(String s)
    {
        if (s == null || s.length() == 0)
        {
            return 0;
        }

        char[] chars = s.toCharArray();

        // 字符数量有限，用一个数组存储每个字符上一次出现的位置
        int[] position = new int[26];
        for (int i = 0; i < 26; i++)
        {
            position[i] = -1;
        }

        int curLength = 0, maxLength = 0, preIndex;
        for (int i = 0; i < chars.length; i++)
        {
            // 获取当前字符上一次出现的位置
            preIndex = position[chars[i] - 'a'];

            // 若还未出现过（即上一次位置为-1），或者距离当前位置过远（大于curLength），则当前长度直接加1
            // 否则当前长度重置为当前字符的前后位置之差
            curLength = (preIndex == -1 || i - preIndex > curLength) ? curLength + 1 : i - preIndex;

            // 刷新当前字符的最新位置
            position[chars[i] - 'a'] = i;

            // 维护最大值
            maxLength = Math.max(curLength, maxLength);
        }
        return maxLength;
    }
}
```



### 测试用例参考
1. 功能测试（包含多个字符的字符串；只有一个字符的字符串；所有字符都唯一的字符串；所有字符都相同的字符串）；
2. 特殊输入测试（空字符串）。
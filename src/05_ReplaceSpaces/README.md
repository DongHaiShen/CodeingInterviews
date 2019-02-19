[TOC]

## 替换空格

### 题目描述
请实现一个函数，将一个字符串中的每个空格替换成 %20。
例如，当字符串为 "We Are Happy."，则经过替换之后的字符串为 "We%20Are%20Happy."

### 解法

#### 解法1
**直接从头到尾遍历原字符串，遇到一个空格就改为%20**
这样看似时间复杂度为O(n)，但问题在于替换会增加字符数，因此**需要移动空格后面的其他字符**，因此实际为O(n^2)

时间复杂度：O(n^2)

空间复杂度：O(n)



#### 解法2（推荐）
由于从前往后修改会导致需要移动后续字符，因此可考虑**从后往前修改**，具体操作为：
+ 先遍历原字符串，**每遇到一个空格就在字符串后增加两个位置**，用于后续替换所用
+ 用指针 p 指向原字符串末尾，q 指向现字符串末尾，p, q 均从后往前遍历
+ 当 p 遇到空格时，q 位置依次加入 **"02%"** （因为从后往前遍历）
+ 若不是空格，只需直接拷贝 p 当前的字符

时间复杂度：O(n)

空间复杂度：O(n)

#### 代码
```java
public class ReplaceSpaces
{
    /**
     * 将字符串中的所有空格替换为%20
     *
     * @param str 原字符串
     * @return 替换后的字符串
     */
    public String replaceSpace(StringBuffer str)
    {
        // 增加健壮性
        if (str == null)
        {
            return null;
        }

        // 保存原始字符串长度
        int len = str.length();
        for (int i = 0; i < len; i++)
        {
            // 每遇到一个空格，就多增加2个字符的位置用于后续转换
            if (str.charAt(i) == ' ')
            {
                str.append("  ");
            }
        }

        // 使用两个指针从后向前遍历
        for (int preLength = len - 1, curLength = str.length() - 1; preLength >= 0; preLength--, curLength--)
        {
            // 若原先字符串中该位置为空格，则改为"%20"
            // 由于是从后向前，因此添加顺序为 0, 2, %
            if (str.charAt(preLength) == ' ')
            {
                str.setCharAt(curLength--, '0');
                str.setCharAt(curLength--, '2');
                str.setCharAt(curLength, '%');
            }
            else
            {
                str.setCharAt(curLength, str.charAt(preLength));
            }
        }

        return str.toString();
    }
}
```



### 测试用例参考
1. 输入的字符串包含空格（空格位于字符串的最前面 / 最后面 / 中间；字符串有多个连续的空格）；
2. 输入的字符串中没有空格；
3. 特殊输入测试（字符串是一个空指针；字符串是一个空字符串；字符串只有一个空格字符；字符串中有多个连续空格）。
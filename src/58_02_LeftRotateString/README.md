[TOC]

## 左旋转字符串

字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
请定义一个函数实现字符串左旋转操作的功能。
比如输入字符串 "abcdefg" 和数字 2，该函数将返回左旋转 2 位得到的结果 "cdefgab"。

### 解法
+ 可以把字符串看成左右两部分，即问题变为如何交换这两部分子串；
+ 可以先把两个子串分别翻转，然后再把整个字符串翻转


#### 代码
```java
public class LeftRotateString
{
    /**
     * 左旋转字符串
     *
     * @param str 字符串
     * @param n   左旋的位数
     * @return 旋转后的字符串
     */
    public String leftRotateString(String str, int n)
    {
        if (str == null || str.length() == 0 || str.length() < n)
        {
            return str;
        }

        char[] chars = str.toCharArray();

        // 先翻转前n个字符
        reverse(chars, 0, n - 1);

        // 再翻转后面的字符
        reverse(chars, n, chars.length - 1);

        // 最后整体翻转
        reverse(chars, 0, chars.length - 1);

        return String.valueOf(chars);
    }

    /**
     * 反转从start到end之间的字符
     *
     * @param chars 字符数组
     * @param start 起始位置
     * @param end   结束位置
     * @return
     */
    public void reverse(char[] chars, int start, int end)
    {
        if (chars == null || chars.length == 0 || start < 0 || end > chars.length || start > end)
        {
            return;
        }

        char temp;
        while (start < end)
        {
            temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }
    }
}
```



### 测试用例参考
1. 功能测试（把长度为 n 的字符串左旋转 0/1/2/n-1/n/n+1 个字符）；
2. 特殊输入测试（字符串指针为空指针）。
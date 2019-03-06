[TOC]

## 翻转单词顺序

输入一个英文句子，翻转句子中单词的顺序，**但单词内字符的顺序不变**。
为简单起见，标点符号和普通字母一样处理。
例如输入字符串 "I am a student."，则输出 "student. a am I"。

### 解法
+ 第一步把整个字符串都翻转过来，此时单词顺序和单词内部字符顺序都被翻转；
+ 第二步找出字符串中的单词，并把它们再翻转回来


#### 代码
```java
public class ReverseWordsInSentence
{
    /**
     * 翻转单词顺序
     *
     * @param str 字符串
     * @return 翻转后的字符串
     */
    public String reverseSentence(String str)
    {
        if (str == null || str.length() == 0)
        {
            return str;
        }

        char[] chars = str.toCharArray();

        // 先把字符串整个翻转
        reverse(chars, 0, chars.length - 1);

        int start = 0, end = 0;
        while (start < chars.length)
        {
            if (chars[start] == ' ')
            {
                start++;
                end++;
            }

            // 查找字符串中的单词，把它们再翻转回来
            else if (end == chars.length || chars[end] == ' ')
            {
                reverse(chars, start, end - 1);
                start = end;
                end++;
            }
            else
            {
                end++;
            }
        }

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
1. 功能测试（句子中有多个单词；句子中只有一个单词）；
2. 特殊输入测试（字符串指针为空指针；字符串的内容为空；字符串中只有空格）。
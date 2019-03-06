/**
 * @Author sdh
 * @Date Created in 2019/3/6 13:43
 * @description
 */

/**
 * 【题目】 翻转单词顺序
 * <p>
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串 "I am a student."，则输出 "student. a am I"。
 */
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

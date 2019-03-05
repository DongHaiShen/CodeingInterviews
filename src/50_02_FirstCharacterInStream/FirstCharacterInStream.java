/**
 * @Author sdh
 * @Date Created in 2019/3/5 14:33
 * @description
 */

/**
 * 【题目】 字符流中第一个不重复的字符
 * <p>
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符"google"时，第一个只出现一次的字符是"l"。
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class FirstCharacterInStream
{
    public StringBuilder sb = new StringBuilder();
    public int[] map = new int[256];

    /**
     * 从字符流中读取新字符
     *
     * @param ch 新字符
     */
    public void insert(char ch)
    {
        sb.append(ch);
        map[(int) ch]++;
    }

    /**
     * 第一个只出现一次的字符
     *
     * @return 字符
     */
    public char firstAppearingOnce()
    {
        for (char ch : sb.toString().toCharArray())
        {
            if (map[(int) ch] == 1)
            {
                return ch;
            }
        }
        return '#';
    }
}

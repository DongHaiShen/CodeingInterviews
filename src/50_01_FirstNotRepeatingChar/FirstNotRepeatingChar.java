/**
 * @Author sdh
 * @Date Created in 2019/3/5 14:06
 * @description
 */

/**
 * 【题目】 第一个只出现一次的字符
 * <p>
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 * 如果没有则返回 -1（需要区分大小写）.
 */
public class FirstNotRepeatingChar
{
    /**
     * 第一个只出现一次的字符的位置
     *
     * @param str 字符串
     * @return 字符位置，没有返回-1
     */
    public int firstNotRepeatingChar(String str)
    {
        if (str == null || str.length() == 0)
        {
            return -1;
        }

        // 这里因为字符只有256种可能，因此可以用数组实现简单哈希表
        int[] map = new int[256];
        for (int i = 0; i < str.length(); i++)
        {
            map[(int) str.charAt(i)]++;
        }

        for (int i = 0; i < str.length(); i++)
        {
            if (map[(int) str.charAt(i)] == 1)
            {
                return i;
            }
        }
        return -1;
    }
}

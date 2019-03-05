/**
 * @Author sdh
 * @Date Created in 2019/3/5 12:45
 * @description
 */

/**
 * 【题目】 最长不含重复字符的子字符串
 * <p>
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 假设字符串中只包含从 a 到 z 的字符。
 */
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

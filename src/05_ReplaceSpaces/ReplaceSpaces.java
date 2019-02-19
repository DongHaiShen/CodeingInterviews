/**
 * @Author sdh
 * @Date Created in 2019/2/18 22:39
 * @description
 */

/**
 * 【题目】 替换空格
 * <p>
 * 请实现一个函数，将一个字符串中的每个空格替换成 %20。
 * 例如，当字符串为 "We Are Happy."，则经过替换之后的字符串为 "We%20Are%20Happy."
 */
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

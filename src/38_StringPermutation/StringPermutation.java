import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author sdh
 * @Date Created in 2019/3/4 9:53
 * @description
 */

/**
 * 【题目】 字符串的排列
 * <p>
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * 牛客网OJ要求按字典序打印，即需要排序。
 */
public class StringPermutation
{
    /**
     * 求字符串的排列
     *
     * @param str 字符串
     * @return 所有排列结果
     */
    public ArrayList<String> permutation(String str)
    {
        ArrayList<String> result = new ArrayList<>();

        if (str == null || str.length() == 0)
        {
            return result;
        }

        char[] strChars = str.toCharArray();

        permutationCore(strChars, 0, result);

        // 符合OJ结果要求
        Collections.sort(result);
        return result;
    }

    /**
     * 递归处理每个字符
     * 核心步骤为：交换前后字符、递归处理、重置原先状态
     *
     * @param strChars 字符数组
     * @param index    当前处理位置
     * @param result   结果list
     */
    public void permutationCore(char[] strChars, int index, ArrayList<String> result)
    {
        // 处理至最后一个元素，存储结果
        if (index == strChars.length - 1)
        {
            result.add(new String(strChars));
            return;
        }

        // 避免存在重复值导致输出相同结果
        Set<Character> set = new HashSet<>();
        for (int i = index; i < strChars.length; i++)
        {
            if (!set.contains(strChars[i]))
            {
                set.add(strChars[i]);

                // 先交换前后字符
                swap(strChars, i, index);

                // 递归处理后续字符串
                permutationCore(strChars, index + 1, result);

                // 恢复原先状态
                swap(strChars, index, i);
            }
        }
    }

    /**
     * 交换两个字符
     *
     * @param chars 字符数组
     * @param x     位置x
     * @param y     位置y
     */
    public void swap(char[] chars, int x, int y)
    {
        char temp = chars[x];
        chars[x] = chars[y];
        chars[y] = temp;
    }
}

import java.util.Arrays;

/**
 * @Author sdh
 * @Date Created in 2019/3/4 18:40
 * @description
 */

/**
 * 【题目】 把数组排成最小的数
 * <p>
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组 [3, 32, 321]，则打印出这3个数字能排成的最小数字321323。
 */
public class SortArrayForMinNumber
{
    /**
     * 数组元素组成的最小的数字
     *
     * @param numbers 数组元素
     * @return 最小的数字
     */
    public String printMinNumber(int[] numbers)
    {
        // 把数字转成字符串，因为数字组合可能超出int范围
        int n = numbers.length;
        String[] strNums = new String[n];
        for (int i = 0; i < n; ++i)
        {
            strNums[i] = String.valueOf(numbers[i]);
        }

        // 调用现成sort方法，自定义比较规则
        Arrays.sort(strNums, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));

        // 得到结果
        StringBuilder sb = new StringBuilder();
        for (String str : strNums)
        {
            sb.append(str);
        }
        return sb.toString();
    }
}

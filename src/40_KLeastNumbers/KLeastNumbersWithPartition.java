import java.util.ArrayList;

/**
 * @Author sdh
 * @Date Created in 2019/3/4 13:32
 * @description
 */

/**
 * 【题目】 获取数组中最小的k个数
 * <p>
 * 输入 n 个整数，找出其中最小的 K 个数。例如输入 4,5,1,6,2,7,3,8 这 8 个数字，则最小的 4 个数字是 1,2,3,4。
 */
public class KLeastNumbersWithPartition
{
    /**
     * 获取数组中最小的k个数
     *
     * @param input 输入的数组
     * @param k     最小元素个数
     * @return 最小的k个数
     */
    public ArrayList<Integer> getLeastNumbers(int[] input, int k)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || input.length == 0 || input.length < k || k < 1)
        {
            return result;
        }

        int start = 0, end = input.length - 1;
        int index = partition(input, start, end);

        while (index != k - 1)
        {
            if (index > k - 1)
            {
                end = index - 1;
                index = partition(input, start, end);
            }
            else
            {
                start = index + 1;
                index = partition(input, start, end);
            }
        }

        for (int i = 0; i < k; i++)
            result.add(input[i]);

        return result;
    }

    /**
     * 快排partition过程
     *
     * @param array 数组
     * @param start 起始位置
     * @param end   结束位置
     * @return 基准元素位置
     */
    public int partition(int[] array, int start, int end)
    {
        int index = start - 1;
        for (int i = start; i < end; ++i)
        {
            if (array[i] < array[end])
            {
                swap(array, i, ++index);
            }
        }
        ++index;
        swap(array, index, end);
        return index;
    }

    /**
     * 交换两个数字
     *
     * @param array 数组
     * @param i     位置i
     * @param j     位置j
     */
    public void swap(int[] array, int i, int j)
    {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}

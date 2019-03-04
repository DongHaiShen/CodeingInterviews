/**
 * @Author sdh
 * @Date Created in 2019/3/4 14:45
 * @description
 */

/**
 * 【题目】 数组中出现次数超过一半的数字
 * <p>
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为 9 的数组 {1,2,3,2,2,2,5,4,2}。由于数字 2 在数组中出现了 5 次，超过数组长度的一半，因此输出 2。
 * 如果不存在则输出 0。
 */
public class MoreThanHalfNumberWithPartition
{
    /**
     * 查找数组中出现次数超过一半的数字
     *
     * @param array 数组
     * @return 若有则返回该值，没有返回0
     */
    public int moreThanHalfNum(int[] array)
    {
        if (array == null || array.length == 0)
        {
            return 0;
        }

        int start = 0, end = array.length - 1, middle = array.length >> 1;
        int index = partition(array, start, end);

        // 次数超过一半的数，排序后必定是中位数
        while (index != middle)
        {
            // 选中数字在中位数右边，往左继续找
            if (index > middle)
            {
                end = index - 1;
                index = partition(array, start, end);
            }

            // 选中数字在中位数左边，往右继续找
            else
            {
                start = index + 1;
                index = partition(array, start, end);
            }

        }

        // 检验该数是否真的超过一半次数
        int count = 0;
        for (int n : array)
        {
            if (n == array[index])
            {
                count++;
            }
        }
        return count * 2 > array.length ? array[index] : 0;
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

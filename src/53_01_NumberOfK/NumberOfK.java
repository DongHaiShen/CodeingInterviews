/**
 * @Author sdh
 * @Date Created in 2019/3/5 16:10
 * @description
 */

/**
 * 【题目】 数字在排序数组中出现的次数
 * <p>
 * 统计一个数字在排序数组中出现的次数。
 * 例如输入排序数组 [1, 2, 3, 3, 3, 3, 4, 5] 和数字 3，由于 3 在这个数组中出现了 4 次，因此输出 4。
 */
public class NumberOfK
{
    /**
     * 数字k在排序数组中出现的次数
     *
     * @param array 排序数组
     * @param k     数字k
     * @return 出现次数
     */
    public int getNumberOfK(int[] array, int k)
    {
        if (array == null || array.length == 0)
        {
            return 0;
        }

        int start = 0, end = array.length - 1;
        int first = getFirstK(array, start, end, k);
        int last = getLastK(array, start, end, k);

        if (first != -1 && last != -1)
        {
            return last - first + 1;
        }
        return 0;
    }

    /**
     * 数字k在排序数组中第一次出现的位置
     *
     * @param array 排序数组
     * @param start 起始位置
     * @param end   结束位置
     * @param k     数字k
     * @return 第一次出现的位置
     */
    public int getFirstK(int[] array, int start, int end, int k)
    {
        if (start > end)
        {
            return -1;
        }

        int middle = start + ((end - start) >> 1);
        if (array[middle] == k)
        {
            // 数字k位于数组第一位，或者该位置前面已经不是k，则说明找到第一次出现的位置
            if (middle == 0 || (middle > 0 && array[middle - 1] != k))
            {
                return middle;
            }

            // 否则继续往左找
            else
            {
                end = middle - 1;
            }
        }
        else if (array[middle] > k)
        {
            end = middle - 1;
        }
        else
        {
            start = middle + 1;
        }
        return getFirstK(array, start, end, k);
    }

    /**
     * 数字k在排序数组中最后一次出现的位置
     *
     * @param array 排序数组
     * @param start 起始位置
     * @param end   结束位置
     * @param k     数字k
     * @return 最后一次出现的位置
     */
    public int getLastK(int[] array, int start, int end, int k)
    {
        if (start > end)
        {
            return -1;
        }

        int middle = start + ((end - start) >> 1);
        if (array[middle] == k)
        {
            // 数字k位于数组最后一位，或者该位置后面已经不是k，则说明找到最后一次出现的位置
            if (middle == array.length - 1 || (middle < array.length - 1 && array[middle + 1] != k))
            {
                return middle;
            }

            // 否则继续往右找
            else
            {
                start = middle + 1;
            }
        }
        else if (array[middle] > k)
        {
            end = middle - 1;
        }
        else
        {
            start = middle + 1;
        }
        return getLastK(array, start, end, k);
    }
}

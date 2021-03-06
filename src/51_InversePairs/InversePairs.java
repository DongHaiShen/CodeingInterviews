/**
 * @Author sdh
 * @Date Created in 2019/3/5 14:54
 * @description
 */

/**
 * 【题目】 数组中的逆序对
 * <p>
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出，即输出P%1000000007
 */
public class InversePairs
{
    /**
     * 求数组中逆序对个数
     *
     * @param array 数组
     * @return 逆序对个数取模
     */
    public int inversePairs(int[] array)
    {
        if (array == null || array.length == 0)
        {
            return 0;
        }

        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++)
        {
            copy[i] = array[i];
        }

        return inversePairsCore(array, copy, 0, array.length - 1);
    }

    /**
     * 求逆序对核心方法
     *
     * @param array 原数组
     * @param copy  辅助数组
     * @param start 起始位置
     * @param end   结束位置
     * @return 逆序对个数取模
     */
    public int inversePairsCore(int[] array, int[] copy, int start, int end)
    {
        if (start == end)
        {
            copy[start] = array[start];
            return 0;
        }

        int middle = (start + end) >> 1;
        int left = inversePairsCore(array, copy, start, middle);
        int right = inversePairsCore(array, copy, middle + 1, end);

        // 前半段的最后一个数字的下标
        int i = middle;

        // 后半段最后一个数字的下标
        int j = end;

        // 开始拷贝的位置
        int indexCopy = end;

        // 逆序数
        int count = 0;

        while (i >= start && j > middle)
        {
            if (array[i] > array[j])
            {
                copy[indexCopy--] = array[i--];
                count += j - middle;
                if (count >= 1000000007)
                {
                    count %= 1000000007;
                }
            }
            else
            {
                copy[indexCopy--] = array[j--];
            }
        }

        for (; i >= start; i--)
            copy[indexCopy--] = array[i];

        for (; j > middle; j--)
            copy[indexCopy--] = array[j];

        for (int s = start; s <= end; s++)
        {
            array[s] = copy[s];
        }

        return (left + right + count) % 1000000007;
    }
}

/**
 * @Author sdh
 * @Date Created in 2019/2/18 16:19
 * @description
 */

/**
 * 【题目】
 * 在一个长度为 n+1 的数组里的所有数字都在 1 到 n 的范围内，所以数组中至少有一个数字是重复的。
 * 请找出数组中任意一个重复的数字，但不能修改输入的数组。
 * 例如，如果输入长度为 8 的数组 {2, 3, 5, 4, 3, 2, 6, 7}，那么对应的输出是重复的数字 2 或者 3
 */
public class DuplicationInArrayNoEdit
{
    /**
     * 查找数组中的重复元素，要求不能修改原数组
     *
     * @param numbers 待查数组
     * @return 找到的重复元素，-1表示未找到或非法情况
     */
    public int getDuplication(int[] numbers)
    {
        // 判断数组及其长度是否合法
        if (numbers == null || numbers.length <= 1)
        {
            return -1;
        }

        // 判断数组内部的数字是否在 [1，length - 1]之间
        for (int i = 0; i < numbers.length; i++)
        {
            if (numbers[i] < 1 || numbers[i] > numbers.length - 1)
            {
                return -1;
            }
        }

        int start = 1, end = numbers.length - 1;
        int middle, count;
        while (start <= end)
        {
            middle = (end - start) / 2 + start;
            count = countRange(numbers, start, middle);

            if (start == end)
            {
                if (count > 1)
                {
                    return start;
                }
                else
                {
                    break;
                }
            }

            // 该方法不能保证找到所有重复的数字
            if (count > middle - start + 1)
            {
                end = middle;
            }
            else
            {
                start = middle + 1;
            }
        }
        return -1;
    }

    /**
     * 计算在整个数组中有多少数字位于[start,end]之间
     *
     * @param numbers 待计算数组
     * @param start   判断上界
     * @param end     判断下界
     * @return 数量
     */
    public int countRange(int[] numbers, int start, int end)
    {
        if (numbers == null)
        {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < numbers.length; i++)
        {
            if (numbers[i] >= start && numbers[i] <= end)
            {
                count++;
            }
        }
        return count;
    }
}

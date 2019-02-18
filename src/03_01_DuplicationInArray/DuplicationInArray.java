/**
 * @Author sdh
 * @Date Created in 2019/2/17 21:08
 * @description
 */

/**
 * 【题目】
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为 7 的数组 {2, 3, 1, 0, 2, 5, 3}，那么对应的输出是重复的数字 2 或者 3
 */
public class DuplicationInArray
{
    /**
     * 查找数组中的重复元素
     *
     * @param numbers     待查数组
     * @param length      数组长度
     * @param duplication 在duplication[0]中存放找到的重复元素
     * @return boolean值，是否存在重复元素
     */
    public boolean duplicate(int numbers[], int length, int[] duplication)
    {
        // 判断数组及其长度是否合法
        if (numbers == null || length <= 1)
        {
            return false;
        }

        // 判断数组内部的数字是否在 [0，length - 1]之间
        for (int i = 0; i < length; i++)
        {
            if (numbers[i] < 0 || numbers[i] > length - 1)
            {
                return false;
            }
        }

        for (int i = 0; i < length; i++)
        {
            while (numbers[i] != i)
            {
                // 若第 i 位和第 numbers[i] 位的数字相同，则找到结果
                if (numbers[i] == numbers[numbers[i]])
                {
                    duplication[0] = numbers[i];
                    return true;
                }

                // 否则将这两位上的数字进行交换
                swap(numbers, numbers[i], i);
            }
        }

        return false;
    }

    public void swap(int numbers[], int i, int j)
    {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

}



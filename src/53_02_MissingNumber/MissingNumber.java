/**
 * @Author sdh
 * @Date Created in 2019/3/5 16:42
 * @description
 */

/**
 * 【题目】 0到n-1中缺失的数字
 * <p>
 * 一个长度为 n-1 的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围 0 到 n-1 之内。
 * 在范围 0 到 n-1 的 n 个数字中有且只有一个数字不在该数组中，请找出这个数字。
 */
public class MissingNumber
{
    /**
     * 获取0~n-1缺失的数字
     *
     * @param nums 数组
     * @return 缺失数
     */
    public int getMissingNumber(int[] nums)
    {
        if (nums == null || nums.length < 1)
        {
            return -1;
        }

        int start = 0, end = nums.length - 1, middle = 0;
        while (start <= end)
        {
            // 加减法优先级高于位运算
            middle = start + ((end - start) >> 1);

            // 下标和值相等，继续往右找
            if (nums[middle] == middle)
            {
                start = middle + 1;
            }
            else
            {
                // 如果找到首位，或者前一个元素的下标和值相等，则当前位置的数字缺失
                if (middle == 0 || nums[middle - 1] == middle - 1)
                {
                    return middle;
                }
                end = middle - 1;
            }
        }
        return start;
    }
}

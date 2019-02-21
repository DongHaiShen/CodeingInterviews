/**
 * @Author sdh
 * @Date Created in 2019/2/21 17:27
 * @description
 */

/**
 * 【题目】 旋转数组的最小数字
 * <p>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。 (非减意味着可以有重复数字)
 * 例如数组 {3,4,5,1,2} 为 {1,2,3,4,5} 的一个旋转，该数组的最小值为 1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class MinNumberInRotatedArray
{
    /**
     * 获取旋转数组的最小元素
     *
     * @param array 旋转数组
     * @return 最小值
     */
    public int minNumberInRotateArray(int[] array)
    {
        if (array == null || array.length == 0)
        {
            System.out.println("数组为空或长度为0");
            return 0;
        }

        int left = 0, right = array.length - 1, middle = left;

        // 确保左指针的值始终大于右指针的值
        while (array[left] >= array[right])
        {
            //  若两个指针相邻，此时右指针指向最小值
            if (right - left == 1)
            {
                return array[right];
            }

            middle = ((right - left) >> 1) + left;

            // 1,0,1,1,1
            // 1,1,1,0,1
            // 若左指针、右指针和中间值三者的值相同，则无法继续用二分查找
            // 此时只能顺序遍历查找最小值
            if (array[middle] == array[left] && array[middle] == array[right])
            {
                return getMin(array, left, right);
            }

            // 中间值大于左指针，则最小值在右边
            if (array[middle] >= array[left])
            {
                left = middle;
            }
            // 中间值小于右指针，则最小值在左边
            else if (array[middle] <= array[right])
            {
                right = middle;
            }
        }
        return array[middle];
    }

    /**
     * 遍历查找数组最小值
     *
     * @param array 数组
     * @param start 起始位置
     * @param end   结束位置
     * @return 最小值
     */
    public int getMin(int[] array, int start, int end)
    {
        int result = array[start];
        for (int i = start + 1; i <= end; i++)
        {
            if (array[i] < result)
            {
                result = array[i];
            }
        }
        return result;
    }
}

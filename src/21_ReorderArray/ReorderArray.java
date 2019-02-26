/**
 * @Author sdh
 * @Date Created in 2019/2/26 12:26
 * @description
 */

/**
 * 【题目】 调整数组顺序使奇数位于偶数前面
 * <p>
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分
 * 新增条件：并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReorderArray
{
    /**
     * 调整数组顺序（无新增条件版）
     *
     * @param array 数组
     */
    public void reOrderArrayWithSwap(int[] array)
    {
        if (array == null || array.length < 2)
        {
            return;
        }

        int start = 0, end = array.length - 1;

        // 从左往右找偶数，从右往左找奇数，然后交换
        while (start < end)
        {
            while (start < end && judge(array[start]))
            {
                start++;
            }
            while (start < end && !judge(array[end]))
            {
                end--;
            }

            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
        }
    }

    /**
     * 调整数组顺序（有新增条件版）
     *
     * @param array 数组
     */
    public void reOrderArrayWhileKeepOrder(int[] array)
    {
        if (array == null || array.length < 2)
        {
            return;
        }

        // 先统计有多少个奇数
        int count = 0;
        for (int i = 0; i < array.length; i++)
        {
            if (judge(array[i]))
            {
                count++;
            }
        }

        // 然后按位置排放
        int[] copy = new int[array.length];
        int indexOfOdd = 0, indexOfEven = count;
        for (int i = 0; i < array.length; i++)
        {
            if (judge(array[i]))
            {
                copy[indexOfOdd++] = array[i];
            }
            else
            {
                copy[indexOfEven++] = array[i];
            }
        }

        for (int i = 0; i < array.length; i++)
        {
            array[i] = copy[i];
        }
    }


    /**
     * 调整顺序的判断条件，单独取出增加扩展性
     * 此处为判断是否是奇数
     *
     * @param n 数字
     * @return 判断结果
     */
    public boolean judge(int n)
    {
        return (n & 1) == 1;
    }
}

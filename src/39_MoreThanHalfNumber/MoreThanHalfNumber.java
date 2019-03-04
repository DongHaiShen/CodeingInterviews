/**
 * @Author sdh
 * @Date Created in 2019/3/4 12:34
 * @description
 */

/**
 * 【题目】 数组中出现次数超过一半的数字
 * <p>
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为 9 的数组 {1,2,3,2,2,2,5,4,2}。由于数字 2 在数组中出现了 5 次，超过数组长度的一半，因此输出 2。
 * 如果不存在则输出 0。
 */
public class MoreThanHalfNumber
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

        int result = array[0], count = 1;
        for (int i = 0; i < array.length; i++)
        {
            if (count == 0)
            {
                result = array[i];
                count = 1;
            }
            else if (result == array[i])
            {
                count++;
            }
            else
            {
                count--;
            }
        }

        // 检验该数是否真的超过一半次数
        count = 0;
        for (int n : array)
        {
            if (n == result)
            {
                count++;
            }
        }
        return count * 2 > array.length ? result : 0;
    }
}

/**
 * @Author sdh
 * @Date Created in 2019/3/6 9:59
 * @description
 */

/**
 * 【题目】 数组中只出现一次的两个数字
 * <p>
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 * 你可以假设这两个数字一定存在。
 */
public class NumbersAppearOnce
{
    /**
     * 求数组中只出现一次的两个数字
     *
     * @param array 数组
     * @param num1  保存数字1
     * @param num2  保存数字2
     */
    public void findNumsAppearOnce(int[] array, int num1[], int num2[])
    {
        if (array == null || array.length < 2)
        {
            return;
        }

        // 先求所有数字的异或，结果为两个只出现一次数字的异或
        int exclusiveOr = 0;
        for (int i = 0; i < array.length; i++)
        {
            exclusiveOr ^= array[i];
        }

        // 因为数字不同，因此至少有一位上不都为0或1
        // 即在异或结果中该位为1
        int indexOfOne = findIndexOfOne(exclusiveOr);
        num1[0] = 0;
        num2[0] = 0;
        for (int i = 0; i < array.length; i++)
        {
            // 根据该位是否为1进行分组，两个分组中恰好各包含一个所求数字
            // 再通过异或进行求解
            if (isBitOne(array[i], indexOfOne))
            {
                num1[0] ^= array[i];
            }
            else
            {
                num2[0] ^= array[i];
            }
        }
    }

    /**
     * 找出第一个为 1的位置
     *
     * @param num 数字
     * @return 位置下标
     */
    public int findIndexOfOne(int num)
    {
        int index = 0;
        while ((num & 1) == 0)
        {
            num = num >> 1;
            index++;
        }
        return index;
    }

    /**
     * 判断数字第 index 位是否为 1
     *
     * @param num   数字
     * @param index 第 index 位
     * @return 判断结果
     */
    public boolean isBitOne(int num, int index)
    {
        num = num >> index;
        return (num & 1) == 1;
    }
}

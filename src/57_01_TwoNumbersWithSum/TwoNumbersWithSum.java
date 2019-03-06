import java.util.ArrayList;

/**
 * @Author sdh
 * @Date Created in 2019/3/6 12:48
 * @description
 */

/**
 * 【题目】 和为S的两个数字
 * <p>
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S。
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * ps：对应每个测试案例，输出两个数，小的先输出。
 */
public class TwoNumbersWithSum
{
    /**
     * 找出和为sum的两个数字
     *
     * @param array 数组
     * @param sum   两数之和
     * @return 存储结果list
     */
    public ArrayList<Integer> findNumbersWithSum(int[] array, int sum)
    {
        ArrayList<Integer> reList = new ArrayList<>();

        if (array == null || array.length == 0 || sum <= array[0])
        {
            return reList;
        }

        int start = 0, end = array.length - 1, curSum;
        while (start < end)
        {
            curSum = array[start] + array[end];
            if (curSum == sum)
            {
                reList.add(array[start]);
                reList.add(array[end]);
                return reList;
            }

            // 因为数组是递增排序的，因此若过大则向左找，过小则向右找
            else if (curSum > sum)
            {
                end--;
            }
            else
            {
                start++;
            }
        }
        return reList;
    }
}

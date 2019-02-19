/**
 * @Author sdh
 * @Date Created in 2019/2/18 19:18
 * @description
 */

/**
 * 【题目】 二维数组中的查找
 * <p>
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindInPartiallySortedMatrix
{
    /**
     * 在给定的二维数组内查找
     *
     * @param target 待查找的值
     * @param array  待查数组
     * @return boolean值，是否找到
     */
    public boolean find(int target, int[][] array)
    {
        if (array == null)
        {
            return false;
        }

        // 查找范围边界
        int rows = array.length, cols = array[0].length;

        // 查找起始点，即最右上角
        // 也可选取左下角，需要修改后续逻辑
        int row = 0, col = cols - 1;

        // 注意边界
        while (row < rows && col >= 0)
        {
            if (array[row][col] == target)
            {
                return true;
            }
            else if (array[row][col] > target)
            {
                // 右上角的值大于待查找的值，则可排除该列
                col--;
            }
            else
            {
                // 右上角的值小于待查找的值，则可排除该行
                row++;
            }
        }
        return false;
    }
}

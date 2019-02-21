/**
 * @Author sdh
 * @Date Created in 2019/2/21 21:25
 * @description
 */

/**
 * 【题目】 机器人的移动范围
 * <p>
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class RobotMove
{
    /**
     * 计算能到达的格子数
     *
     * @param threshold 限定的数字
     * @param rows      行数
     * @param cols      列数
     * @return 能到达的格子数
     */
    public int movingCount(int threshold, int rows, int cols)
    {
        if (threshold < 0 || rows < 0 || cols < 0)
        {
            return 0;
        }

        boolean[] visited = new boolean[rows * cols];

        return movingCountCore(threshold, rows, cols, 0, 0, visited);
    }

    /**
     * @param threshold 限定的数字
     * @param rows      行数
     * @param cols      列数
     * @param row       当前行数
     * @param col       当前列数
     * @param visited   访问标记数组
     * @return 能到达的格子数
     */
    public int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited)
    {
        int index = row * cols + col;
        int count = 0;

        if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[index]
                && getDigitSum(row) + getDigitSum(col) <= threshold)
        {
            visited[index] = true;

            count = 1 + movingCountCore(threshold, rows, cols, row - 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row + 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row, col - 1, visited)
                    + movingCountCore(threshold, rows, cols, row, col + 1, visited);
        }
        return count;
    }

    /**
     * 计算一个数字的数位之和
     *
     * @param number 数字
     * @return 数字的数位之和
     */
    public int getDigitSum(int number)
    {
        int sum = 0;
        while (number > 0)
        {
            sum += number % 10;
            number = number / 10;
        }
        return sum;
    }
}

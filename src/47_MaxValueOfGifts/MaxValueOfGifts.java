/**
 * @Author sdh
 * @Date Created in 2019/3/5 12:12
 * @description
 */

/**
 * 【题目】 礼物的最大价值
 * <p>
 * 在一个 m×n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向左或者向下移动一格直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物，请计算你最多能拿到多少价值的礼物？
 */
public class MaxValueOfGifts
{
    /**
     * 获取礼物的最大价值
     *
     * @param grid 礼物价值数组
     * @return 最大价值
     */
    public int getMaxValue(int[][] grid)
    {
        if (grid == null || grid.length == 0)
        {
            return 0;
        }

        int rows = grid.length, cols = grid[0].length;
        int[][] dp = new int[rows][cols];

        // 初始化边界值
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++)
        {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < cols; j++)
        {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < rows; i++)
        {
            for (int j = 1; j < cols; j++)
            {
                // 核心递推式
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][cols - 1];
    }
}

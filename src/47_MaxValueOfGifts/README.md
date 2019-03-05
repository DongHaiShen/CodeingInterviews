[TOC]

## 礼物的最大价值

在一个 m×n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
你可以从棋盘的**左上角开始**拿格子里的礼物，并**每次向左或者向下移动一格直到到达棋盘的右下角**。
给定一个棋盘及其上面的礼物，请计算你最多能拿到多少价值的礼物？

### 解法
+ 典型的动态规划问题，设 `f(i,j)` 表示当**到达** 坐标 `(i,j)` 时可获得礼物的最大价值；
+ 根据提议，只能向左或向下移动，即只能通过 `(i-1,j)` 或 `(i,j-1)` 到达 `(i,j)`；
+ 因此递推式为：`f(i,j) = max( f(i-1,j), f(i,j-1) ) + grid(i,j)`


#### 代码
```java
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
```



### 测试用例参考
1. 功能测试（多行多列的矩阵；一行或者一列的矩阵；只有一个数字的矩阵）；
2. 特殊输入测试（指向矩阵数组的指针为空指针）。
[TOC]

## 矩阵中的路径

请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
例如 a b c e s f c s a d e e 这样的 3 X 4 矩阵中包含一条字符串"bcced"的路径
但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。

### 解法
设当前位置为 $(row, col)$，字符串匹配至第 $pathLength$ 个：
+ 若 $(row, col)$ 对应字符和字符串第 $pathLength$ 个字符相同，则从相邻四个格子中匹配第 $pathLength+1$ 个字符；
+ 否则回溯至上一个字符重新进行选择


#### 代码
```java
public class StringPathInMatrix
{
    /**
     * 判断矩阵中是否包含某条路径
     *
     * @param matrix 矩阵
     * @param rows   行数
     * @param cols   列数
     * @param str    字符串路径
     * @return boolean值，是否包含
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        // 输入校验
        if (matrix == null || rows < 1 || cols < 1 || str == null || str.length == 0)
        {
            System.out.println("输入数据不合法");
            return false;
        }

        // 访问标记
        boolean[] visited = new boolean[matrix.length];
        int pathLength = 0;

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (hasPathCore(matrix, rows, cols, str, i, j, pathLength, visited))
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 回溯搜索算法
     *
     * @param matrix     矩阵
     * @param rows       行数
     * @param cols       列数
     * @param str        字符串路径
     * @param row        当前行数
     * @param col        当前列数
     * @param pathLength 已经找到的路径长度
     * @param visited    访问标记数组
     * @return boolean值，是否找到
     */
    public boolean hasPathCore(char[] matrix, int rows, int cols, char[] str, int row, int col, int pathLength, boolean[] visited)
    {
        if (pathLength == str.length)
        {
            return true;
        }

        boolean hasPath = false;
        int index = row * cols + col;

        // 若位置合法且当前位置与第pathLength个字符匹配
        if (row >= 0 && row < rows && col >= 0 && col < cols && matrix[index] == str[pathLength] && !visited[index])
        {
            pathLength++;
            visited[index] = true;

            // 从相邻四个格子中匹配第pathLength+1个字符
            hasPath = hasPathCore(matrix, rows, cols, str, row - 1, col, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, str, row + 1, col, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, str, row, col - 1, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, str, row, col + 1, pathLength, visited);

            // 如果匹配不到则回溯至上一个字符
            if (!hasPath)
            {
                pathLength--;
                visited[index] = false;
            }
        }
        return hasPath;
    }
}
```



### 测试用例参考
1. 功能测试（在多行多列的矩阵中存在或者不存在路径）；
2. 边界值测试（矩阵只有一行或者一列；矩阵和路径中的所有字母都是相同的）；
3. 特殊输入测试（输入空指针）。
[TOC]

## 顺时针打印矩阵
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
例如，如果输入如下 4 X 4 矩阵：
```
1   2   3   4
5   6   7   8
9   10  11  12
13  14  15  16
```
则依次打印出数字：
```
1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10
```

### 解法
+ **顺时针打印可看成一次打印最外面的一圈子矩阵**；
+ 记录左上角和右下角的坐标，即为该圈矩阵的范围；
+ 当前矩阵结束后，把四周的范围均向内缩小一格，然后执行下一次打印；
+ 直至左上角的坐标跑到右下角坐标的右方或者下方

#### 代码
```java
import java.util.ArrayList;

public class PrintMatrix
{
    /**
     * 顺时针打印矩阵
     *
     * @param matrix 矩阵
     * @return 存放结果的数组
     */
    public ArrayList<Integer> printMatrix(int[][] matrix)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix == null)
        {
            return result;
        }

        int xMin = 0, xMax = matrix.length - 1, yMin = 0, yMax = matrix[0].length - 1;

        // 一次打印最外面的一圈
        while (xMin <= xMax && yMin <= yMax)
        {
            printMatrixInCircle(matrix, xMin++, xMax--, yMin++, yMax--, result);
        }

        return result;
    }

    /**
     * 顺时针处理一圈子矩阵
     *
     * @param matrix 矩阵
     * @param xMin   x坐标最小值
     * @param xMax   x坐标最大值
     * @param yMin   y坐标最小值
     * @param yMax   y坐标最大值
     * @param array  存放结果的数组
     * @return
     */
    public void printMatrixInCircle(int[][] matrix, int xMin, int xMax, int yMin, int yMax, ArrayList<Integer> result)
    {
        // 只有一行
        if (xMin == xMax)
        {
            for (int i = yMin; i <= yMax; i++)
            {
                result.add(matrix[xMin][i]);
            }
        }
        // 只有一列
        else if (yMin == yMax)
        {
            for (int i = xMin; i <= xMax; i++)
            {
                result.add(matrix[i][yMin]);
            }
        }
        // 按顺时针顺序加入
        else
        {
            int curX = xMin, curY = yMin;

            // 从左到右
            while (curY != yMax)
            {
                result.add(matrix[curX][curY++]);
            }
            // 从上到下
            while (curX != xMax)
            {
                result.add(matrix[curX++][yMax]);
            }
            // 从右到左
            while (curY != yMin)
            {
                result.add(matrix[xMax][curY--]);
            }
            // 从下到上
            while (curX != xMin)
            {
                result.add(matrix[curX--][yMin]);
            }
        }
    }
}
```



### 测试用例参考
1. 数组中有多行多列；数组中只有一行；数组中只有一列；数组中只有一行一列。

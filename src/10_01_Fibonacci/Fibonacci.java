/**
 * @Author sdh
 * @Date Created in 2019/2/21 15:12
 * @description
 */

/**
 * 【题目】 斐波那契数列
 * <p>
 * 输入一个整数n，请你输出斐波那契数列的第n项。
 * 0 <= n <= 39，且第0项为0
 */
public class Fibonacci
{
    /**
     * 使用递归的方式
     *
     * @param n 第n项
     * @return 第n项的值
     */
    public int fibonacciWithRecursion(int n)
    {
        if (n < 2)
        {
            return n;
        }
        return fibonacciWithRecursion(n - 1) + fibonacciWithRecursion(n - 2);
    }

    /**
     * 使用迭代的方式
     *
     * @param n 第n项
     * @return 第n项的值
     */
    public int fibonacciWithIteration(int n)
    {
        if (n < 2)
        {
            return n;
        }

        int prePre = 0, pre = 1, cur = prePre + pre;
        for (int i = 2; i <= n; i++)
        {
            cur = prePre + pre;
            prePre = pre;
            pre = cur;
        }
        return cur;
    }

    /**
     * 使用矩阵递推公式
     * [ f(n)  f(n-1) ] = [ 1  1 ] ^ n-1  (当n>2)
     * [f(n-1) f(n-2) ]   [ 1  0 ]
     *
     * @param n 第n项
     * @return 第n项的值
     */
    public int fibonacciWithMatrix(int n)
    {
        if (n < 2)
        {
            return n;
        }
        int[][] start = {{1, 1}, {1, 0}};
        return matrixPow(start, n - 1)[0][0];
    }

    /**
     * 求矩阵的乘方
     *
     * @param start 起始矩阵
     * @param n     乘方次数
     * @return 矩阵乘方结果
     */
    public int[][] matrixPow(int[][] start, int n)
    {
        if ((n & 1) == 0)
        {
            int[][] temp = matrixPow(start, n >> 1);
            return matrixMultiply(temp, temp);
        }
        else if (n == 1)
        {
            return start;
        }
        else
        {
            return matrixMultiply(start, matrixPow(start, n - 1));
        }
    }

    /**
     * 矩阵相乘
     *
     * @param x 矩阵1
     * @param y 矩阵2
     * @return 矩阵相乘结果
     */
    public int[][] matrixMultiply(int[][] x, int[][] y)
    {
        int[][] result = new int[x.length][y[0].length];
        for (int i = 0; i < x.length; i++)
        {
            for (int j = 0; j < y[0].length; j++)
            {
                int sum = 0;
                for (int k = 0; k < x[0].length; k++)
                {
                    sum += x[i][k] * y[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }

    /**
     * 使用通项公式
     * f(n) = (1/√5)*{[(1+√5)/2]^n - [(1-√5)/2]^n}
     *
     * @param n 第n项
     * @return 第n项的值
     */
    public int fibonacciWithFormula(int n)
    {
        double sqrt5 = Math.sqrt(5);
        return (int) ((1 / sqrt5) * (Math.pow((1 + sqrt5) / 2, n) - Math.pow((1 - sqrt5) / 2, n)));
    }
}

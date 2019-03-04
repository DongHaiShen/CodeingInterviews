[TOC]

## 斐波那契数列

### 题目描述
输入一个整数n，请你输出斐波那契数列的第n项。
0 <= n <= 39，且第0项为0

### 解法

#### 解法1
采用递归的方式，$ f(n) = f(n-1) + f(n-2)  n^2 $，虽然实现简单但效率低下

时间复杂度：O(2^n)

#### 代码
```java
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
}
```



#### 解法2（推荐）
因为 $ f(n) $ 只和 $ f(n-1) $ 与 $ f(n-2) $ 有关，因此可以迭代向前计算，不断保存中间项的值

时间复杂度：O(n)

#### 代码
```java
public class Fibonacci
{
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
}
```



#### 解法3
需要用到一个矩阵递推公式：
$$\begin{bmatrix}
f(n)&f(n-1) \\
f(n-1)&f(n-2 )\\
\end{bmatrix} =
\begin{bmatrix}
1&1 \\
1&0\\
\end{bmatrix}^
{n-1}​$$

采用上述公式原本也需要 n 次乘方运算，但同时考虑到乘方有如下性质：
$$a^n = 
\begin{equation}
\left\{
\begin{array}{lr}
a^{n/2} * a^{n/2} &	n 为偶数 &  \\
a^{(n-1)/2} * a^{(n-1)/2} * a & n 为奇数 &  
\end{array}
\right.
\end{equation}​$$

因此可递归求出 n/2 次方的值，再平方即可

**注意：该方法虽然效率高，但实现复杂且不够实用，只需了解即可**

时间复杂度：O(lgn)

#### 代码
```java
public class Fibonacci
{
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
}
```



#### 解法4
使用通项公式：
$ f(n) = \frac {1} {\sqrt{5}} * ((\frac {1+\sqrt{5}} {2})^{n} - (\frac {1-\sqrt{5}} {2})^{n}))$

时间复杂度：O(1)

#### 代码
```java
public class Fibonacci
{
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
```


### 测试用例参考
1. 功能测试（如输入 3、5、10 等）；
2. 边界值测试（如输入 0、1、2）；
3. 性能测试（输入较大的数字，如 40、50、100 等）。
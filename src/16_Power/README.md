[TOC]

## 数值的整数次方

给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent。
求 base的 exponent 次方。

### 解法
首先需要考虑多种情况：
+ 若指数和底数都为0，数学上无意义；
+ 若指数为负，则需要求倒数。因此可以**先将指数取绝对值**，最后再判断是否需要求倒数；

对于乘方计算本身，可以利用其性质采用递归方式更高效地计算：
$$a^n = 
\begin{equation}
\left\{
\begin{array}{lr}
a^{n/2} * a^{n/2} &	n 为偶数 &  \\
a^{(n-1)/2} * a^{(n-1)/2} * a & n 为奇数 &  
\end{array}
\right.
\end{equation}$$

时间复杂度：O(lgn)

#### 代码
```java
public class Power
{
    /**
     * 计算数值的整数次方
     *
     * @param base     底数
     * @param exponent 指数
     * @return 计算结果
     */
    public double power(double base, int exponent)
    {
        if (base == 0 && exponent == 0)
        {
            System.out.println("0的0次方无意义");
            return 0;
        }

        // 取指数的绝对值进行计算
        double result = powerWithRecursion(base, Math.abs(exponent));

        // 若指数为负则取倒数
        return exponent < 0 ? 1.0 / result : result;
    }

    /**
     * 利用乘方的性质递归求解
     *
     * @param base     底数
     * @param exponent 指数
     * @return 计算结果
     */
    public double powerWithRecursion(double base, int exponent)
    {
        if (exponent == 0)
        {
            return 1;
        }

        if (exponent == 1)
        {
            return base;
        }

        // 递归求出一半的乘方值
        double result = powerWithRecursion(base, exponent >> 1);

        // 平方得出结果
        result *= result;

        // 若指数为奇数，则还需乘一次底数
        return (exponent & 1) == 1 ? result * base : result;
    }
}
```



### 测试用例参考
1. 把底数和指数分别设为正数、负数和零。



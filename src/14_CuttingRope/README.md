[TOC]

## 剪绳子

给你一根长度为n绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1）。
每段的绳子的长度记为k[0]、k[1]、……、k[m]。
请问k[0]k[1]…*k[m]可能的最大乘积是多少？
例如当绳子的长度是 8 时，我们把它剪成长度分别为 2、3、3 的三段，此时得到最大的乘积18。

### 解法

#### 解法1
利用动态规划的思想：
+ 长度为 2 时，显然 $f(2) = 1$；
+ 长度为 3 时，显然 $f(3) = 2$；
+ 长度为 n 时，若第一刀剪在位置 $i$，则 $f(n) = f(i) * f(n-i)$，整体问题的最优解依赖于子问题的最优解，且子问题间互相重叠，符合动态规划的要求；
+ **状态转移方程**：$f(n) = max(f(i) * f(n-i))\quad (1 ≤i ≤ \frac n 2) $

时间复杂度：O(n^2)

空间复杂度：O(n)

#### 代码
```java
public class CuttingRope
{
    /**
     * 动态规划法
     * f(length) = max(f(i) * f(length-i))
     *
     * @param length 绳长
     * @return 最大乘积
     */
    public int maxProductAfterCuttingWithDP(int length)
    {
        if (length < 2)
        {
            return 0;
        }
        if (length == 2)
        {
            return 1;
        }
        if (length == 3)
        {
            return 2;
        }

        int res[] = new int[length + 1];
        res[1] = 1;
        res[2] = 2;
        res[3] = 3;

        int max = 0;
        for (int i = 4; i <= length; i++)
        {
            max = 0;
            for (int j = 1; j <= i / 2; j++)
            {
                max = Math.max(max, res[j] * res[i - j]);
            }
            res[i] = max;
        }

        return res[length];
    }
}
```



#### 解法2
根据数学计算得出最优方案，然后利用贪心思想：
+ 当绳长5 时，先尽可能多地剪长度为 3 的绳子；
+ 当剩下的绳子长度为 4 时，即 $n \% 3 = 1$，则将绳子剪成两段长度为 2 的绳子

时间复杂度：O(1)

空间复杂度：O(1)

#### 代码
```java
public class CuttingRope
{
    /**
     * 贪心法
     * 根据数学计算得到最优方案
     *
     * @param length 绳长
     * @return 最大乘积
     */
    public int maxProductAfterCuttingWithGreed(int length)
    {
        if (length < 2)
        {
            return 0;
        }
        if (length == 2)
        {
            return 1;
        }
        if (length == 3)
        {
            return 2;
        }

        int timeOf3 = length / 3;
        if (length % 3 == 1)
        {
            timeOf3--;
        }
        int timeOf2 = (length - 3 * timeOf3) >> 1;

        return (int) (Math.pow(3, timeOf3) * Math.pow(2, timeOf2));
    }
}
```



### 测试用例参考
1. 功能测试（绳子的初始长度大于 5）；
2. 边界值测试（绳子的初始长度分别为 0、1、2、3、4）。
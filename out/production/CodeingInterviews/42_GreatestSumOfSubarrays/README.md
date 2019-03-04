[TOC]

## 连续子数组的最大和

输入一个非空整型数组，数组里的数可能为正，也可能为负。 
数组中一个或连续的多个整数组成一个子数组。求所有子数组的和的最大值。
要求时间复杂度为O(n)。

### 解法

#### 解法1
+ 从左往右不断将元素累加，**只要累加值不为负，即使当前数为负数也继续加**，因为后面可能会有正数来弥补；
+ 若累加值为负，则加上这段子数组必定会使得原始值变小，因此全部丢弃

#### 代码
```java
public class GreatestSumOfSubarrays
{
    /**
     * 求连续子数组的最大和
     *
     * @param array 数组
     * @return 最大和
     */
    public int findGreatestSumOfSubArray(int[] array)
    {
        if (array == null || array.length < 1)
        {
            return 0;
        }

        int max = Integer.MIN_VALUE, curSum = 0;
        for (int i = 0; i < array.length; i++)
        {
            // 累计和为负，则重新开始计算
            if (curSum <= 0)
            {
                curSum = array[i];
            }

            // 只要累计和为正，即使当前数为负数也继续加，因为后面可能会有正数
            else
            {
                curSum += array[i];
            }

            if (curSum > max)
            {
                max = curSum;
            }
        }
        return max;
    }
}
```



#### 解法2
+ 利用动态规划思想：
  1. 当以第 i - 1个数字结尾的子数组的累加值小于0，则第 i 个数与其相加后反而变小，因此不如不加，从第 i 个数开始重新计算；
  2. 否则显然直接累加


#### 代码
```java
public class GreatestSumOfSubarrays
{ 
    /**
      * 求连续子数组的最大和
      *
      * @param array 数组
      * @return 最大和
      */
     public int findGreatestSumOfSubArrayWithDP(int[] array)
     {
         if (array == null || array.length < 1)
         {
             return 0;
         }
 
         int dp = array[0], max = dp;
         for (int i = 1; i < array.length; i++)
         {
             // 递推式，若前面i-1个数的累计和大于0，显然直接加上第i个值
             // 若小于0，加上反而更小，因此第i个值本身为最大
             dp = dp > 0 ? dp + array[i] : array[i];
             max = Math.max(dp, max);
         }
         return max;
     }
}
```



### 测试用例参考
1. 功能测试（输入的数组中有正数也有负数；输入的数组中全是正数；输入的数组中全是负数）；
2. 特殊输入测试（表示数组的指针位为空指针）。
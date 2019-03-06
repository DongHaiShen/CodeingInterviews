[TOC]

## 股票的最大利润

假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可获得的最大利润是多少？

### 解法
+ 因为必须先买入一次股票后才能卖出，且利润为两次数字之差，因此**最大利润就是数组中所有数对的最大差值**；
+ 可以用暴力法找出所有数对，然后求其中最大差值，但复杂度为O(n^2)；
+ 为了减少不必要的比较，可以**用一个变量保存数组前 n 个元素中的最小值**，即之前股票的最低价，然后即可计算出在当前价位买入股票的最大利润


#### 代码
```java
public class MaximalProfit
{
    /**
     * 股票的最大利润
     *
     * @param numbers 数组
     * @return 最大利润
     */
    public int maxDiff(int[] numbers)
    {
        if (numbers == null || numbers.length < 2)
        {
            return 0;
        }

        int min = numbers[0], maxDiff = numbers[1] - min;

        for (int i = 2; i < numbers.length; i++)
        {
            // 记录前i-1个数字中的最小值，即之前股票最低价
            if (numbers[i - 1] < min)
            {
                min = numbers[i - 1];
            }
            maxDiff = Math.max(maxDiff, numbers[i] - min);
        }
        return maxDiff;
    }
}
```



### 测试用例参考
1. 功能测试（存储股票价格的数组无序、单调递增、单调递减）；
2. 边界值测试（存储股票价格的数组中只有两个数字）；
3. 特殊输入测试（数组为null）
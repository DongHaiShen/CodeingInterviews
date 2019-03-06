[TOC]

## n个骰子的点数

把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。
输入n，打印出s的所有可能的值出现的概率

### 解法
+ 用两个数组来存储骰子点数的每个总数出现的**次数**；
+ 第一个数组的第 n 个数字表示骰子和为 n 出现的总次数；
+ 第二个数组的第 n 个数字是上一个数组对应的第 (n - 1) ~ (n - 6) 个数字之和，因为它们分别加上 1 ~6 即可得到 n；
+ 最后把次数除以总排列数即可得到概率


#### 代码
```java
public class ContinousCards
{
    /**
     * 判断牌是否连续
     *
     * @param numbers 数组
     * @return 判断结果
     */
    public boolean isContinuous(int[] numbers)
    {
        if (numbers == null || numbers.length == 0)
        {
            return false;
        }

        // 先排序
        Arrays.sort(numbers);

        // 统计0的个数
        int zeroCount = 0;
        for (int e : numbers)
        {
            if (e == 0)
            {
                zeroCount++;
            }
        }

        // 王最多只有4张
        if (zeroCount > 4)
        {
            return false;
        }

        // 统计总空缺值
        int gap = 0;
        for (int i = zeroCount; i < numbers.length - 1; i++)
        {
            if (numbers[i] == numbers[i + 1])
            {
                return false;
            }
            gap += numbers[i + 1] - numbers[i] - 1;
        }

        // 0的个数是否足以填补空缺值
        return zeroCount >= gap;
    }
}
```



### 测试用例参考
1. 功能测试（1、2、3、4个骰子的各点数概率）；
2. 特殊输入测试（输入0）；
3. 性能测试（输入较大的数字，如11）
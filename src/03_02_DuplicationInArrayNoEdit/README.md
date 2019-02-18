[TOC]

## 数组中重复的数字 （不修改原数组）

### 题目描述
在一个长度为 n+1 的数组里的所有数字都在 1 到 n 的范围内，所以数组中至少有一个数字是重复的。
请找出数组中任意一个重复的数字，但不能修改输入的数组。
例如，如果输入长度为 8 的数组 {2, 3, 5, 4, 3, 2, 6, 7}，那么对应的输出是重复的数字 2 或者 3

### 解法

#### 解法1
此题和03_01的区别在于不能对原数组进行修改，因此03_01中交换数字的方法不可行。
而**使用哈希表作为辅助**的方式依然可行，与03_01中类似。

时间复杂度： O(n)

空间复杂度：O(n)



#### 解法2
+ 数组中数字的范围是 [1,n]，考虑将该范围分为 [1, middle]和[middle, n]，然后统计原数组中有多少数字在[1, middle]之间
+ 若统计结果 $count$ > 该区间内的数字个数，说明该区间内存在重复的数字
+ 否则在另一半数字区间中继续查找，步骤类似二分查找

时间复杂度：O(nlgn)，调用统计函数共 lgn 次，每次统计需要O(n)

空间复杂度：O(1)，时间换空间

**注意：该方法不能保证找出所有重复的数字**

#### 代码
```java
public class DuplicationInArrayNoEdit
{
    /**
     * 查找数组中的重复元素，要求不能修改原数组
     *
     * @param numbers 待查数组
     * @return 找到的重复元素，-1表示未找到或非法情况
     */
    public int getDuplication(int[] numbers)
    {
        // 判断数组及其长度是否合法
        if (numbers == null || numbers.length <= 1)
        {
            return -1;
        }

        // 判断数组内部的数字是否在 [1，length - 1]之间
        for (int i = 0; i < numbers.length; i++)
        {
            if (numbers[i] < 1 || numbers[i] > numbers.length - 1)
            {
                return -1;
            }
        }

        int start = 1, end = numbers.length - 1;
        int middle, count;
        while (start <= end)
        {
            middle = (end - start) / 2 + start;
            count = countRange(numbers, start, middle);

            if (start == end)
            {
                if (count > 1)
                {
                    return start;
                }
                else
                {
                    break;
                }
            }

            // 该方法不能保证找到所有重复的数字
            if (count > middle - start + 1)
            {
                end = middle;
            }
            else
            {
                start = middle + 1;
            }
        }
        return -1;
    }

    /**
     * 计算在整个数组中有多少数字位于[start,end]之间
     *
     * @param numbers 待计算数组
     * @param start   判断上界
     * @param end     判断下界
     * @return 数量
     */
    public int countRange(int[] numbers, int start, int end)
    {
        if (numbers == null)
        {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < numbers.length; i++)
        {
            if (numbers[i] >= start && numbers[i] <= end)
            {
                count++;
            }
        }
        return count;
    }
}
```



### 测试用例参考
1. 长度为 n 的数组中包含一个或多个重复的数字
2. 数组中不包含重复的数字
3. 无效测试输入用例（输入空指针）
[TOC]

## 数组中出现次数超过一半的数字

数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
例如输入一个长度为 9 的数组 {1,2,3,2,2,2,5,4,2}。由于数字 2 在数组中出现了 5 次，超过数组长度的一半，因此输出 2。
如果不存在则输出 0。

### 解法

#### 解法1（修改原数组）
+ 利用该数组的特性：若存在一个数字的出现次数超过一半，**则说明该数出现次数比其他所有数出现次数之和还要多**；
+ 因为维护两个值：一个是当前记录值 `result`，另一个是该值的相对次数 `count`；
+ 若下一个值与 `count` 相同，则加1，不同则减1；
+ 当 `count` 减为0，取下一个值替换 `result`，并重置 `count` 为1

时间复杂度：O(n)


#### 代码
```java
public class MoreThanHalfNumber
{
    /**
     * 查找数组中出现次数超过一半的数字
     *
     * @param array 数组
     * @return 若有则返回该值，没有返回0
     */
    public int moreThanHalfNum(int[] array)
    {
        if (array == null || array.length == 0)
        {
            return 0;
        }

        int result = array[0], count = 1;
        for (int i = 0; i < array.length; i++)
        {
            if (count == 0)
            {
                result = array[i];
                count = 1;
            }
            else if (result == array[i])
            {
                count++;
            }
            else
            {
                count--;
            }
        }

        // 检验该数是否真的超过一半次数
        count = 0;
        for (int n : array)
        {
            if (n == result)
            {
                count++;
            }
        }
        return count * 2 > array.length ? result : 0;
    }
}
```



#### 解法2（不修改原数组）
+ **出现次数超过一半的数，排序后必定是中位数**，即问题转换为求数组中第 `array.length/2` 大的数；
+ 利用快排思想，选取一个数为基准，把比它大的放到右边，比它小的放到左边；
+ 若调整后基准位于 `array.length/2` ，则直接返回；
+ 若大于则递归往左寻找，若小于则递归往右寻找

时间复杂度：O(n)


#### 代码
```java
public class MoreThanHalfNumberWithPartition
{
    /**
     * 查找数组中出现次数超过一半的数字
     *
     * @param array 数组
     * @return 若有则返回该值，没有返回0
     */
    public int moreThanHalfNum(int[] array)
    {
        if (array == null || array.length == 0)
        {
            return 0;
        }

        int start = 0, end = array.length - 1, middle = array.length >> 1;
        int index = partition(array, start, end);

        // 次数超过一半的数，排序后必定是中位数
        while (index != middle)
        {
            // 选中数字在中位数右边，往左继续找
            if (index > middle)
            {
                end = index - 1;
                index = partition(array, start, end);
            }

            // 选中数字在中位数左边，往右继续找
            else
            {
                start = index + 1;
                index = partition(array, start, end);
            }

        }

        // 检验该数是否真的超过一半次数
        int count = 0;
        for (int n : array)
        {
            if (n == array[index])
            {
                count++;
            }
        }
        return count * 2 > array.length ? array[index] : 0;
    }

    /**
     * 快排partition过程
     *
     * @param array 数组
     * @param start 起始位置
     * @param end   结束位置
     * @return 基准元素位置
     */
    public int partition(int[] array, int start, int end)
    {
        int index = start - 1;
        for (int i = start; i < end; ++i)
        {
            if (array[i] < array[end])
            {
                swap(array, i, ++index);
            }
        }
        ++index;
        swap(array, index, end);
        return index;
    }

    /**
     * 交换两个数字
     *
     * @param array 数组
     * @param i     位置i
     * @param j     位置j
     */
    public void swap(int[] array, int i, int j)
    {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}
```



### 测试用例参考
1. 功能测试（输入的数组中存在/不存在一个出现次数超过数组长度一半的数字）；
2. 特殊输入测试（输入的数组只有一个数字；输入空指针）。

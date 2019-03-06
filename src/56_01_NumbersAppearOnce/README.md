[TOC]

## 数组中只出现一次的两个数字

一个整型数组里除了两个数字之外，其他的数字都出现了两次。
请写程序找出这两个只出现一次的数字。
你可以假设这两个数字一定存在。

### 解法
+ 首先，如果数组中**只有一个出现了一次**的数字，其他都出现两次，那么可以通过**异或全部数字**得到。因为**任何一个数字异或自身为0，0异或任何数字为其本身**。
+ 现在有两个出现了一次的数字，具体方法为：
  1. 首先也是把全部数字进行异或，那么结果应当为**所求两个数字的异或**（其他都成对消除）；
  2. 既然两个数字不同，**因此至少有一位上不都为0或1，即在异或结果中该位为1**；
  3. 找出异或结果中第一个为 1 的位置下标 `index`，然后**把原始数字按 `index` 位是否为1进行分组**，那么必定可以把所求两个数字分开到两组中；
  4. 分开后问题转化为数组中**只有一个出现了一次**的数字，分别全部异或即可。


#### 代码
```java
public class NumbersAppearOnce
{
    /**
     * 求数组中只出现一次的两个数字
     *
     * @param array 数组
     * @param num1  保存数字1
     * @param num2  保存数字2
     */
    public void findNumsAppearOnce(int[] array, int num1[], int num2[])
    {
        if (array == null || array.length < 2)
        {
            return;
        }

        // 先求所有数字的异或，结果为两个只出现一次数字的异或
        int exclusiveOr = 0;
        for (int i = 0; i < array.length; i++)
        {
            exclusiveOr ^= array[i];
        }

        // 因为数字不同，因此至少有一位上不都为0或1
        // 即在异或结果中该位为1
        int indexOfOne = findIndexOfOne(exclusiveOr);
        num1[0] = 0;
        num2[0] = 0;
        for (int i = 0; i < array.length; i++)
        {
            // 根据该位是否为1进行分组，两个分组中恰好各包含一个所求数字
            // 再通过异或进行求解
            if (isBitOne(array[i], indexOfOne))
            {
                num1[0] ^= array[i];
            }
            else
            {
                num2[0] ^= array[i];
            }
        }
    }

    /**
     * 找出第一个为 1的位置
     *
     * @param num 数字
     * @return 位置下标
     */
    public int findIndexOfOne(int num)
    {
        int index = 0;
        while ((num & 1) == 0)
        {
            num = num >> 1;
            index++;
        }
        return index;
    }

    /**
     * 判断数字第 index 位是否为 1
     *
     * @param num   数字
     * @param index 第 index 位
     * @return 判断结果
     */
    public boolean isBitOne(int num, int index)
    {
        num = num >> index;
        return (num & 1) == 1;
    }
}
```



### 测试用例参考
1. 功能测试（数组中有多对重复的数字；数组中没有重复的数字）。
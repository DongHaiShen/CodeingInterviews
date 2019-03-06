[TOC]

## 数组中唯一只出现一次的数字

在一个数组中除了一个数字只出现一次之外，其他数字都出现了三次。
请找出那个只出现一次的数字。
你可以假设满足条件的数字一定存在。

### 解法
+ 这里因为所求数字虽然只出现一次，但其他数字出现三次，因此异或运算无法消除其他数字；
+ 可以统计所有数字在每一位上的总和，因为其他数字都出现了三次，因此**若某一位上的总和能被3整除，则所求数字该位为0，否则为1**；
+ 在实现时可以**从后往前计算**，防止负数溢出


#### 代码
```java
public class NumberAppearingOnce
{
    /**
     * 找出数组中只出现一次的数字，其它数字都出现三次
     *
     * @param nums 数组
     * @return 只出现一次的数字
     */
    public int findNumberAppearingOnce(int[] nums)
    {
        if (nums == null || nums.length == 0)
        {
            return 0;
        }

        int[] bits = new int[32];
        int cur;

        // 统计所有数字在每一位上的总和
        for (int i = 0; i < nums.length; i++)
        {
            cur = nums[i];
            for (int j = 0; j < 32; j++)
            {
                bits[j] += (cur & 1);
                cur = cur >> 1;
            }
        }

        int result = 0;

        // 若某一位上的总和能被3整除，则所求数字该位为0，否则为1
        // 从后往前计算，防止负数溢出
        for (int i = 31; i >= 0; i--)
        {
            result = result << 1;
            result += bits[i] % 3;
        }
        return result;
    }
}
```



### 测试用例参考
1. 功能测试（唯一只出现一次的数字分别是 0、正数、负数；重复出现三次的数字分别是 0、正数、负数）。
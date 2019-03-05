[TOC]

## 0到n-1中缺失的数字

一个长度为 n-1 的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围 0 到 n-1 之内。
在范围 0 到 n-1 的 n 个数字中有且只有一个数字不在该数组中，请找出这个数字。

### 解法
+ 如果不缺失数字，则每个数字与其下标相等；
+ 如果缺失数字为 m，则显然 m+1 会落在 m 的位置上， m+2 会落在 m+1 的位置上，即元素值大于其下标值；
+ 所以问题转化为**找出第一个与下标不对应的数字**即可，可用二分法进行判断


#### 代码
```java
public class MissingNumber
{
    /**
     * 获取0~n-1缺失的数字
     *
     * @param nums 数组
     * @return 缺失数
     */
    public int getMissingNumber(int[] nums)
    {
        if (nums == null || nums.length < 1)
        {
            return -1;
        }

        int start = 0, end = nums.length - 1, middle = 0;
        while (start <= end)
        {
            // 加减法优先级高于位运算
            middle = start + ((end - start) >> 1);

            // 下标和值相等，继续往右找
            if (nums[middle] == middle)
            {
                start = middle + 1;
            }
            else
            {
                // 如果找到首位，或者前一个元素的下标和值相等，则当前位置的数字缺失
                if (middle == 0 || nums[middle - 1] == middle - 1)
                {
                    return middle;
                }
                end = middle - 1;
            }
        }
        return start;
    }
}
```



### 测试用例参考
1. 功能测试（缺失的数字位于数组的开始、中间或者末尾）；
2. 边界值测试（数组中只有一个数字 0）；
3. 特殊输入测试（表示数组的指针为空指针）。
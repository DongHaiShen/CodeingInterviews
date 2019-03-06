[TOC]

## 和为S的两个数字

输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S。
如果有多对数字的和等于S，**输出两个数的乘积最小的**。
ps：对应每个测试案例，输出两个数，**小的先输出**。

### 解法
+ 利用两个指针，开始分别指向数组的头尾，计算两数之和；
+ **因为数组是递增排序的，因此若当前两数之和过大，则继续向左找，否则继续向右找**；
+ 这里因为要求当有多对符合要求的数字对时，输出乘积最小的，因此不能采用哈希表辅助查找的方式。若只需输出任意一对可以使用。


#### 代码
```java
import java.util.ArrayList;

public class TwoNumbersWithSum
{
    /**
     * 找出和为sum的两个数字
     *
     * @param array 数组
     * @param sum   两数之和
     * @return 存储结果list
     */
    public ArrayList<Integer> findNumbersWithSum(int[] array, int sum)
    {
        ArrayList<Integer> reList = new ArrayList<>();

        if (array == null || array.length == 0 || sum <= array[0])
        {
            return reList;
        }

        int start = 0, end = array.length - 1, curSum;
        while (start < end)
        {
            curSum = array[start] + array[end];
            if (curSum == sum)
            {
                reList.add(array[start]);
                reList.add(array[end]);
                return reList;
            }

            // 因为数组是递增排序的，因此若过大则向左找，过小则向右找
            else if (curSum > sum)
            {
                end--;
            }
            else
            {
                start++;
            }
        }
        return reList;
    }
}
```



### 测试用例参考
1. 功能测试（数组中存在和为 s 的两个数；数组中不存在和为 s 的两个数）；
2. 特殊输入测试（表示数组的指针为空指针）。
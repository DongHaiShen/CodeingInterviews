[TOC]

## 旋转数组的最小数字

把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个**非减**排序的数组的一个旋转，输出旋转数组的最小元素。 **(非减意味着可以有重复数字)**
例如数组 {3,4,5,1,2} 为 {1,2,3,4,5} 的一个旋转，该数组的最小值为 1。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。

### 解法

#### 解法1
直接顺序遍历寻找最小值，本身效率虽然不算低，但是没有利用到旋转数组的特性

时间复杂度：O(n)



#### 解法2 （推荐）
设指针 $left$ 和 $right$ 分别初始化为数组的首尾：
+ 如果 $array[left] < array[right]$，说明该数组本身就是递增数组，可以看成是**取0个元素进行旋转**，因此直接返回 $array[left]​$；
+ 否则计算中间指针 mid，然后进行讨论：
1. 如果此时 $array[left] = array[right] = array[mid]​$，此时无法继续采用二分方式，**因为不能确定最小值在左区域还是右区域**，**只能通过遍历数组 获取最小值**；
2. 如果 $right - left = 1$，**即左右指针相邻，则此时右指针指向最小值**，返回 $array[right]$；
3. 如果 $array[mid] >= array[left]$，**说明 mid 位于左边的递增数组中，最小值在右边**，因此设 $left = middle$；
4. 如果此时 $array[mid] <= array[right]$，**说明 mid 位于右边的递增数组中，最小值在左边**，因此设 $right = mid$。

时间复杂度：一般情况为O(lgn)，特殊情况有O(1)或O(n)


#### 代码
```java
public class MinNumberInRotatedArray
{
    /**
     * 获取旋转数组的最小元素
     *
     * @param array 旋转数组
     * @return 最小值
     */
    public int minNumberInRotateArray(int[] array)
    {
        if (array == null || array.length == 0)
        {
            return 0;
        }

        int left = 0, right = array.length - 1, middle = left;

        // 确保左指针的值始终大于右指针的值
        while (array[left] >= array[right])
        {
            //  若两个指针相邻，此时右指针指向最小值
            if (right - left == 1)
            {
                return array[right];
            }

            middle = ((right - left) >> 1) + left;

            // 1,0,1,1,1
            // 1,1,1,0,1
            // 若左指针、右指针和中间值三者的值相同，则无法继续用二分查找
            // 此时只能顺序遍历查找最小值
            if (array[middle] == array[left] && array[middle] == array[right])
            {
                return getMin(array, left, right);
            }

            // 中间值大于左指针，则最小值在右边
            if (array[middle] >= array[left])
            {
                left = middle;
            }
            // 中间值小于右指针，则最小值在左边
            else if (array[middle] <= array[right])
            {
                right = middle;
            }
        }
        return array[middle];
    }

    /**
     * 遍历查找数组最小值
     *
     * @param array 数组
     * @param start 起始位置
     * @param end   结束位置
     * @return 最小值
     */
    public int getMin(int[] array, int start, int end)
    {
        int result = array[start];
        for (int i = start + 1; i <= end; i++)
        {
            if (array[i] < result)
            {
                result = array[i];
            }
        }
        return result;
    }
}
```



### 测试用例参考
1. 功能测试（输入的数组是升序排序数组的一个旋转，数组中有重复数字或者没有重复数字）；
2. 边界值测试（输入的数组是一个升序排序的数组，只包含一个数字的数组）；
3. 特殊输入测试（输入空指针）。
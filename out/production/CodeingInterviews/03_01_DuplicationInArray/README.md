[TOC]

## 数组中重复的数字

### 题目描述
在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
请找出数组中任意一个重复的数字。
例如，如果输入长度为 7 的数组 {2, 3, 1, 0, 2, 5, 3}，那么对应的输出是重复的数字 2 或者 3

### 解法

#### 解法1
**直接先把数组排序，然后再顺序扫描一遍找到重复值**

时间复杂度：以冒泡排序为例，O(n^2) + O(n)

空间复杂度：以冒泡排序为例，O(1)



#### 解法2
**利用哈希表做辅助**，顺序扫描数组，每遇到一个数字，若哈希表中不存在则加入哈希表，否则即找到了重复的数字

时间复杂度：O(n)，相比解法1下降

空间复杂度：O(n)，相比解法1增加，空间换时间



#### 解法3 （推荐）
因为该题中数组长度为 n，且数字范围 0~n-1也为 n，即如果没有重复数字，**则排序之后每个数字所在位置的下标应当恰好等于该值本身**

因此可顺序扫描数组 $nums$，每遇到一个数字 $i$：
+ 若$nums[i] == i$，则继续；
+ 否则将 $i$ 与第 $nums[i]$ 个数字比较
  1. 若 $nums[i] == nums[ nums[i] ]$，则找到了重复数字
  2. 否则将第 $i$ 个数字和第 $nums[i]$ 个数字进行位置交换，直到 $nums[i] == i$
  3. 重复上述步骤直到数组扫描完毕

时间复杂度：O(n)

空间复杂度：O(1)

#### 代码
```java
public class DuplicationInArray
{
    /**
     * 查找数组中的重复元素
     *
     * @param numbers     待查数组
     * @param length      数组长度
     * @param duplication 在duplication[0]中存放找到的重复元素
     * @return boolean值，是否存在重复元素，非法情况也返回false
     */
    public boolean duplicate(int numbers[], int length, int[] duplication)
    {
        // 判断数组及其长度是否合法
        if (numbers == null || length <= 1)
        {
            System.out.println("数组为空或长度不合法");
            return false;
        }

        // 判断数组内部的数字是否在 [0，length - 1]之间
        for (int i = 0; i < length; i++)
        {
            if (numbers[i] < 0 || numbers[i] > length - 1)
            {
                System.out.println("数字未在合法范围内");
                return false;
            }
        }

        for (int i = 0; i < length; i++)
        {
            while (numbers[i] != i)
            {
                // 若第 i 位和第 numbers[i] 位的数字相同，则找到结果
                if (numbers[i] == numbers[numbers[i]])
                {
                    duplication[0] = numbers[i];
                    return true;
                }

                // 否则将这两位上的数字进行交换
                swap(numbers, numbers[i], i);
            }
        }

        return false;
    }

    public void swap(int numbers[], int i, int j)
    {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

}
```



### 测试用例参考
1. 长度为 n 的数组中包含一个或多个重复的数字
2. 数组中不包含重复的数字
3. 无效测试输入用例（输入空指针；长度为 n 的数组中包含 0~n-1 之外的数字）
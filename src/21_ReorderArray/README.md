[TOC]

## 调整数组顺序使奇数位于偶数前面

输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分
**新增条件**：并保证奇数和奇数，偶数和偶数之间的相对位置不变。

### 解法

#### 解法1（无新增条件版）
如果不考虑新增条件，即无需保持调整前后数字间的相对位置，则可以使用前后两个指针，左指针从左往右找偶数，右指针从右往左找奇数，然后交换

#### 代码
```java
public class ReorderArray
{
    /**
     * 调整数组顺序（无新增条件版）
     *
     * @param array 数组
     */
    public void reOrderArrayWithSwap(int[] array)
    {
        if (array == null || array.length < 2)
        {
            return;
        }

        int start = 0, end = array.length - 1;

        // 从左往右找偶数，从右往左找奇数，然后交换
        while (start < end)
        {
            while (start < end && judge(array[start]))
            {
                start++;
            }
            while (start < end && !judge(array[end]))
            {
                end--;
            }

            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
        }
    }

    /**
     * 调整顺序的判断条件，单独取出增加扩展性
     * 此处为判断是否是奇数
     *
     * @param n 数字
     * @return 判断结果
     */
    public boolean judge(int n)
    {
        return (n & 1) == 1;
    }
}
```



#### 解法2（有新增条件版）
如果考虑新增条件，即需要保持调整前后数字间的相对位置，则可以先顺序扫描统计有多少个奇数，然后再顺序扫描将奇数和偶数放入对应的位置

#### 代码
```java
public class ReorderArray
{
   /**
     * 调整数组顺序（有新增条件版）
     *
     * @param array 数组
     */
    public void reOrderArrayWhileKeepOrder(int[] array)
    {
        if (array == null || array.length < 2)
        {
            return;
        }

        // 先统计有多少个奇数
        int count = 0;
        for (int i = 0; i < array.length; i++)
        {
            if (judge(array[i]))
            {
                count++;
            }
        }

        // 然后按位置排放
        int[] copy = new int[array.length];
        int indexOfOdd = 0, indexOfEven = count;
        for (int i = 0; i < array.length; i++)
        {
            if (judge(array[i]))
            {
                copy[indexOfOdd++] = array[i];
            }
            else
            {
                copy[indexOfEven++] = array[i];
            }
        }

        for (int i = 0; i < array.length; i++)
        {
            array[i] = copy[i];
        }
    }
    
    /**
     * 调整顺序的判断条件，单独取出增加扩展性
     * 此处为判断是否是奇数
     *
     * @param n 数字
     * @return 判断结果
     */
    public boolean judge(int n)
    {
        return (n & 1) == 1;
    }
}
```


### 测试用例参考
1. 功能测试（输入数组中的奇数、偶数交替出现；输入的数组中所有偶数都出现在奇数的前面；输入的数组中所有偶数都出现在奇数的前面；输入的数组中所有奇数都出现在偶数的前面）；
2. 特殊输入测试（输入空指针；输入的数组只包含一个数字）。



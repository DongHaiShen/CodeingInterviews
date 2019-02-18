[TOC]

## 二维数组中的查找

### 题目描述
在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

### 解法
该题中的二维数组具有特殊性，即保证每行从左到右递增，每列从上到下递增

因此可**从该数组的右上角开始查找**，记当前值为 $current$，目标值为 $target$：
+ 若 $current == target$，则找到返回true；
+ 若 $current >  target$，则说明该**列**的值均大于 $target$，可排除该列；
+ 若 $current <  target$，则说明该**行**的值均小于 $target$，可排除该行；

当然也可以从该数组的**左下角**开始查找，不过需要修改对应逻辑

时间复杂度：O(n)

空间复杂度：O(1)

#### 代码
```java
public class FindInPartiallySortedMatrix
{
    /**
     * 在给定的二维数组内查找
     *
     * @param target 待查找的值
     * @param array  待查数组
     * @return boolean值，是否找到
     */
    public boolean find(int target, int[][] array)
    {
        if (array == null)
        {
            return false;
        }

        // 查找范围边界
        int rows = array.length, cols = array[0].length;

        // 查找起始点，即最右上角
        // 也可选取左下角，需要修改后续逻辑
        int row = 0, col = cols - 1;

        // 注意边界
        while (row < rows && col >= 0)
        {
            if (array[row][col] == target)
            {
                return true;
            }
            else if (array[row][col] > target)
            {
                // 右上角的值大于待查找的值，则可排除该列
                col--;
            }
            else
            {
                // 右上角的值小于待查找的值，则可排除该行
                row++;
            }
        }
        return false;
    }
}
```



### 测试用例参考
1. 二维数组中包含查找的数字（查找的数字是数组中的最大值和最小值；查找的数字介于数组中的最大值和最小值之间）；
2. 二维数组中没有查找的数字（查找的数字大于或小于数组中的最大值；查找的数字在数组的最大值和最小值之间但数组中没有这个数字）；
3. 特殊输入测试（输入空指针）。
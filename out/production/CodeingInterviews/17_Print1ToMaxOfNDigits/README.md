[TOC]

## 打印从1到最大的n位数

输入数字 n，按顺序打印出从 1 最大的 n 位十进制数。
比如输入 3，则打印出 1、2、3 一直到最大的 3 位数即 999。

### 解法

#### 解法1
因为本题中 n 位数构成的数字可能超出 int 或long long 等能表示的范围，因此需要使用字符数组：
+ 常规想法是利用数组存储 n 位数，然后模拟加法操作不断递增输出；
+ 在输出时需要将前面的 0 去掉，符合阅读习惯；
+ 不过该方法实现较复杂，难以快速编写出结果



#### 解法2
把问题转化为**数字的全排列**：
+ 即在每一位上都用 0~9排列一次，即可得到全部结果；
+ 可利用递归进行实现

#### 代码
```java
public class Print1ToMaxOfNDigits
{
    /**
     * 打印从1到最大的n位数
     *
     * @param n 位数
     */
    public void printOneToMaxOfNthDigits(int n)
    {
        // 输入的数字不能小于1
        if (n < 1)
        {
            System.out.println("输入位数非法");
        }

        int[] arr = new int[n];
        printOneToMaxOfNthDigitsRecursively(0, arr);
    }

    /**
     * 把问题转化为数字的全排列，利用递归求解
     *
     * @param n   当前处理的是第n个元素
     * @param arr 存放结果的数组
     */
    public void printOneToMaxOfNthDigitsRecursively(int n, int[] arr)
    {

        if (n >= arr.length)
        {
            printArray(arr);
        }
        else
        {
            for (int i = 0; i <= 9; i++)
            {
                arr[n] = i;
                printOneToMaxOfNthDigitsRecursively(n + 1, arr);
            }
        }
    }

    /**
     * 输出数组中的元素
     *
     * @param arr 数组
     */
    public void printArray(int[] arr)
    {
        // 找到第一个非0的元素
        int index = 0;
        while (index < arr.length && arr[index] == 0)
        {
            index++;
        }

        // 从第一个非0值到开始输出到最后的元素
        for (int i = index; i < arr.length; i++)
        {
            System.out.print(arr[i]);
        }

        // 存在非零元素输出，则换行
        if (index < arr.length)
        {
            System.out.println();
        }
    }
}
```



### 测试用例参考
1. 功能测试（输入 1、2、3......）；
2. 特殊输入测试（输入 -1、0）。



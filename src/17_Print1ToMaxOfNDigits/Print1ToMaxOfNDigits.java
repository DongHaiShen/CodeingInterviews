/**
 * @Author sdh
 * @Date Created in 2019/2/25 10:59
 * @description
 */

/**
 * 【题目】 打印从 1 到最大的 n 位数
 * <p>
 * 输入数字 n，按顺序打印出从 1 最大的 n 位十进制数。
 * 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数即 999。
 */
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

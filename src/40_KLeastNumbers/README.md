[TOC]

## 获取数组中最小的k个数

输入 n 个整数，找出其中最小的 K 个数。
例如输入 4,5,1,6,2,7,3,8 这 8 个数字，则最小的 4 个数字是 1,2,3,4。

### 解法

#### 解法1（修改原数组）
+ 采用和 39 中解法2类似的方式，不过问题转换为求数组中第 k 大的数；
+ 得到第 k 大数的位置 `index` 后，因为采用了 `Partition` 的方法，因此最小的 k 个数都在 `index` 左边，**但不一定是排序的**；

时间复杂度：O(n)


#### 代码
```java
import java.util.ArrayList;

public class KLeastNumbersWithPartition
{
    /**
     * 获取数组中最小的k个数
     *
     * @param input 输入的数组
     * @param k     最小元素个数
     * @return 最小的k个数
     */
    public ArrayList<Integer> getLeastNumbers(int[] input, int k)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || input.length == 0 || input.length < k || k < 1)
        {
            return result;
        }

        int start = 0, end = input.length - 1;
        int index = partition(input, start, end);

        while (index != k - 1)
        {
            if (index > k - 1)
            {
                end = index - 1;
                index = partition(input, start, end);
            }
            else
            {
                start = index + 1;
                index = partition(input, start, end);
            }
        }

        for (int i = 0; i < k; i++)
            result.add(input[i]);

        return result;
    }

    /**
     * 快排partition过程
     *
     * @param array 数组
     * @param start 起始位置
     * @param end   结束位置
     * @return 基准元素位置
     */
    public int partition(int[] array, int start, int end)
    {
        int index = start - 1;
        for (int i = start; i < end; ++i)
        {
            if (array[i] < array[end])
            {
                swap(array, i, ++index);
            }
        }
        ++index;
        swap(array, index, end);
        return index;
    }

    /**
     * 交换两个数字
     *
     * @param array 数组
     * @param i     位置i
     * @param j     位置j
     */
    public void swap(int[] array, int i, int j)
    {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}
```



#### 解法2（不修改原数组）
+ **创建一个大小为 k 的容器来存储最小的 k 个数**，具体操作为：
  1. 每读入一个新数 n ;
  2. 若容器未满则直接加入；
  3. 若容器已满，且 n 小于容器中的最大值，则替换该最大值
+ 上述方式的重点在于如何快速调整容器，这里采用**大根堆**，每次操作只需 O(lgk)

时间复杂度：O(nlgk)


#### 代码
```java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KLeastNumbersWithHeap
{
    /**
     * 获取数组中最小的k个数
     *
     * @param input 输入的数组
     * @param k     最小元素个数
     * @return 最小的k个数
     */
    public ArrayList<Integer> getLeastNumbers(int[] input, int k)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || input.length == 0 || input.length < k || k < 1)
        {
            return result;
        }

        // 大根堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int n : input)
        {
            if (maxHeap.size() < k)
            {
                maxHeap.add(n);
            }
            else
            {
                if (maxHeap.peek() > k)
                {
                    maxHeap.poll();
                    maxHeap.add(n);
                }
            }
        }

        result.addAll(maxHeap);
        return result;
    }
}
```



### 测试用例参考
1. 功能测试（输入的数组中存在/不存在一个出现次数超过数组长度一半的数字）；
2. 特殊输入测试（输入的数组只有一个数字；输入空指针）。

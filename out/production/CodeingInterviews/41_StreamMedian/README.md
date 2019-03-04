[TOC]

## 数据流中的中位数

如何得到一个数据流中的中位数？
如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。

### 解法

#### 解法1
+ 使用两个堆，最小堆存放较大的一半元素，最大堆存放较小的一半元素；
+ 每次插入数据后，始终维持两个堆的元素数量之差不超过1；
+ 最终数量较多的堆的堆顶元素（或两个堆的平均值）即为中位数

时间复杂度：插入O(lgn)，获取O(1)

#### 代码
```java
import java.util.Comparator;
import java.util.PriorityQueue;

public class StreamMedian
{
    // 使用两个堆，最小堆存放较大的一半元素，最大堆存放较小的一半元素
    public PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    /**
     * 插入新数
     *
     * @param num 新数
     */
    public void insert(Integer num)
    {
        // 始终保持两个堆的元素数量之差不超过1
        if (maxHeap.isEmpty() || num < maxHeap.peek())
        {
            maxHeap.offer(num);
            if (maxHeap.size() - minHeap.size() > 1)
            {
                minHeap.offer(maxHeap.poll());
            }
        }
        else
        {
            minHeap.offer(num);
            if (minHeap.size() - maxHeap.size() > 1)
            {
                maxHeap.offer(minHeap.poll());
            }
        }
    }

    /**
     * 获取中位数
     *
     * @return 中位数
     */
    public Double getMedian()
    {
        // 堆顶元素即为中位数
        int sizeOfMax = maxHeap.size();
        int sizeOfMin = minHeap.size();
        if (sizeOfMax > sizeOfMin)
        {
            return (double) maxHeap.peek();
        }
        if (sizeOfMax < sizeOfMin)
        {
            return (double) minHeap.peek();
        }

        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
```



#### 其他解法分析
1. 利用数组来存储数据：
  + **每次把新数直接放入数组**，只需O(1)，查找时利用 39 的解法2，需要 O(n)；
  + 每次插入数据后进行排序，只要O(n)，但获取时只需 O(1)；
2. 利用链表来存：插入需 O(n)，获取只需 O(1)，可以维护一个指向中间节点的指针；
3. 利用二叉搜索树：插入和获取平均需 O(lgn)，最差退化为链表需 O(n)；
4. 为避免二叉搜索树最差情况，改用AVL树，插入O(lgn)，获取 O(1)；



|  采用方式  |      插入复杂度      |      获取复杂度      |
| :--------: | :------------------: | :------------------: |
| 不排序数组 |         O(1)         |         O(n)         |
|  排序数组  |         O(n)         |         O(1)         |
|  排序链表  |         O(n)         |         O(1)         |
| 二叉搜索树 | 平均O(lgn)，最差O(n) | 平均O(lgn)，最差O(n) |
|   AVL树    |        O(lgn)        |         O(1)         |
| 最大最小堆 |        O(lgn)        |         O(1)         |



### 测试用例参考
1. 功能测试（从数据流中读出奇数/偶数个数字）；
2. 边界值测试（从数据流中读出 0/1/2 个数字）。

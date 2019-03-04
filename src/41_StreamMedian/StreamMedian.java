import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author sdh
 * @Date Created in 2019/3/4 15:46
 * @description
 */

/**
 * 【题目】 数据流中的中位数
 * <p>
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
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

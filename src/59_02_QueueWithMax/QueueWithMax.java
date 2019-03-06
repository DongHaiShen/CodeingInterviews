import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author sdh
 * @Date Created in 2019/3/6 15:48
 * @description
 */

/**
 * 【题目】 队列的最大值
 * <p>
 * 请定义一个队列并实现函数max得到队列里的最大值，要求函数max,push_back和pop_front的时间复杂度都是O(1)
 */
public class QueueWithMax
{
    public Deque<Integer> dataDeque = new LinkedList<>();
    public Deque<Integer> maxDeque = new LinkedList<>();

    /**
     * 入队
     *
     * @param number 数值
     */
    public void offer(int number)
    {
        dataDeque.offerLast(number);
        while (!maxDeque.isEmpty() && maxDeque.getLast() < number)
        {
            maxDeque.pollLast();
        }
        maxDeque.offerLast(number);
    }

    /**
     * 出队
     */
    public void poll()
    {
        if (!dataDeque.isEmpty())
        {
            if (dataDeque.peekFirst() == maxDeque.peekFirst())
            {
                maxDeque.pollFirst();
            }
            dataDeque.pollFirst();
        }
        else
        {
            throw new RuntimeException("Queue is empty!");
        }
    }

    /**
     * 队列最大值
     *
     * @return 最大值
     */
    public int max()
    {
        if (!maxDeque.isEmpty())
        {
            return maxDeque.peekFirst();
        }
        else
        {
            throw new RuntimeException("Queue is empty!");
        }
    }
}

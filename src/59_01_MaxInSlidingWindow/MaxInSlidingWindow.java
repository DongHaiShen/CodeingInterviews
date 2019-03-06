import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author sdh
 * @Date Created in 2019/3/6 14:43
 * @description
 */

/**
 * 【题目】 滑动窗口的最大值
 * <p>
 * 给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。
 * 例如，如果输入数组 [2, 3, 4, 2, 6, 2, 5, 1] 及滑动窗口的大小 3
 * 那么一共存在 6 个滑动窗口，它们的最大值分别为 [4, 4, 6, 6, 6, 5]。
 */
public class MaxInSlidingWindow
{
    /**
     * 滑动窗口的最大值
     *
     * @param num  数组
     * @param size 滑动窗口的大小
     * @return 最大值list
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if (num == null || num.length < size || size < 1)
        {
            return result;
        }

        // 使用双端队列，因为头尾都可能删除
        // 队列中存储的是下标
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < num.length; i++)
        {
            // 队尾元素比要入队的元素小，则将其移除（因为其已经不可能成为窗口最大值）
            while (!deque.isEmpty() && num[deque.getLast()] < num[i])
            {
                deque.pollLast();
            }

            // 队首元素已经不在当前窗口内，则将其移除
            while (!deque.isEmpty() && deque.getFirst() < i - size + 1)
            {
                deque.pollFirst();
            }

            // 加入最新值
            deque.offer(i);

            // 当滑动窗口的首地址大于size就开始写入
            if (!deque.isEmpty() && i + 1 >= size)
            {
                result.add(num[deque.getFirst()]);
            }
        }
        return result;
    }
}

[TOC]

## 滑动窗口的最大值

给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。
例如，如果输入数组 [2, 3, 4, 2, 6, 2, 5, 1] 及滑动窗口的大小 3
那么一共存在 6 个滑动窗口，它们的最大值分别为 [4, 4, 6, 6, 6, 5]。

### 解法
+ 使用一个双端队列，队中只存放那些**有可能成为窗口最大值**的元素**下标**，从而减少比较次数；
+ 如果队尾元素比要入队的元素小，则将其移除（因为其已经不可能成为窗口最大值）；
+ 如果队首元素已经不在当前窗口内，则将其移除；
+ 经过前两步，此时加入队列的下标要么是当前窗口最大元素的下标，要么是之后可能成为最大元素的下标；
+ 当滑动窗口的首地址大于size就开始写入


#### 代码
```java
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

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
```



### 测试用例参考
1. 功能测试（输入数组的数字大小无序；输入数组的数字单调递增；输入数组的数字单调递减）；
2. 边界值测试（滑动窗口的大小为 0、1、等于输入数组的长度、大于输入数组的长度）；
3. 特殊输入测试（输入数组为空）。
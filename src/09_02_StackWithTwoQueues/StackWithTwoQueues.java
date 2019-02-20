import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author sdh
 * @Date Created in 2019/2/20 22:29
 * @description
 */

/**
 * 【题目】 用两个队列实现栈
 * <p>
 * 用两个队列来实现一个栈，完成栈的 Push 和 Pop 操作。
 * 栈中的元素为int类型。
 */
public class StackWithTwoQueues
{
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    /**
     * 入栈操作，每次都存入queue1
     *
     * @param node 新入栈的值
     */
    public void push(int node)
    {
        queue1.offer(node);
    }

    /**
     * 出栈操作，每次都从queue1取
     *
     * @return 出栈的值
     */
    public int pop()
    {
        if (queue1.isEmpty())
        {
            System.out.println("当前栈为空");
            return -1;
        }

        // 将queue1中的值依次压入queue2，直至剩下最后一个，即出栈值
        while(queue1.size() > 1)
            queue2.offer(queue1.poll());

        int val = queue1.poll();

        // 交换queue1和queue2，使得每次都从queue1中进行存取
        Queue temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return val;
    }
}

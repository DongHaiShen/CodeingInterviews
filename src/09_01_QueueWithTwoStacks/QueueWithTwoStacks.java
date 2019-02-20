import java.util.Stack;

/**
 * @Author sdh
 * @Date Created in 2019/2/20 21:20
 * @description
 */

/**
 * 【题目】 用两个栈实现队列
 * <p>
 * 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。
 * 队列中的元素为int类型
 */
public class QueueWithTwoStacks
{
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * 入队操作，每次都存入stack1
     *
     * @param node 新入队的值
     */
    public void push(int node)
    {
        stack1.push(node);
    }

    /**
     * 出队操作，每次都从stack2取
     *
     * @return 出队的值
     */
    public int pop()
    {
        if (stack2.isEmpty())
        {
            if (stack1.isEmpty())
            {
                System.out.println("当前队列为空");
                return -1;
            }

            // 若stack2为空且stack1不为空，则将stack1中的值依次压入stack2
            // 此时stack2中的顺序即为入队顺序
            while (!stack1.isEmpty())
            {
                stack2.push(stack1.pop());
            }
        }

        // 若stack2不为空，则栈顶值即为下一个队列值
        return stack2.pop();
    }
}

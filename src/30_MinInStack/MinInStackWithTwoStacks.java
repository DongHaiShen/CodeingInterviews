import java.util.Stack;
/**
 * @Author sdh
 * @Date Created in 2019/2/27 16:06
 * @description
 */

/**
 * 【题目】 包含min函数的栈（用两个栈）
 * <p>
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O(1)）。
 */
public class MinInStackWithTwoStacks
{
    // 使用两个栈，dataStack存数字，minStack维护最小值
    public Stack<Integer> dataStack = new Stack<>();
    public Stack<Integer> minStack = new Stack<>();

    /**
     * 入栈
     *
     * @param node 数值
     */
    public void push(int node)
    {
        dataStack.push(node);

        // 只有minStack为空或node小于当前最小值，才入minStack
        // 避免minStack中存在多个重复值
        if (minStack.isEmpty() || node <= minStack.peek())
        {
            minStack.push(node);
        }
    }

    /**
     * 出栈
     */
    public void pop()
    {
        if (!dataStack.isEmpty())
        {
            int data = dataStack.pop();

            // 出栈的是最小值，更新minStack
            if (data == minStack.peek())
            {
                minStack.pop();
            }
        }
        else
        {
            throw new RuntimeException("Stack is empty!");
        }
    }

    /**
     * 按栈的顺序返回最新值，即dataStack栈顶值
     *
     * @return 栈顶值
     */
    public int top()
    {
        if (!dataStack.isEmpty())
        {
            return dataStack.peek();
        }
        else
        {
            throw new RuntimeException("Stack is empty!");
        }
    }

    /**
     * 返回最小值，即minStack栈顶值
     *
     * @return 最小值
     */
    public int min()
    {
        if (!minStack.isEmpty())
        {
            return minStack.peek();
        }
        else
        {
            throw new RuntimeException("Stack is empty!");
        }
    }
}

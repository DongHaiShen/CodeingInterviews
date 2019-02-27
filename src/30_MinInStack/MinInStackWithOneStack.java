import java.util.Stack;

/**
 * @Author sdh
 * @Date Created in 2019/2/27 14:55
 * @description
 */

/**
 * 【题目】 包含min函数的栈（只用一个栈）
 * <p>
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O(1)）。
 */
public class MinInStackWithOneStack
{
    // 使用一个栈和一个记录最小值的变量min
    public Stack<Integer> stack = new Stack<>();
    public int min;

    /**
     * 入栈
     *
     * @param node 数值
     */
    public void push(int node)
    {
        // 栈为空直接入栈并更新最小值
        if (stack.isEmpty())
        {
            stack.push(node);
            min = node;
        }
        else
        {
            // 否则入栈值为node - min
            // 若node小于min则更新min
            // 即此时入栈值node - min为负
            stack.push(node - min);
            if (node < min)
            {
                min = node;
            }
        }
    }

    /**
     * 出栈
     */
    public void pop()
    {
        if (!stack.isEmpty())
        {
            int data = stack.pop();

            // 出栈值为负说明当前值在入栈时为最小值，因此现在需要更新最小值
            if (data < 0)
            {
                min = min - data;
            }
        }
        else
        {
            throw new RuntimeException("Stack is empty!");
        }
    }

    /**
     * 按栈的顺序返回最新值
     *
     * @return 栈顶值
     */
    public int top()
    {
        // 栈中只有一个元素，直接返回
        if (stack.size() == 1)
        {
            return stack.peek();
        }

        if (!stack.isEmpty())
        {
            int data = stack.peek();

            // 若栈顶值大于0，即入栈时data = node - min大于0
            // 返回min + data
            if (data > 0)
            {
                return min + data;
            }

            // 否则说明当前值在入栈时为最小值，返回当前最小值
            else
            {
                return min;
            }
        }
        else
        {
            throw new RuntimeException("Stack is empty!");
        }
    }

    /**
     * 返回最小值
     * @return 最小值
     */
    public int min()
    {
        if (!stack.isEmpty())
        {
            return min;
        }
        else
        {
            throw new RuntimeException("Stack is empty!");
        }
    }
}

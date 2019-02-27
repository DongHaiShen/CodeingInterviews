import java.util.Stack;

/**
 * @Author sdh
 * @Date Created in 2019/2/27 18:12
 * @description
 */

/**
 * 【题目】 栈的压入、弹出序列
 * <p>
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class StackPushPopOrder
{
    /**
     * 判断popA是否是pushA的一个弹出序列
     *
     * @param pushA 入栈序列
     * @param popA  出栈序列
     * @return
     */
    public boolean isPopOrder(int[] pushA, int[] popA)
    {
        if (pushA == null || popA == null || pushA.length == 0 || popA.length == 0 || pushA.length != popA.length)
        {
            System.out.println("输入非法");
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0, popIndex = 0;

        while (popIndex < popA.length)
        {
            // 栈为空或栈顶元素与当前出栈元素不同
            while (stack.isEmpty() || stack.peek() != popA[popIndex])
            {
                // 入栈序列结束而出栈序列未结束，说明不匹配
                if (pushIndex >= pushA.length)
                {
                    return false;
                }

                // 不断入栈寻找出栈元素
                stack.push(pushA[pushIndex++]);
            }
            stack.pop();
            popIndex++;
        }

        return true;
    }
}

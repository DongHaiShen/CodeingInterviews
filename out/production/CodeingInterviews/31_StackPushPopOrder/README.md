[TOC]

## 栈的压入、弹出序列
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列
但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）

### 解法
创建一个辅助栈，顺序遍历出栈序列中的元素：
+ 如果其刚好是栈顶元素，直接弹出，并访问出栈序列中的下一个元素；
+ 如果不是，则把入栈序列中还没有入栈的数字依次压入栈，直到满足上一个条件；
+ 如果所有数字都压入栈顶后依然不满足，则不可能是弹出序列
+ 若能顺利遍历完出栈序列，则其是一个弹出序列

#### 代码
```java
import java.util.Stack;

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
```



### 测试用例参考
1. 功能测试（输入的两个数组含有多个数字或者只有一个数字：第二个数组是/不是第一个数组表示的压入序列对应的栈的弹出序列）；
2. 特殊输入测试（输入两个空指针）。

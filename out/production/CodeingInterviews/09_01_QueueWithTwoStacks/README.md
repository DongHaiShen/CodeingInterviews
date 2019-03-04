[TOC]

## 用两个栈实现队列

### 题目描述
用两个栈来实现一个队列，完成队列的Push和Pop操作。
队列中的元素为int类型

### 解法
规定：**每次 $push$ 操作都存入 $stack1$，每次 $pop$ 操作都从 $stack2$ 中取**

$Push$ 操作：直接存入$stack1$即可
$Pop$ 操作：不能直接从 $stack1$ 中取，是因为出栈顺序和入栈顺序恰好相反。**如果将 $stack1$ 中元素依次压入 $stack2$，此时 $stack2$ 的栈顶值即为下一个队列值**，具体操作为：
+ 若 $stack2$ 不为空，则直接取；
+ 若 $stack2$ 为空且$stack1$不为空，则先将 $stack1$ 中元素依次压入 $stack2$，然后再取

时间复杂度：入队(1)，出队O(n)

#### 代码
```java
import java.util.Stack;

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
```



### 测试用例参考
1. 往空的队列里添加、删除元素；
2. 往非空的队列添加、删除元素；
3. 连续删除元素直至队列为空。
[TOC]

## 用两个队列实现栈

### 题目描述
用两个队列来实现一个栈，完成栈的 Push 和 Pop 操作。
栈中的元素为int类型。

### 解法
规定：**每次都从 $queue1$ 进行 $push$ 和 $pop$ 操作**

$Push$ 操作：直接存入$queue1$即可
$Pop$ 操作：

+ 将 $queue1$ 中的值依次压入 $queue2$，直至剩下最后一个，即出栈值；
+ 将 $queue1$ 和 $queue2$ 进行交换，使得每次都从 $queue1$ 中进行存取

时间复杂度：入栈(1)，出栈O(n)

#### 代码
```java
import java.util.LinkedList;
import java.util.Queue;

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
```



### 测试用例参考
1. 往空的栈里添加、删除元素；
2. 往非空的栈添加、删除元素；
3. 连续删除元素直至栈为空。
[TOC]

## 包含min函数的栈
定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O(1)）。

### 解法

#### 解法1（两个栈）
题目中只要求时间复杂度为O(1)，未对空间进行限制，因此可以使用两个栈，一个 $dataStack$ 正常存储，一个 $minStack$ 维护最小值
+ 在入栈时只有 $minStack$ 为空或新值 $node$ 小于当前最小值，才入 $minStack$ ，这样可以避免 $minStack$ 中存在多个重复值；
+ 在出栈时若当前值为最小值，则 $minStack$ 也出栈；
+ 栈的最小值即为 $minStack$ 的栈顶值，只需O(1)

#### 代码
```java
import java.util.Stack;

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
```



#### 解法2（一个栈）
可以进一步优化空间，不需要 $minStack$ 做辅助，而是用变量 $min$ 维护最小值，空间复杂度为 O(1)，不过具体操作需要改变：
+ 在入栈时，若栈不为空，则**实际入栈值为 $node - min$** ，若 $node$ 小于 $min$ 则更新 $min$ ，**即此时入栈值 $node - min$ 为负**;
+ 在出栈时，**若出栈值为负说明当前值在入栈时为最小值**，因此现在需要更新最小值；
+ 栈的最小值即为 $min$ ，只需O(1)

#### 代码
```java
import java.util.Stack;

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
```



### 测试用例参考
1. 新压入栈的数字比之前的最小值大/小。
2. 弹出栈的数字是/不是最小元素。

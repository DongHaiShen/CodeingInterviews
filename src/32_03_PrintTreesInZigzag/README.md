[TOC]

## 按之字形打印二叉树
请实现一个函数按照之字形打印二叉树
即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
```java
如二叉树：
      1
     / \
    2   3
   / \  / \
  4   5 6  7

打印结果为：
1
3 2
4 5 6 7
```

### 解法
以根节点1为例，当把子节点2和3按顺序存储，实际打印顺序为3和2，因此可利用栈后进先出的特性，具体做法为：
+ 构建两个栈 $stack1$ 和 $stack2$ 分别用于存储**当前层节点和下一层节点**；
+ 当层数为奇数时，先保存左节点后保存右节点；
+ 当层数为偶数时，先保存右节点后保存左节点；

这里可以利用两个栈天然的顺序关系来记录奇偶关系：
+ 因为每次必有一个栈为空，且我们设定第一层放入 $stack1$；
+ **那么显然以后若 $stack1$ 不为空则为奇数层，$stack2$ 不为空则为偶数层**

#### 代码
```java
import java.util.ArrayList;
import java.util.Stack;

public class PrintTreesInZigzag
{
    /**
     * 按之字形打印二叉树
     *
     * @param root 二叉树根节点
     */
    public ArrayList<ArrayList<Integer>> printTreesInZigzag(TreeNode pRoot)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (pRoot == null)
        {
            return result;
        }

        TreeNode cur = new TreeNode(-1);
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(pRoot);
        while (!stack1.isEmpty() || !stack2.isEmpty())
        {
            if (!stack1.isEmpty())
            {
                ArrayList<Integer> list = new ArrayList<>();
                while (!stack1.isEmpty())
                {
                    cur = stack1.pop();
                    list.add(cur.val);
                    System.out.print(cur.val + " ");

                    // 奇数层先左子节点后右子节点
                    if (cur.left != null)
                    {
                        stack2.push(cur.left);
                    }
                    if (cur.right != null)
                    {
                        stack2.push(cur.right);
                    }
                }
                result.add(list);
            }
            else
            {
                ArrayList<Integer> list = new ArrayList<>();
                while (!stack2.isEmpty())
                {
                    cur = stack2.pop();
                    list.add(cur.val);
                    System.out.print(cur.val + " ");

                    // 偶数层先右子节点后左子节点
                    if (cur.right != null)
                    {
                        stack1.push(cur.right);
                    }
                    if (cur.left != null)
                    {
                        stack1.push(cur.left);
                    }
                }
                result.add(list);
            }
            System.out.println();
        }
        return result;
    }
}
```



### 测试用例参考
1. 功能测试（完全二叉树；所有节点只有左/右子树）；
2. 特殊输入测试（二叉树根节点为空指针；只有一个节点的二叉树）。

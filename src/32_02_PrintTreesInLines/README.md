[TOC]

## 把二叉树打印成多行
从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。

### 解法
只需在32_01不分行打印的基础上，加一句：
```java
for (int i = queue.size(); i > 0; i--)
```
这样每次循环都是将上一层节点的全部子节点放入队列中，即下一层节点


#### 代码
```java
import java.util.LinkedList;
import java.util.Queue;

public class PrintTreesInLines
{
    /**
     * 把二叉树打印成多行
     *
     * @param root 二叉树根节点
     */
    public void printTreesInLines(TreeNode root)
    {
        if (root == null)
        {
            return;
        }

        TreeNode cur = new TreeNode();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty())
        {
            for (int i = queue.size(); i > 0; i--)
            {
                cur = queue.poll();
                System.out.print(cur.val + " ");

                if (cur.left != null)
                {
                    queue.offer(cur.left);
                }
                if (cur.right != null)
                {
                    queue.offer(cur.right);
                }
            }
            System.out.println();
        }
    }
}
```



### 测试用例参考
1. 功能测试（完全二叉树；所有节点只有左/右子树）；
2. 特殊输入测试（二叉树根节点为空指针；只有一个节点的二叉树）。

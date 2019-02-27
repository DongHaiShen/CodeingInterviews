[TOC]

## 不分行从上到下打印二叉树
从上往下打印出二叉树的每个节点，同层节点从左至右打印。

### 解法
利用队列先进先出的特性：
+ 先将根节点入队；
+ 然后队首元素出队，将值存入 list，判断该元素是否有左右子树，有的话则依次入队，循环操作至队列为空

> 实际上就是标准的BFS广度优先遍历

#### 代码
```java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintTreeFromTopToBottom
{
    /**
     * 从上到下打印二叉树
     *
     * @param root 二叉树根节点
     * @return 结果list
     */
    public ArrayList<Integer> printFromTopToBottom(TreeNode root)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
        {
            return result;
        }

        TreeNode cur = new TreeNode();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty())
        {
            cur = queue.poll();
            result.add(cur.val);

            if (cur.left != null)
            {
                queue.offer(cur.left);
            }
            if (cur.right != null)
            {
                queue.offer(cur.right);
            }
        }
        return result;
    }
}
```



### 测试用例参考
1. 功能测试（完全二叉树；所有节点只有左/右子树）；
2. 特殊输入测试（二叉树根节点为空指针；只有一个节点的二叉树）。

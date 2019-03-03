[TOC]

## 二叉搜索树与双向链表

输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。

### 解法
+ 在树结构中，每个节点都有左右两个指针；在双向链表中，每个节点都有前后两个指针，因此理论上可以将树和链表进行转换；
+ 由于结果的双向链表要求排序，且输入为BST，可以利用**中序遍历**天然得到排序结果，遍历利用栈来实现；
+ 树指针的调整方式为：**前一个节点的右指针指向下一个节点，后一个节点的左指针指向前一个节点**，即：
```java
pre.right = cur;
cur.left = pre;
```


#### 代码
```java
import java.util.Stack;

public class ConvertBinarySearchTree
{
    /**
     * 将二叉搜索树转换为双向链表
     *
     * @param pRootOfTree 根节点
     * @return 转换后的根节点
     */
    public TreeNode convert(TreeNode pRootOfTree)
    {
        if (pRootOfTree == null)
        {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = pRootOfTree, pre = null, result = null;

        while (!stack.isEmpty() || cur != null)
        {
            // 采用中序遍历，先找到最左节点
            if (cur != null)
            {
                stack.push(cur);
                cur = cur.left;
            }
            else
            {
                cur = stack.pop();

                // 找到第一个节点
                if (pre == null)
                {
                    pre = cur;
                    result = pre;
                }

                // 前一个节点的右指针指向下一个节点
                // 后一个节点的左指针指向前一个节点
                else
                {
                    pre.right = cur;
                    cur.left = pre;
                    pre = cur;
                }

                // 左节点和根都访问完，进入右节点
                cur = cur.right;
            }
        }
        return result;
    }
}
```



### 测试用例参考
1. 功能测试（输入的二叉树是完全二叉树；所有结点都没有左/右子树；只有一个结点的二叉树）；
2. 特殊输入测试（指向二叉树根结点的指针为空指针）。

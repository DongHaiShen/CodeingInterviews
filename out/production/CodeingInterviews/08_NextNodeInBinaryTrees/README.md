[TOC]

## 二叉树的下一个节点

### 题目描述
给定一个二叉树和其中的一个节点，请找出中序遍历顺序的下一个节点并且返回。
注意，树中的节点不仅包含左右子节点，同时包含指向父节点的指针。

### 解法
根据中序遍历的特性，对于当前节点 $pNode$ ：
+ 若它有右子树，则下一个节点为**右子树中的最左节点**；（**注意：不是直接返回右孩子**）
+ 若它没有右子树，则结合它的父节点进行讨论：
  + 若它是其父节点的左孩子，则下一个节点为它的父节点；
  + 若它是其父节点的右孩子，则继续向上寻找父节点，直到满足当前节点为其父节点的左孩子，则下一个节点为它的父节点

**注意：为了符合OJ上的数据格式，因此在代码中使用 $next$ 来表示指向父节点的指针**

#### 代码
```java
public class NextNodeInBinaryTrees
{
    /**
     * 获取给定节点在中序遍历序列中的下一个节点
     *
     * @param pNode 某节点
     * @return 该节点的下一个节点
     */
    public TreeLinkNode getNext(TreeLinkNode pNode)
    {
        if (pNode == null)
        {
            System.out.println("节点为空");
            return null;
        }

        // 若当前节点有右子树
        if (pNode.right != null)
        {
            TreeLinkNode treeLinkNode = pNode.right;

            // 则下一个节点为右子树的最左节点
            while (treeLinkNode.left != null)
            {
                treeLinkNode = treeLinkNode.left;
            }
            return treeLinkNode;
        }

        // 若当前节点无右子树，且其为父节点的左子节点，则下一个节点为父节点
        if (pNode.next != null && pNode.next.left == pNode)
        {
            return pNode.next;
        }

        // 否则一直向上查找父节点直到满足上述条件
        while (pNode.next != null)
        {
            if (pNode.next.left == pNode)
            {
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
    }
}
```



### 测试用例参考
1. 普通二叉树（完全二叉树；不完全二叉树）；
2. 特殊二叉树（所有结点都没有左/右子结点；只有一个结点的二叉树；二叉树的根结点为空）；
3. 不同位置的结点的下一个结点（下一个结点为当前结点的右子结点、右子树的最左子结点、父结点、跨层的父结点等；当前结点没有下一个结点）。
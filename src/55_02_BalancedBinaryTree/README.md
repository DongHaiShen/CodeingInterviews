[TOC]

## 二叉树的深度

输入一棵二叉树的根结点，求该树的深度。
从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。

### 解法

#### 解法1（不推荐）
+ 利用55_01中的方法，递归计算每个节点左右子树的深度，然后判断是否平衡；
+ 该方法实现简单，但是一个节点会被重复访问多次


#### 代码
```java
public class BalancedBinaryTree
{
    /**
     * 通过计算左右子树深度判断是否平衡
     *
     * @param root 根节点
     * @return 是否平衡
     */
    public boolean isBalancedWithDepth(TreeNode root)
    {
        if (root == null)
        {
            return true;
        }

        int diff = Math.abs(TreeDepth(root.left) - TreeDepth(root.right));
        if (diff > 1)
        {
            return false;
        }

        return isBalancedWithDepth(root.left) && isBalancedWithDepth(root.right);
    }

    /**
     * 计算二叉树的深度
     *
     * @param root 根节点
     * @return 深度
     */
    public int TreeDepth(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }

        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }
}
```



#### 解法2（推荐）
+ 为了避免重复访问，可以**利用后序遍历**，先访问某节点的左右子节点，判断该节点是否平衡并记录深度；
+ 然后往上判断其父节点，直至根节点


#### 代码
```java
public class BalancedBinaryTree
{
    /**
     * 通过后序遍历减少节点遍历次数
     *
     * @param root 根节点
     * @return 是否平衡
     */
    public boolean isBalancedWithPostOrder(TreeNode root)
    {
        int[] depth = new int[1];
        return isBalancedWithPostOrderCore(root, depth);
    }

    /**
     * 通过后序遍历判断
     *
     * @param root  根节点
     * @param depth 当前深度
     * @return 是否平衡
     */
    public boolean isBalancedWithPostOrderCore(TreeNode root, int[] depth)
    {
        if (root == null)
        {
            depth[0] = 0;
            return true;
        }

        int[] left = new int[1];
        int[] right = new int[1];

        // 递归至叶节点
        if (isBalancedWithPostOrderCore(root.left, left)
                && isBalancedWithPostOrderCore(root.right, right))
        {
            int diff = Math.abs(left[0] - right[0]);
            if (diff <= 1)
            {
                depth[0] = 1 + (left[0] > right[0] ? left[0] : right[0]);
                return true;
            }
        }
        return false;
    }
}
```



### 测试用例参考
1. 功能测试（平衡的二叉树；不是平衡的二叉树；二叉树中所有节点都没有左/右子树）；
2. 特殊输入测试（二叉树只有一个节点；二叉树的头节点为空指针）。
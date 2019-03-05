[TOC]

## 二叉树的深度

输入一棵二叉树的根结点，求该树的深度。
从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。

### 解法
+ 以 p 为根节点的二叉树的最大深度，等于其左右子树的最大深度加1


#### 代码
```java
public class TreeDepth
{
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



### 测试用例参考
1. 功能测试（输入普通的二叉树；二叉树中所有节点都没有左/右子树）；
2. 特殊输入测试（二叉树只有一个节点；二叉树的头节点为空指针）。
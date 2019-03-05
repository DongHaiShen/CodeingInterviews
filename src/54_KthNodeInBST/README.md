[TOC]

## 二叉搜索树的第k个结点

给定一棵二叉搜索树，请找出其中的第k小的结点。
例如，（5，3，7，2，4，6，8） 中，按结点数值大小顺序第三小结点的值为 4

### 解法
+ 在BST中，通过中序遍历即可得到排序好的序列，从中找出第 k 大的即可


#### 代码
```java
public class KthNodeInBST
{
    public int count = 0;

    /**
     * 查找二叉搜索树的第k个结点
     *
     * @param pRoot 根节点
     * @param k     第k个
     * @return 二叉搜索树的第k个结点
     */
    public TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot == null || k == 0)
        {
            return null;
        }

        // 左递归
        TreeNode curNode = KthNode(pRoot.left, k);
        if (curNode != null)
        {
            return curNode;
        }

        // 符合条件返回
        count++;
        if (count == k)
        {
            return pRoot;
        }

        // 右递归
        curNode = KthNode(pRoot.right, k);
        if (curNode != null)
        {
            return curNode;
        }

        return null;
    }
}
```



### 测试用例参考
1. 功能测试（各种形态不同的二叉搜索树）；
2. 边界值测试（输入k为0、1、二叉搜索树的结点数、二叉搜索树的结点数+1）；
3. 特殊输入测试（指向二叉搜索树的节点的指针为空指针）。
[TOC]

## 对称的二叉树
请实现一个函数，用来判断一棵二叉树是不是对称的。
注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。

### 解法
递归判断两棵树的节点是否对称，具体规则为：
+ 左子树的左节点对应右子树的右节点；
+ 左子树的右节点对应右子树的左节点

也可以看成是比较两棵树的遍历序列，**一棵为 "根左右"，一棵为 "根右左"**

#### 代码
```java
public class SymmetricalBinaryTree
{
    /**
     * 判断是否是对称二叉树
     *
     * @param pRoot 根节点
     * @return 判断结果
     */
    public boolean isSymmetrical(TreeNode pRoot)
    {
        return isSymmetricalCore(pRoot, pRoot);
    }

    /**
     * 递归判断左右子树
     *
     * @param pRoot1 根节点1
     * @param pRoot2 根节点2
     * @return 判断结果
     */
    public boolean isSymmetricalCore(TreeNode pRoot1, TreeNode pRoot2)
    {
        if (pRoot1 == null && pRoot2 == null)
        {
            return true;
        }

        if (pRoot1 == null || pRoot2 == null)
        {
            return false;
        }

        if (pRoot1.val != pRoot2.val)
        {
            return false;
        }

        // 左子树的左节点对应右子树的右节点
        // 左子树的右节点对应右子树的左节点
        return isSymmetricalCore(pRoot1.left, pRoot2.right) && isSymmetricalCore(pRoot1.right, pRoot2.left);
    }
}
```



### 测试用例参考
1. 功能测试（对称的二叉树；因结构而不对称的二叉树；结构对称但节点的值不对称的二叉树）；
2. 特殊输入测试（二叉树的根结点为空指针；只有一个节点的二叉树；所有节点的值都相同的二叉树）。

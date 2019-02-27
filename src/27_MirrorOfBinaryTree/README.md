[TOC]

## 二叉树的镜像
操作给定的二叉树，将其变换为源二叉树的镜像。

```
源二叉树 
		8
       / \
      6  10
     / \ / \
    5  7 9 11

镜像二叉树
		8
       / \
      10  6
     / \  /\
    11 9  7 5
```

### 解法
将根节点的左右子树互换，之后递归处理左右子树。


#### 代码
```java
public class MirrorOfBinaryTree
{
    /**
     * 将二叉树转换为它的镜像
     *
     * @param root 根节点
     */
    public void mirror(TreeNode root)
    {
        if (root == null)
        {
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirror(root.left);
        mirror(root.right);
    }
}
```



### 测试用例参考
1. 功能测试（普通的二叉树；二叉树的所有结点都没有左/右子树；只有一个结点的二叉树）；
2. 特殊输入测试（二叉树的根结点为空指针）。


[TOC]

## 树的子结构
输入两棵二叉树A，B，判断B是不是A的子结构。
ps：我们约定空树不是任意一个树的子结构。

### 解法
整个过程分两步走：
+ 先从树A中查找树B的根节点，得到节点R；
+ 然后判断以R为根节点的子树是否与B相同


#### 代码
```java
public class SubstructureInTree
{
    /**
     * 输入两棵二叉树A和B，判断B是不是A的子结构。
     *
     * @param root1 树A的根结点
     * @param root2 树B的根结点
     * @return 是否是子结构
     */
    public boolean hasSubtree(TreeNode root1, TreeNode root2)
    {
        // 某个树为空直接返回false
        if (root1 == null || root2 == null)
        {
            return false;
        }

        // 两棵树相等直接返回true
        if (root1 == root2)
        {
            return true;
        }

        // 两树根节点相同则开始第二步匹配，否则从树A的左右子树中继续查找树B根节点
        return match(root1, root2) || hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
    }

    /**
     * 递归进行节点匹配
     *
     * @param root1 树A开始匹配的根结点
     * @param root2 树B开始匹配的根结点
     * @return 是否是子结构
     */
    public boolean match(TreeNode root1, TreeNode root2)
    {
        // 树B遍历完直接返回true
        if (root2 == null)
        {
            return true;
        }

        // 树B未遍历完而树A遍历完，直接返回false
        if (root1 == null)
        {
            return false;
        }

        // 两个节点值不同返回false
        if (root1.val != root2.val)
        {
            return false;
        }

        // 相同则继续递归判断左右子节点
        return match(root1.left, root2.left) && match(root1.right, root2.right);
    }
}
```



### 测试用例参考
1. 功能测试（树A和树B都是普通的二叉树；树B是/不是树A的子结构）；
2. 特殊输入测试（两棵二叉树的一个或者两个根结点为空指针，二叉树的所有结点都没有左/右子树）。





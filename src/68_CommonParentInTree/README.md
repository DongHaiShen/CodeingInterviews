[TOC]

## 树中两个节点的最低公共祖先

输入两个树结点，求他们的最低公共祖先。
**要求不一定是二叉树，且树中节点不存在指向父节点的指针**

### 解法
+ 如果树是BST：
  1. 因为BST中数字有顺序，因此可从根节点开始递归判断；
  2. 若当前节点的值大于两个节点，则最低公共祖先在当前节点的左子树中；
  3. 反之则在右子树中。

     

+ 如果只是普通的树，甚至不是二叉树，但节点有指向父节点的指针：
  1. 先**自下而上获取**两个节点到根节点的路径；
  2. 然后转化为**求两个链表的第一个公共节点**

     

+ 若没有指向父节点的指针，同时不能使用额外空间：
  1. 从根节点开始，每次遍历左右子树判断两个节点是否都在同一个子树中；
  2. 当第一次遇到左右子树都不满足（即各自包含一个），则找到最低公共祖先；
  3. 问题在于存在大量重复的节点判断，因此时间复杂度为O(n^2)，空间复杂度为O(1)



+ 若没有指向父节点的指针，但可以使用额外空间：
  1. 先**自上而下深度优先获取**从根节点到两个节点的路径；
  2. 然后转化为**求两个链表的最后一个公共节点**
  3. 利用空间换时间，时间复杂度为O(n)，空间复杂度为O(lgn)

#### 代码
```java
public class CommonParentInTree
{
    /**
     * 查找树中两个节点的最低公共祖先
     *
     * @param root 根节点
     * @param p1   节点1
     * @param p2   节点2
     * @return 最低公共祖先
     */
    public CommonTreeNode getLastCommonParent(CommonTreeNode root, CommonTreeNode p1, CommonTreeNode p2)
    {
        if (root == null || p1 == null || p2 == null)
        {
            return null;
        }

        // 获取到达节点1的路径
        List<CommonTreeNode> path1 = new LinkedList<>();
        getNodePath(root, p1, path1);

        // 获取到达节点2的路径
        List<CommonTreeNode> path2 = new LinkedList<>();
        getNodePath(root, p2, path2);

        // 求两个路径的最后一个公共节点
        return getLastCommonNode(path1, path2);
    }

    /**
     * 获取到达节点的路径
     *
     * @param root   根节点
     * @param target 目标节点
     * @param path   路径
     */
    public void getNodePath(CommonTreeNode root, CommonTreeNode target, List<CommonTreeNode> path)
    {
        if (root == null)
        {
            return;
        }

        // 添加当前节点
        path.add(root);

        // 获取到达当前节点的已有路径
        List<CommonTreeNode> children = root.children;

        // 处理子结点
        for (CommonTreeNode node : children)
        {
            if (node == target)
            {
                path.add(node);
                return;
            }
            else
            {
                getNodePath(node, target, path);
            }
        }

        // 还原至上个节点
        path.remove(path.size() - 1);
    }

    /**
     * 寻找两个链表的最后一个公共节点
     *
     * @param path1 链表1
     * @param path2 链表2
     * @return 最后一个公共节点
     */
    public CommonTreeNode getLastCommonNode(List<CommonTreeNode> path1, List<CommonTreeNode> path2)
    {
        Iterator<CommonTreeNode> it1 = path1.iterator();
        Iterator<CommonTreeNode> it2 = path2.iterator();

        CommonTreeNode last = null, temp;
        while (it1.hasNext() && it2.hasNext())
        {
            temp = it1.next();
            if (temp == it2.next())
            {
                last = temp;
            }
        }
        return last;
    }
}
```



### 测试用例参考
1. 功能测试（普通形态的树；形状退化成链状的树）；
2. 特殊测试（根节点为null）；


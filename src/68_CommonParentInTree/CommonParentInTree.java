import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author sdh
 * @Date Created in 2019/3/7 10:28
 * @description
 */

/**
 * 【题目】 树中两个节点的最低公共祖先
 * <p>
 * 输入两个树结点，求他们的最低公共祖先。
 * 要求不一是二叉树，且树中节点不存在指向父节点的指针
 */
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

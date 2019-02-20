/**
 * @Author sdh
 * @Date Created in 2019/2/20 19:32
 * @description
 */

/**
 * 【题目】 二叉树的下一个节点
 * <p>
 * 给定一个二叉树和其中的一个节点，请找出中序遍历顺序的下一个节点并且返回。
 * 注意，树中的节点不仅包含左右子节点，同时包含指向父节点的指针。
 */
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

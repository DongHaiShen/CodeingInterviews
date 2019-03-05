/**
 * @Author sdh
 * @Date Created in 2019/3/5 18:30
 * @description
 */

/**
 * 【题目】 二叉搜索树的第k个结点
 * <p>
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如，（5，3，7，2，4，6，8） 中，按结点数值大小顺序第三小结点的值为 4
 */
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

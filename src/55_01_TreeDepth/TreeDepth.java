/**
 * @Author sdh
 * @Date Created in 2019/3/5 18:51
 * @description
 */

/**
 * 【题目】 二叉树的深度
 * <p>
 * 输入一棵二叉树的根结点，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
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

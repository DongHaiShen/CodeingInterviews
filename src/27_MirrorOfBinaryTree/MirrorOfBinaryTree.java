/**
 * @Author sdh
 * @Date Created in 2019/2/27 11:21
 * @description
 */

/**
 * 【题目】 二叉树的镜像
 * <p>
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
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

/**
 * @Author sdh
 * @Date Created in 2019/2/27 11:45
 * @description
 */

/**
 * 【题目】 对称的二叉树
 * <p>
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
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

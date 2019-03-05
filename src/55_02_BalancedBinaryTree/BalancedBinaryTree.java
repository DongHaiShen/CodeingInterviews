/**
 * @Author sdh
 * @Date Created in 2019/3/5 19:09
 * @description
 */

/**
 * 【题目】 平衡二叉树
 * <p>
 * 输入一棵二叉树的根结点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意结点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * 规定空树也是一棵平衡二叉树。
 */
public class BalancedBinaryTree
{
    /**
     * 通过计算左右子树深度判断是否平衡
     *
     * @param root 根节点
     * @return 是否平衡
     */
    public boolean isBalancedWithDepth(TreeNode root)
    {
        if (root == null)
        {
            return true;
        }

        int diff = Math.abs(TreeDepth(root.left) - TreeDepth(root.right));
        if (diff > 1)
        {
            return false;
        }

        return isBalancedWithDepth(root.left) && isBalancedWithDepth(root.right);
    }

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

    /**
     * 通过后序遍历减少节点遍历次数
     *
     * @param root 根节点
     * @return 是否平衡
     */
    public boolean isBalancedWithPostOrder(TreeNode root)
    {
        int[] depth = new int[1];
        return isBalancedWithPostOrderCore(root, depth);
    }

    /**
     * 通过后序遍历判断
     *
     * @param root  根节点
     * @param depth 当前深度
     * @return 是否平衡
     */
    public boolean isBalancedWithPostOrderCore(TreeNode root, int[] depth)
    {
        if (root == null)
        {
            depth[0] = 0;
            return true;
        }

        int[] left = new int[1];
        int[] right = new int[1];

        // 递归至叶节点
        if (isBalancedWithPostOrderCore(root.left, left)
                && isBalancedWithPostOrderCore(root.right, right))
        {
            int diff = Math.abs(left[0] - right[0]);
            if (diff <= 1)
            {
                depth[0] = 1 + (left[0] > right[0] ? left[0] : right[0]);
                return true;
            }
        }
        return false;
    }
}

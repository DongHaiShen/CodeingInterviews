/**
 * @Author sdh
 * @Date Created in 2019/2/20 15:30
 * @description
 */

/**
 * 【题目】 重建二叉树
 * <p>
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列 {1,2,4,7,3,5,6,8} 和中序遍历序列 {4,7,2,1,5,3,8,6}，则重建二叉树并返回.
 */
public class ConstructBinaryTree
{
    /**
     * 根据二叉树前序和中序遍历结果重建该二叉树
     *
     * @param pre 前序遍历序列
     * @param in  中序遍历序列
     * @return 重建后的根节点
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in)
    {
        // 判断输入是否合法
        // 两个数组都不能为空，数组长度应大于0且相同
        if (pre == null || in == null || pre.length != in.length || pre.length < 1)
        {
            System.out.println("数组为空或长度不合法");
            return null;
        }

        return constructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    /**
     * 利用递归方式重建该二叉树
     *
     * @param pre      前序遍历序列
     * @param preStart 前序遍历序列起始位置
     * @param preEnd   前序遍历序列结束位置
     * @param in       中序遍历序列
     * @param inStart  中序遍历序列起始位置
     * @param inEnd    中序遍历序列结束位置
     * @return 重建后的根节点
     */
    public TreeNode constructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd)
    {
        // 若起始位置大于结束位置说明处理完毕
        if (preStart > preEnd)
        {
            return null;
        }

        // 在前序遍历序列中，第一个元素即为根节点的值
        int rootValue = pre[preStart];
        TreeNode root = new TreeNode(rootValue);

        // 在中序遍历序列中找到根节点所在位置
        int inOrderIndex = inStart;
        while (inOrderIndex <= inEnd && in[inOrderIndex] != rootValue)
            inOrderIndex++;

        // 若查找不到则说明两个序列不匹配
        if (inOrderIndex > inEnd)
        {
            System.out.println("前序和中序数组不匹配");
            return null;
        }

        /**
         * 递归构建当前根节点的左右子树
         * 左子树在前序遍历中的位置为 [preStart + 1, preStart + inOrderIndex - inStart]
         * 左子树在中序遍历中的位置为 [inStart, inOrderIndex - 1]
         * 右子树在前序遍历中的位置为 [preStart + inOrderIndex - inStart + 1, preEnd]
         * 右子树在中序遍历中的位置为 [inOrderIndex + 1, inEnd]
         */
        root.left = constructBinaryTree(pre, preStart + 1, preStart + inOrderIndex - inStart, in, inStart, inOrderIndex - 1);
        root.right = constructBinaryTree(pre, preStart + inOrderIndex - inStart + 1, preEnd, in, inOrderIndex + 1, inEnd);

        return root;
    }

    /**
     * 中序遍历二叉树（递归版）
     *
     * @param root 根节点
     */
    public void inOrderTraversal(TreeNode root)
    {
        if (root != null)
        {
            inOrderTraversal(root.left);
            System.out.print(root.val + " ");
            inOrderTraversal(root.right);
        }
    }
}

import java.util.Stack;

/**
 * @Author sdh
 * @Date Created in 2019/3/1 21:02
 * @description
 */

/**
 * 【题目】 二叉搜索树与双向链表
 * <p>
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class ConvertBinarySearchTree
{
    /**
     * 将二叉搜索树转换为双向链表
     *
     * @param pRootOfTree 根节点
     * @return 转换后的根节点
     */
    public TreeNode convert(TreeNode pRootOfTree)
    {
        if (pRootOfTree == null)
        {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = pRootOfTree, pre = null, result = null;

        while (!stack.isEmpty() || cur != null)
        {
            // 采用中序遍历，先找到最左节点
            if (cur != null)
            {
                stack.push(cur);
                cur = cur.left;
            }
            else
            {
                cur = stack.pop();

                // 找到第一个节点
                if (pre == null)
                {
                    pre = cur;
                    result = pre;
                }

                // 前一个节点的右指针指向下一个节点
                // 后一个节点的左指针指向前一个节点
                else
                {
                    pre.right = cur;
                    cur.left = pre;
                    pre = cur;
                }

                // 左节点和根都访问完，进入右节点
                cur = cur.right;
            }
        }
        return result;
    }
}

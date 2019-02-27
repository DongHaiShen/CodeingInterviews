import java.util.Stack;

/**
 * @Author sdh
 * @Date Created in 2019/2/27 20:17
 * @description
 */

/**
 * 【题目】 按之字形打印二叉树
 * <p>
 * 请实现一个函数按照之字形打印二叉树
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class PrintTreesInZigzag
{
    /**
     * 按之字形打印二叉树
     *
     * @param root 二叉树根节点
     */
    public void printTreesInZigzag(TreeNode root)
    {
        if (root == null)
        {
            return;
        }

        TreeNode cur = new TreeNode();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty())
        {
            if (!stack1.isEmpty())
            {
                while (!stack1.isEmpty())
                {
                    cur = stack1.pop();
                    System.out.print(cur.val + " ");

                    // 奇数层先左子节点后右子节点
                    if (cur.left != null)
                    {
                        stack2.push(cur.left);
                    }
                    if (cur.right != null)
                    {
                        stack2.push(cur.right);
                    }
                }
            }
            else
            {
                while (!stack2.isEmpty())
                {
                    cur = stack2.pop();
                    System.out.print(cur.val + " ");

                    // 偶数层先右子节点后左子节点
                    if (cur.right != null)
                    {
                        stack1.push(cur.right);
                    }
                    if (cur.left != null)
                    {
                        stack1.push(cur.left);
                    }
                }
            }
            System.out.println();
        }
    }
}

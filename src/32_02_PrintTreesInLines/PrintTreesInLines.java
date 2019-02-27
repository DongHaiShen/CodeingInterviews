import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author sdh
 * @Date Created in 2019/2/27 19:50
 * @description
 */

/**
 * 【题目】 把二叉树打印成多行
 * <p>
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class PrintTreesInLines
{
    /**
     * 把二叉树打印成多行
     *
     * @param root 二叉树根节点
     */
    public void printTreesInLines(TreeNode root)
    {
        if (root == null)
        {
            return;
        }

        TreeNode cur = new TreeNode();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty())
        {
            for (int i = queue.size(); i > 0; i--)
            {
                cur = queue.poll();
                System.out.print(cur.val + " ");

                if (cur.left != null)
                {
                    queue.offer(cur.left);
                }
                if (cur.right != null)
                {
                    queue.offer(cur.right);
                }
            }
            System.out.println();
        }
    }
}

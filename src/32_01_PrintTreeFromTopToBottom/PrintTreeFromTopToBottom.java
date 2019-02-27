import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author sdh
 * @Date Created in 2019/2/27 19:11
 * @description
 */

/**
 * 【题目】 不分行从上到下打印二叉树
 * <p>
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintTreeFromTopToBottom
{
    /**
     * 从上到下打印二叉树
     *
     * @param root 二叉树根节点
     * @return 结果list
     */
    public ArrayList<Integer> printFromTopToBottom(TreeNode root)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
        {
            return result;
        }

        TreeNode cur = new TreeNode();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty())
        {
            cur = queue.poll();
            result.add(cur.val);

            if (cur.left != null)
            {
                queue.offer(cur.left);
            }
            if (cur.right != null)
            {
                queue.offer(cur.right);
            }
        }
        return result;
    }
}

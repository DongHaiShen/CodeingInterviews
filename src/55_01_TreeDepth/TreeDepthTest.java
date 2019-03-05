/**
 * @Author sdh
 * @Date Created in 2019/3/5 18:51
 * @description
 */
public class TreeDepthTest
{
    public static void main(String[] args)
    {
        TreeDepth test = new TreeDepth();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(7);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        System.out.println(test.TreeDepth(root)); // 4
    }
}

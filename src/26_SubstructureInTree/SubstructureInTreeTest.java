/**
 * @Author sdh
 * @Date Created in 2019/2/27 10:37
 * @description
 */
public class SubstructureInTreeTest
{
    public static void main(String[] args)
    {
        SubstructureInTree test = new SubstructureInTree();
        
        TreeNode root1 = new TreeNode();
        root1.val = 8;
        root1.right = new TreeNode();
        root1.right.val = 7;
        root1.left = new TreeNode();
        root1.left.val = 8;
        root1.left.left = new TreeNode();
        root1.left.left.val = 9;
        root1.left.right = new TreeNode();
        root1.left.right.val = 2;
        root1.left.right.left = new TreeNode();
        root1.left.right.left.left = new TreeNode();
        root1.left.right.left.left.val = 4;
        root1.left.right.left.right = new TreeNode();
        root1.left.right.left.right.val = 7;

        TreeNode root2 = new TreeNode();
        root2.val = 8;
        root2.left = new TreeNode();
        root2.left.val = 9;
        root2.right = new TreeNode();
        root2.right.val = 2;

        System.out.println(test.hasSubtree(root1, root2));
        System.out.println(test.hasSubtree(root2, root1));
        System.out.println(test.hasSubtree(root1, root1.left));
        System.out.println(test.hasSubtree(root1, null));
        System.out.println(test.hasSubtree(null, root2));
        System.out.println(test.hasSubtree(null, null));
    }
}

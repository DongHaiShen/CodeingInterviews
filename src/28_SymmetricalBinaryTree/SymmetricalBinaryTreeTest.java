/**
 * @Author sdh
 * @Date Created in 2019/2/27 11:46
 * @description
 */
public class SymmetricalBinaryTreeTest
{
    public static void main(String[] args)
    {
        SymmetricalBinaryTree test = new SymmetricalBinaryTree();
        test01(test);
        test02(test);
    }

    public static void assemble(TreeNode node, TreeNode left, TreeNode right)
    {
        node.left = left;
        node.right = right;
    }

    //                            1
    //                  2                   2
    //             4         6          6          4
    //          8     9   10   11   11     10   9     8
    public static void test01(SymmetricalBinaryTree test)
    {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(4);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);
        TreeNode n11 = new TreeNode(11);
        TreeNode n12 = new TreeNode(11);
        TreeNode n13 = new TreeNode(10);
        TreeNode n14 = new TreeNode(9);
        TreeNode n15 = new TreeNode(8);

        assemble(n1, n2, n3);
        assemble(n2, n4, n5);
        assemble(n3, n6, n7);
        assemble(n4, n8, n9);
        assemble(n5, n10, n11);
        assemble(n6, n12, n13);
        assemble(n7, n14, n15);
        assemble(n8, null, null);
        assemble(n9, null, null);
        assemble(n10, null, null);
        assemble(n11, null, null);
        assemble(n12, null, null);
        assemble(n13, null, null);
        assemble(n14, null, null);
        assemble(n15, null, null);

        System.out.println(test.isSymmetrical(n1));

    }


    //                            1
    //                  2                   2
    //             4         5          6          4
    //          8     9   10   11   11     10   9     8
    public static void test02(SymmetricalBinaryTree test)
    {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(4);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);
        TreeNode n11 = new TreeNode(11);
        TreeNode n12 = new TreeNode(11);
        TreeNode n13 = new TreeNode(10);
        TreeNode n14 = new TreeNode(9);
        TreeNode n15 = new TreeNode(8);

        assemble(n1, n2, n3);
        assemble(n2, n4, n5);
        assemble(n3, n6, n7);
        assemble(n4, n8, n9);
        assemble(n5, n10, n11);
        assemble(n6, n12, n13);
        assemble(n7, n14, n15);
        assemble(n8, null, null);
        assemble(n9, null, null);
        assemble(n10, null, null);
        assemble(n11, null, null);
        assemble(n12, null, null);
        assemble(n13, null, null);
        assemble(n14, null, null);
        assemble(n15, null, null);

        System.out.println(test.isSymmetrical(n1));

    }
}

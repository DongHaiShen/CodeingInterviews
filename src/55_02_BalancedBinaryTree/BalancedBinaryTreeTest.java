/**
 * @Author sdh
 * @Date Created in 2019/3/5 19:09
 * @description
 */
public class BalancedBinaryTreeTest
{
    public static void main(String[] args)
    {
        BalancedBinaryTree test = new BalancedBinaryTree();

        test1(test);
        test2(test);
        test3(test);
        test4(test);
    }

    // 完全二叉树
    //             1
    //         /      \
    //        2        3
    //       /\       / \
    //      4  5     6   7
    public static void test1(BalancedBinaryTree test)
    {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(1);
        TreeNode n6 = new TreeNode(1);
        TreeNode n7 = new TreeNode(1);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        System.out.println(test.isBalancedWithDepth(n1));
        System.out.println(test.isBalancedWithPostOrder(n1));
        System.out.println("----------------");

    }

    // 不是完全二叉树，但是平衡二叉树
    //             1
    //         /      \
    //        2        3
    //       /\         \
    //      4  5         6
    //        /
    //       7
    public static void test2(BalancedBinaryTree test)
    {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(1);
        TreeNode n6 = new TreeNode(1);
        TreeNode n7 = new TreeNode(1);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n5.left = n7;
        n3.right = n6;


        System.out.println(test.isBalancedWithDepth(n1));
        System.out.println(test.isBalancedWithPostOrder(n1));
        System.out.println("----------------");
    }

    // 不是平衡二叉树
    //             1
    //         /      \
    //        2        3
    //       /\
    //      4  5
    //        /
    //       7
    public static void test3(BalancedBinaryTree test)
    {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(1);
        TreeNode n6 = new TreeNode(1);
        TreeNode n7 = new TreeNode(1);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n5.left = n7;

        System.out.println(test.isBalancedWithDepth(n1));
        System.out.println(test.isBalancedWithPostOrder(n1));
        System.out.println("----------------");
    }

    //               1
    //              /
    //             2
    //            /
    //           3
    //          /
    //         4
    //        /
    //       5
    public static void test4(BalancedBinaryTree test)
    {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(1);
        TreeNode n6 = new TreeNode(1);
        TreeNode n7 = new TreeNode(1);

        n1.left = n2;
        n2.left = n3;
        n3.left = n4;
        n4.left = n5;


        System.out.println(test.isBalancedWithDepth(n1));
        System.out.println(test.isBalancedWithPostOrder(n1));
        System.out.println("----------------");
    }

    // 1
    //  \
    //   2
    //    \
    //     3
    //      \
    //       4
    //        \
    //         5
    public static void test5(BalancedBinaryTree test)
    {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(1);
        TreeNode n6 = new TreeNode(1);
        TreeNode n7 = new TreeNode(1);

        n1.right = n2;
        n2.right = n3;
        n3.right = n4;
        n4.right = n5;


        System.out.println(test.isBalancedWithDepth(n1));
        System.out.println(test.isBalancedWithPostOrder(n1));
        System.out.println("----------------");
    }
}

/**
 * @Author sdh
 * @Date Created in 2019/3/1 21:02
 * @description
 */
public class ConvertBinarySearchTreeTest
{
    public static void main(String[] args)
    {
        ConvertBinarySearchTree test = new ConvertBinarySearchTree();

        test01(test);
        test02(test);
        test03(test);
        test04(test);
        test05(test);
    }

    public static void printList(TreeNode head)
    {
        while (head != null)
        {
            System.out.print(head.val + "->");
            head = head.right;
        }

        System.out.println("null");
    }

    public static void printTree(TreeNode root)
    {
        if (root != null)
        {
            printTree(root.left);
            System.out.print(root.val + "->");
            printTree(root.right);
        }
    }


    //            10
    //         /      \
    //        6        14
    //       /\        /\
    //      4  8     12  16
    public static void test01(ConvertBinarySearchTree test)
    {
        TreeNode node10 = new TreeNode();
        node10.val = 10;

        TreeNode node6 = new TreeNode();
        node6.val = 6;

        TreeNode node14 = new TreeNode();
        node14.val = 14;

        TreeNode node4 = new TreeNode();
        node4.val = 4;

        TreeNode node8 = new TreeNode();
        node8.val = 8;

        TreeNode node12 = new TreeNode();
        node12.val = 12;

        TreeNode node16 = new TreeNode();
        node16.val = 16;

        node10.left = node6;
        node10.right = node14;

        node6.left = node4;
        node6.right = node8;

        node14.left = node12;
        node14.right = node16;

        System.out.print("Before test.convert: ");
        printTree(node10);
        System.out.println("null");
        TreeNode head = test.convert(node10);
        System.out.print("After test.convert : ");
        printList(head);
        System.out.println();

    }

    //               5
    //              /
    //             4
    //            /
    //           3
    //          /
    //         2
    //        /
    //       1
    public static void test02(ConvertBinarySearchTree test)
    {
        TreeNode node1 = new TreeNode();
        node1.val = 1;

        TreeNode node2 = new TreeNode();
        node2.val = 2;

        TreeNode node3 = new TreeNode();
        node3.val = 3;

        TreeNode node4 = new TreeNode();
        node4.val = 4;

        TreeNode node5 = new TreeNode();
        node5.val = 5;

        node5.left = node4;
        node4.left = node3;
        node3.left = node2;
        node2.left = node1;

        System.out.print("Before test.convert: ");
        printTree(node5);
        System.out.println("null");
        TreeNode head = test.convert(node5);
        System.out.print("After test.convert : ");
        printList(head);
        System.out.println();
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
    public static void test03(ConvertBinarySearchTree test)
    {
        TreeNode node1 = new TreeNode();
        node1.val = 1;

        TreeNode node2 = new TreeNode();
        node2.val = 2;

        TreeNode node3 = new TreeNode();
        node3.val = 3;

        TreeNode node4 = new TreeNode();
        node4.val = 4;

        TreeNode node5 = new TreeNode();
        node5.val = 5;

        node1.right = node2;
        node2.right = node3;
        node3.right = node4;
        node4.right = node5;

        System.out.print("Before test.convert: ");
        printTree(node1);
        System.out.println("null");
        TreeNode head = test.convert(node1);
        System.out.print("After test.convert : ");
        printList(head);
        System.out.println();
    }

    // 只有一个结点
    public static void test04(ConvertBinarySearchTree test)
    {
        TreeNode node1 = new TreeNode();
        node1.val = 1;

        System.out.print("Before test.convert: ");
        printTree(node1);
        System.out.println("null");
        TreeNode head = test.convert(node1);
        System.out.print("After test.convert : ");
        printList(head);
        System.out.println();
    }

    // 没有结点
    public static void test05(ConvertBinarySearchTree test)
    {
        System.out.print("Before test.convert: ");
        printTree(null);
        System.out.println("null");
        TreeNode head = test.convert(null);
        System.out.print("After test.convert : ");
        printList(head);
        System.out.println();
    }
}

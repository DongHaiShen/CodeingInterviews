import java.util.ArrayList;

/**
 * @Author sdh
 * @Date Created in 2019/3/1 11:33
 * @description
 */
public class PathInTreeTest
{
    public static void main(String[] args)
    {
        PathInTree test = new PathInTree();

        //            10
        //         /      \
        //        5        12
        //       /\
        //      4  7
        TreeNode root = new TreeNode();
        root.val = 10;
        root.left = new TreeNode();
        root.left.val = 5;
        root.left.left = new TreeNode();
        root.left.left.val = 4;
        root.left.right = new TreeNode();
        root.left.right.val = 7;
        root.right = new TreeNode();
        root.right.val = 12;

        // 有两条路径上的结点和为22
        System.out.println("print(test.findPath(root, 22));");
        print(test.findPath(root, 22));

        // 没有路径上的结点和为15
        System.out.println("print(test.findPath(root, 15));");
        print(test.findPath(root, 15));

        // 有一条路径上的结点和为19
        System.out.println("print(test.findPath(root, 19));");
        print(test.findPath(root, 19));


        //               5
        //              /
        //             4
        //            /
        //           3
        //          /
        //         2
        //        /
        //       1
        TreeNode root2 = new TreeNode();
        root2.val = 5;
        root2.left = new TreeNode();
        root2.left.val = 4;
        root2.left.left = new TreeNode();
        root2.left.left.val = 3;
        root2.left.left.left = new TreeNode();
        root2.left.left.left.val = 2;
        root2.left.left.left.left = new TreeNode();
        root2.left.left.left.left.val = 1;

        // 有一条路径上面的结点和为15
        System.out.println("print(test.findPath(root2, 15));");
        print(test.findPath(root2, 15));

        // 没有路径上面的结点和为16
        System.out.println("print(test.findPath(root2, 16));");
        print(test.findPath(root2, 16));

        // 1
        //  \
        //   2
        //    \
        //     3
        //      \
        //       4
        //        \
        //         5
        TreeNode root3 = new TreeNode();
        root3.val = 1;
        root3.right = new TreeNode();
        root3.right.val = 2;
        root3.right.right = new TreeNode();
        root3.right.right.val = 3;
        root3.right.right.right = new TreeNode();
        root3.right.right.right.val = 4;
        root3.right.right.right.right = new TreeNode();
        root3.right.right.right.right.val = 5;

        // 有一条路径上面的结点和为15
        System.out.println("print(test.findPath(root3, 15));");
        print(test.findPath(root3, 15));

        // 没有路径上面的结点和为16
        System.out.println("print(test.findPath(root3, 16));");
        print(test.findPath(root3, 16));

        // 树中只有1个结点
        TreeNode root4 = new TreeNode();

        root4.val = 1;
        // 有一条路径上面的结点和为1
        System.out.println("print(test.findPath(root4, 1));");
        print(test.findPath(root4, 1));

        // 没有路径上面的结点和为2
        System.out.println("print(test.findPath(root4, 2));");
        print(test.findPath(root4, 2));

        // 树中没有结点
        System.out.println("print(test.findPath(null, 0));");
        print(test.findPath(null, 0));
    }
    
    public static void print(ArrayList<ArrayList<Integer>> result)
    {
        for (ArrayList<Integer> arrayList: result)
        {
            for (int n: arrayList)
            {
                System.out.print(n + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

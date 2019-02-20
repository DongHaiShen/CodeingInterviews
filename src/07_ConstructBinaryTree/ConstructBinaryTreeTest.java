/**
 * @Author sdh
 * @Date Created in 2019/2/20 15:31
 * @description
 */
public class ConstructBinaryTreeTest
{

    public static void main(String[] args)
    {
        ConstructBinaryTree test = new ConstructBinaryTree();

        // 普通二叉树
        //              1
        //           /     \
        //          2       3
        //         /       / \
        //        4       5   6
        //         \         /
        //          7       8
        int[] preorder1 = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder1 = {4, 7, 2, 1, 5, 3, 8, 6};
        test.inOrderTraversal(test.reConstructBinaryTree(preorder1, inorder1));
        System.out.println();


        // 所有结点都没有右子结点
        //            1
        //           /
        //          2
        //         /
        //        3
        //       /
        //      4
        //     /
        //    5
        int[] preorder2 = {1, 2, 3, 4, 5};
        int[] inorder2 = {5, 4, 3, 2, 1};
        test.inOrderTraversal(test.reConstructBinaryTree(preorder2, inorder2));
        System.out.println();


        // 所有结点都没有左子结点
        //            1
        //             \
        //              2
        //               \
        //                3
        //                 \
        //                  4
        //                   \
        //                    5
        int[] preorder3 = {1, 2, 3, 4, 5};
        int[] inorder3 = {1, 2, 3, 4, 5};
        test.inOrderTraversal(test.reConstructBinaryTree(preorder3, inorder3));
        System.out.println();


        // 树中只有一个结点
        int[] preorder4 = {1};
        int[] inorder4 = {1};
        test.inOrderTraversal(test.reConstructBinaryTree(preorder4, inorder4));
        System.out.println();


        // 完全二叉树
        //              1
        //           /     \
        //          2       3
        //         / \     / \
        //        4   5   6   7
        int[] preorder5 = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder5 = {4, 2, 5, 1, 6, 3, 7};
        test.inOrderTraversal(test.reConstructBinaryTree(preorder5, inorder5));
        System.out.println();


        // 输入空指针
        int[] preorder6 = null;
        int[] inorder6 = null;
        test.inOrderTraversal(test.reConstructBinaryTree(preorder6, inorder6));
        System.out.println();


        // 输入的两个序列不匹配
        int[] preorder7 = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder7 = {4, 2, 8, 1, 6, 3, 7};
        test.inOrderTraversal(test.reConstructBinaryTree(preorder7, inorder7));
    }
}

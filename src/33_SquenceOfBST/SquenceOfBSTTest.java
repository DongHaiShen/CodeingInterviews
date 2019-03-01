/**
 * @Author sdh
 * @Date Created in 2019/3/1 9:59
 * @description
 */
public class SquenceOfBSTTest
{
    public static void main(String[] args)
    {
        SquenceOfBST test = new SquenceOfBST();

        //           10
        //         /   \
        //        6     14
        //       /\     /\
        //      4  8  12  16
        int[] data = {4, 8, 6, 12, 16, 14, 10};
        System.out.println("true: " + test.verifySequenceOfBST(data));

        //           5
        //          / \
        //         4   7
        //            /
        //           6
        int[] data2 = {4, 6, 7, 5};
        System.out.println("true: " + test.verifySequenceOfBST(data2));

        //               5
        //              /
        //             4
        //            /
        //           3
        //          /
        //         2
        //        /
        //       1
        int[] data3 = {1, 2, 3, 4, 5};
        System.out.println("true: " + test.verifySequenceOfBST(data3));

        // 1
        //  \
        //   2
        //    \
        //     3
        //      \
        //       4
        //        \
        //         5
        int[] data4 = {5, 4, 3, 2, 1};
        System.out.println("true: " + test.verifySequenceOfBST(data4));

        // 树中只有1个结点
        int[] data5 = {5};
        System.out.println("true: " + test.verifySequenceOfBST(data5));

        int[] data6 = {7, 4, 6, 5};
        System.out.println("false: " + test.verifySequenceOfBST(data6));

        int[] data7 = {4, 6, 12, 8, 16, 14, 10};
        System.out.println("false: " + test.verifySequenceOfBST(data7));
    }
}

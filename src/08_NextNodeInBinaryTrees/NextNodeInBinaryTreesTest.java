/**
 * @Author sdh
 * @Date Created in 2019/2/20 19:33
 * @description
 */
public class NextNodeInBinaryTreesTest
{
    public static void main(String[] args)
    {
        NextNodeInBinaryTrees test = new NextNodeInBinaryTrees();

        //                            1
        //                  2                   3
        //             4         5          6          7
        //          8     9   10   11    12   13    14   15

        TreeLinkNode n1 = new TreeLinkNode(1); // 12
        TreeLinkNode n2 = new TreeLinkNode(2); // 10
        TreeLinkNode n3 = new TreeLinkNode(3); // 14
        TreeLinkNode n4 = new TreeLinkNode(4); // 9
        TreeLinkNode n5 = new TreeLinkNode(5); // 11
        TreeLinkNode n6 = new TreeLinkNode(6); // 13
        TreeLinkNode n7 = new TreeLinkNode(7); // 15
        TreeLinkNode n8 = new TreeLinkNode(8); // 4
        TreeLinkNode n9 = new TreeLinkNode(9); // 2
        TreeLinkNode n10 = new TreeLinkNode(10); // 5
        TreeLinkNode n11 = new TreeLinkNode(11); // 1
        TreeLinkNode n12 = new TreeLinkNode(12); // 6
        TreeLinkNode n13 = new TreeLinkNode(13); // 3
        TreeLinkNode n14 = new TreeLinkNode(14); // 7
        TreeLinkNode n15 = new TreeLinkNode(15); // null
        assemble(n1, n2, n3, null);
        assemble(n2, n4, n5, n1);
        assemble(n3, n6, n7, n1);
        assemble(n4, n8, n9, n2);
        assemble(n5, n10, n11, n2);
        assemble(n6, n12, n13, n3);
        assemble(n7, n14, n15, n3);
        assemble(n8, null, null, n4);
        assemble(n9, null, null, n4);
        assemble(n10, null, null, n5);
        assemble(n11, null, null, n5);
        assemble(n12, null, null, n6);
        assemble(n13, null, null, n6);
        assemble(n14, null, null, n7);
        assemble(n15, null, null, n7);
        System.out.println(test.getNext(n1).val);
        System.out.println(test.getNext(n2).val);
        System.out.println(test.getNext(n3).val);
        System.out.println(test.getNext(n4).val);
        System.out.println(test.getNext(n5).val);
        System.out.println(test.getNext(n6).val);
        System.out.println(test.getNext(n7).val);
        System.out.println(test.getNext(n8).val);
        System.out.println(test.getNext(n9).val);
        System.out.println(test.getNext(n10).val);
        System.out.println(test.getNext(n11).val);
        System.out.println(test.getNext(n12).val);
        System.out.println(test.getNext(n13).val);
        System.out.println(test.getNext(n14).val);
        System.out.println(test.getNext(n15));
    }

    public static void assemble(TreeLinkNode node, TreeLinkNode left, TreeLinkNode right, TreeLinkNode parent)
    {
        node.left = left;
        node.right = right;
        node.next = parent;
    }
}

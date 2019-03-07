/**
 * @Author sdh
 * @Date Created in 2019/3/7 10:28
 * @description
 */
public class CommonParentInTreeTest
{
    public static void main(String[] args)
    {
        CommonParentInTree test = new CommonParentInTree();
        
        test01(test);
        System.out.println("==========");

        test02(test);
        System.out.println("==========");

        test03(test);
    }

    // 形状普通的树
    //             1
    //           /   \
    //         2      3
    //        /         \
    //      4            5
    //     / \        /  |  \
    //    6   7      8   9  10
    private static void test01(CommonParentInTree test)
    {
        CommonTreeNode n1 = new CommonTreeNode(1);
        CommonTreeNode n2 = new CommonTreeNode(2);
        CommonTreeNode n3 = new CommonTreeNode(3);
        CommonTreeNode n4 = new CommonTreeNode(4);
        CommonTreeNode n5 = new CommonTreeNode(5);
        CommonTreeNode n6 = new CommonTreeNode(6);
        CommonTreeNode n7 = new CommonTreeNode(7);
        CommonTreeNode n8 = new CommonTreeNode(8);
        CommonTreeNode n9 = new CommonTreeNode(9);
        CommonTreeNode n10 = new CommonTreeNode(10);
        n1.children.add(n2);
        n1.children.add(n3);
        n2.children.add(n4);
        n4.children.add(n6);
        n4.children.add(n7);
        n3.children.add(n5);
        n5.children.add(n8);
        n5.children.add(n9);
        n5.children.add(n10);
        System.out.println(test.getLastCommonParent(n1, n6, n8).val);
    }

    // 树退化成一个链表
    //          1
    //         /
    //        2
    //       /
    //      3
    //     /
    //    4
    //   /
    //  5
    private static void test02(CommonParentInTree test)
    {
        CommonTreeNode n1 = new CommonTreeNode(1);
        CommonTreeNode n2 = new CommonTreeNode(2);
        CommonTreeNode n3 = new CommonTreeNode(3);
        CommonTreeNode n4 = new CommonTreeNode(4);
        CommonTreeNode n5 = new CommonTreeNode(5);
        n1.children.add(n2);
        n2.children.add(n3);
        n3.children.add(n4);
        n4.children.add(n5);
        System.out.println(test.getLastCommonParent(n1, n4, n5).val);
    }
    
    // 树退化成一个链表，一个结点不在树中
    //               1
    //              /
    //             2
    //            /
    //           3
    //          /
    //         4
    //        /
    //       5
    private static void test03(CommonParentInTree test)
    {
        CommonTreeNode n1 = new CommonTreeNode(1);
        CommonTreeNode n2 = new CommonTreeNode(2);
        CommonTreeNode n3 = new CommonTreeNode(3);
        CommonTreeNode n4 = new CommonTreeNode(4);
        CommonTreeNode n5 = new CommonTreeNode(5);
        CommonTreeNode n6 = new CommonTreeNode(6);
        n1.children.add(n2);
        n2.children.add(n3);
        n3.children.add(n4);
        n4.children.add(n5);
        System.out.println(test.getLastCommonParent(n1, n5, n6));
    }
}

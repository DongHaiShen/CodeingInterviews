/**
 * @Author sdh
 * @Date Created in 2019/2/25 13:14
 * @description
 */
public class DeleteDuplicatedNodeTest
{
    public static void main(String[] args)
    {
        DeleteDuplicatedNode test = new DeleteDuplicatedNode();

        test01(test);
        test02(test);
        test03(test);
        test04(test);
        test05(test);
        test06(test);
        test07(test);
        test08(test);
        test09(test);
        test10(test);
    }

    public static void test01(DeleteDuplicatedNode test)
    {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        ListNode result = test.deleteDuplication(n1);
        print(result);
    }

    // 1->2->3->4->5->6->7
    public static void test02(DeleteDuplicatedNode test)
    {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        ListNode result = test.deleteDuplication(n1);
        print(result);
    }

    // 1->1->1->1->1->1->2
    public static void test03(DeleteDuplicatedNode test)
    {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(1);
        ListNode n7 = new ListNode(2);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        ListNode result = test.deleteDuplication(n1);
        print(result);
    }


    // 1->1->1->1->1->1->1
    public static void test04(DeleteDuplicatedNode test)
    {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(1);
        ListNode n7 = new ListNode(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        ListNode result = test.deleteDuplication(n1);
        print(result);
    }

    // 1->1->2->2->3->3->4->4
    public static void test05(DeleteDuplicatedNode test)
    {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(3);
        ListNode n7 = new ListNode(4);
        ListNode n8 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        ListNode result = test.deleteDuplication(n1);
        print(result);
    }

    // 1->1->2->3->3->4->5->5
    public static void test06(DeleteDuplicatedNode test)
    {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);
        ListNode n8 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        ListNode result = test.deleteDuplication(n1);
        print(result);
    }

    // 1->1->2->2->3->3->4->5->5
    public static void test07(DeleteDuplicatedNode test)
    {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(3);
        ListNode n7 = new ListNode(4);
        ListNode n8 = new ListNode(5);
        ListNode n9 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;

        ListNode result = test.deleteDuplication(n1);
        print(result);
    }

    // 1->2
    public static void test08(DeleteDuplicatedNode test)
    {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);

        n1.next = n2;

        ListNode result = test.deleteDuplication(n1);
        print(result);
    }

    // 1
    public static void test09(DeleteDuplicatedNode test)
    {
        ListNode n1 = new ListNode(1);
        ListNode result = test.deleteDuplication(n1);
        print(result);
    }

    // null
    public static void test10(DeleteDuplicatedNode test)
    {
        ListNode result = test.deleteDuplication(null);
        print(result);
    }

    public static void print(ListNode head)
    {
        while (head != null)
        {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }
}

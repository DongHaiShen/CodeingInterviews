/**
 * @Author sdh
 * @Date Created in 2019/2/26 14:16
 * @description
 */
public class EntryNodeInListLoopTest
{
    public static void main(String[] args)
    {
        EntryNodeInListLoop test = new EntryNodeInListLoop();
        test01(test);
        test02(test);
        test03(test);
    }

    // 1->2->3->4->5->6
    public static void test01(EntryNodeInListLoop test)
    {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        System.out.println(test.entryNodeOfLoop(n1));
    }

    // 1->2->3->4->5->6
    //       ^        |
    //       |        |
    //       +--------+
    public static void test02(EntryNodeInListLoop test)
    {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n3;

        System.out.println(test.entryNodeOfLoop(n1).val);
    }

    // 1->2->3->4->5->6 <-+
    //                |   |
    //                +---+
    public static void test03(EntryNodeInListLoop test)
    {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n6;

        System.out.println(test.entryNodeOfLoop(n1).val);
    }
}

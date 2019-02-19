/**
 * @Author sdh
 * @Date Created in 2019/2/19 18:23
 * @description
 */
public class PrintListInReversedOrderTest
{
    public static void main(String[] args)
    {
        PrintListInReversedOrder test = new PrintListInReversedOrder();

        ListNode root = new ListNode();
        root.val = 1;
        root.next = new ListNode();
        root.next.val = 2;
        root.next.next = new ListNode();
        root.next.next.val = 3;
        root.next.next.next = new ListNode();
        root.next.next.next.val = 4;
        root.next.next.next.next = new ListNode();
        root.next.next.next.next.val = 5;

        System.out.println(test.printListFromTailToHeadIteratively(root));
        System.out.println();
        System.out.println(test.printListFromTailToHeadRecursively(root));
    }
}

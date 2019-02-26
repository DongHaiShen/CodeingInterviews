/**
 * @Author sdh
 * @Date Created in 2019/2/26 15:42
 * @description
 */
public class ReverseListTest
{
    public static void main(String[] args)
    {
        ReverseList test = new ReverseList();

        ListNode head = new ListNode();
        head.val = 1;

        head.next = new ListNode();
        head.next.val = 2;

        head.next.next = new ListNode();
        head.next.next.val = 3;

        head.next.next.next = new ListNode();
        head.next.next.next.val = 4;

        head.next.next.next.next = new ListNode();
        head.next.next.next.next.val = 5;

        head.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.val = 6;

        head.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.val = 7;

        head.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.val = 8;

        head.next.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.next.val = 9;

        printList(head);
        head = test.reverseList(head);
        printList(head);
    }

    public static void printList(ListNode head)
    {
        while (head != null)
        {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }
}

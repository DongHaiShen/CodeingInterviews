/**
 * @Author sdh
 * @Date Created in 2019/2/26 16:20
 * @description
 */
public class MergeSortedListsTest
{
    public static void printList(ListNode head)
    {
        while (head != null)
        {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args)
    {
        MergeSortedLists test = new MergeSortedLists();

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


        ListNode head2 = new ListNode();
        head2.val = 1;

        head2.next = new ListNode();
        head2.next.val = 3;

        head2.next.next = new ListNode();
        head2.next.next.val = 5;

        head2.next.next.next = new ListNode();
        head2.next.next.next.val = 6;

        head2.next.next.next.next = new ListNode();
        head2.next.next.next.next.val = 7;

        head = test.merge(head, head2);
        printList(head);
    }
}

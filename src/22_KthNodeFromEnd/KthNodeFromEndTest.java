/**
 * @Author sdh
 * @Date Created in 2019/2/26 13:37
 * @description
 */
public class KthNodeFromEndTest
{
    public static void main(String[] args)
    {
        KthNodeFromEnd test = new KthNodeFromEnd();
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

        System.out.println(test.findKthToTail(head, 1).val); // 倒数第一个
        System.out.println(test.findKthToTail(head, 5).val); // 中间的一个
        System.out.println(test.findKthToTail(head, 9).val); // 倒数最后一个就是顺数第一个

        System.out.println(test.findKthToTail(head, 10));
    }
}

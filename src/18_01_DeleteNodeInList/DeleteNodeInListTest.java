/**
 * @Author sdh
 * @Date Created in 2019/2/25 11:27
 * @description
 */
public class DeleteNodeInListTest
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
        DeleteNodeInList test = new DeleteNodeInList();

        ListNode head = new ListNode();
        head.val = 1;

        head.next = new ListNode();
        head.next.val = 2;

        head.next.next = new ListNode();
        head.next.next.val = 3;

        head.next.next.next = new ListNode();
        head.next.next.next.val = 4;

        ListNode middle = head.next.next.next.next = new ListNode();
        head.next.next.next.next.val = 5;

        head.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.val = 6;

        head.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.val = 7;

        head.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.val = 8;

        ListNode last = head.next.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.next.val = 9;

        head = test.deleteNode(head, null); // 删除的结点为空
        printList(head);
        ListNode node = new ListNode();
        node.val = 12;

        head = test.deleteNode(head, head); // 删除头结点
        printList(head);
        head = test.deleteNode(head, last); // 删除尾结点
        printList(head);
        head = test.deleteNode(head, middle); // 删除中间结点
        printList(head);

        head = test.deleteNode(head, node); // 删除的结点不在链表中
        printList(head);
    }
}

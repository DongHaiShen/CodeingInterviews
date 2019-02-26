/**
 * @Author sdh
 * @Date Created in 2019/2/26 15:42
 * @description
 */

/**
 * 【题目】 反转链表
 * <p>
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList
{
    /**
     * 反转链表
     *
     * @param head 链表头
     * @return 反转后的链表
     */
    public ListNode reverseList(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }

        // 分别记录前一个节点、当前节点和后一个节点
        ListNode pre = head, cur = head.next, next = null;
        while (cur != null)
        {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        // 把原头节点指向null，pre成为新头节点
        head.next = null;
        head = pre;

        return head;
    }
}

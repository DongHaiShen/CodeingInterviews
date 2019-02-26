/**
 * @Author sdh
 * @Date Created in 2019/2/26 13:37
 * @description
 */

/**
 * 【题目】 链表中倒数第k个结点
 * <p>
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class KthNodeFromEnd
{
    /**
     * 找出链表倒数第k个节点，k从1开始
     *
     * @param head 链表头部
     * @param k    倒数第k个
     * @return 倒数第k个节点
     */
    public ListNode findKthToTail(ListNode head, int k)
    {
        if (head == null || k <= 0)
        {
            return null;
        }

        // 使用双指针，第一个指针先走 k-1 步
        ListNode pre = head;
        for (int i = 0; i < k - 1; i++)
        {
            // k比链表总结点n大，使得指向了null
            if (pre.next == null)
            {
                return null;
            }
            pre = pre.next;
        }

        // 然后两个指针一起走
        // 当第一个指针到链表末尾，第二个指针刚好指向倒数第k个
        ListNode cur = head;
        while (pre.next != null)
        {
            pre = pre.next;
            cur = cur.next;
        }
        return cur;
    }
}

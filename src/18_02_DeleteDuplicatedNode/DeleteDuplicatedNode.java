/**
 * @Author sdh
 * @Date Created in 2019/2/25 13:14
 * @description
 */

/**
 * 【题目】 删除链表中重复的节点
 * <p>
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5。
 */
public class DeleteDuplicatedNode
{
    /**
     * 删除链表重复的节点
     *
     * @param pHead 链表头节点
     * @return 删除后的头结点
     */
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null || pHead.next == null)
        {
            return pHead;
        }

        ListNode pre = null, cur = pHead;

        while (cur != null)
        {
            if (cur.next != null && cur.val == cur.next.val)
            {
                // 查找全部与当前节点值重复的节点
                int val = cur.val;
                while (cur.next != null && cur.next.val == val)
                {
                    cur = cur.next;
                }

                // pre为null说明头结点也重复
                if (pre == null)
                {
                    pHead = cur.next;
                }
                else
                {
                    // pre始终与下一个不重复的节点相连
                    pre.next = cur.next;
                }
            }
            else
            {
                pre = cur;
            }
            cur = cur.next;
        }

        return pHead;
    }
}

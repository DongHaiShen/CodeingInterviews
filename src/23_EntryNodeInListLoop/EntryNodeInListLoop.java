/**
 * @Author sdh
 * @Date Created in 2019/2/26 14:16
 * @description
 */

/**
 * 【题目】 链表中环的入口结点
 * <p>
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class EntryNodeInListLoop
{
    /**
     * 求链表环的入口，若没有环，返回null
     *
     * @param pHead 链表头
     * @return 环的入口
     */
    public ListNode entryNodeOfLoop(ListNode pHead)
    {
        if (pHead == null)
        {
            return null;
        }

        ListNode fast = pHead, slow = pHead;

        // 利用快慢两个指针
        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;

            // 如果能两个指针能相遇，说明有环
            if (fast == slow)
            {
                break;
            }
        }

        // 如果不相遇，说明无环
        if (fast == null || fast.next == null)
        {
            return null;
        }

        // 此时将一个指针重置回链表头，两个指针速度相同
        // 则它们必将在入口出重逢
        fast = pHead;
        while (fast != slow)
        {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}

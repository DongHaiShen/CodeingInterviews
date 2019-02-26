/**
 * @Author sdh
 * @Date Created in 2019/2/26 16:20
 * @description
 */

/**
 * 【题目】 合并两个排序的链表
 * <p>
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class MergeSortedLists
{
    /**
     * 合并两个排序链表
     *
     * @param list1 链表1
     * @param list2 链表2
     * @return 合并后的链表头
     */
    public ListNode merge(ListNode list1, ListNode list2)
    {
        if (list1 == null)
        {
            return list2;
        }
        if (list2 == null)
        {
            return list1;
        }

        // head方便添加元素，cur指向合并后链表的末尾
        ListNode head = new ListNode(-1), cur = head;
        while (list1 != null && list2 != null)
        {
            // 根据节点值大小选择添加
            if (list1.val < list2.val)
            {
                cur.next = list1;
                list1 = list1.next;
            }
            else
            {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        // 如果某个链表未处理完，则直接加到合并链表的末尾
        if (list1 != null)
        {
            cur.next = list1;
        }

        if (list2 != null)
        {
            cur.next = list2;
        }

        return head.next;
    }
}

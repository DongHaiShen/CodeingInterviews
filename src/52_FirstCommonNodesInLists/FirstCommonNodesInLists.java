/**
 * @Author sdh
 * @Date Created in 2019/3/5 15:36
 * @description
 */

/**
 * 【题目】 两个链表的第一个公共节点
 * <p>
 * 输入两个链表，找出它们的第一个公共节点。
 */
public class FirstCommonNodesInLists
{
    /**
     * 寻找两个链表的第一个公共节点
     *
     * @param pHead1 链表1
     * @param pHead2 链表2
     * @return 第一个公共节点
     */
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2)
    {
        if (pHead1 == null || pHead2 == null)
        {
            return null;
        }

        int length1 = 0, length2 = 0;
        ListNode node1 = pHead1, node2 = pHead2;
        while (node1 != null)
        {
            length1++;
            node1 = node1.next;
        }
        while (node2 != null)
        {
            length2++;
            node2 = node2.next;
        }

        // 让长链表先走若干步，使得两个链表等长
        if (length1 > length2)
        {
            for (int i = 0; i < length1 - length2; i++)
            {
                pHead1 = pHead1.next;
            }
        }
        else
        {
            for (int i = 0; i < length2 - length1; i++)
            {
                pHead2 = pHead2.next;
            }
        }

        // 然后顺序遍历
        while (pHead1 != null && pHead2 != null)
        {
            if (pHead1 == pHead2)
            {
                return pHead1;
            }
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return null;
    }
}

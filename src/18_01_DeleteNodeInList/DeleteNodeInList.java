/**
 * @Author sdh
 * @Date Created in 2019/2/25 11:27
 * @description
 */

/**
 * 【题目】 在O(1)时间内删除链表节点
 * <p>
 * 给定单向链表的头指针和一个节点指针，定义一个函数在O(1)时间内删除该节点。
 */
public class DeleteNodeInList
{
    /**
     * 删除链表的节点
     *
     * @param head       链表头节点
     * @param tobeDelete 要删除的节点
     * @return 删除后的头结点
     */
    public ListNode deleteNode(ListNode head, ListNode tobeDelete)
    {
        if (head == null || tobeDelete == null)
        {
            return head;
        }

        // 删除的不是尾节点
        // 把下一个节点复制到该节点，再删除下一个节点
        if (tobeDelete.next != null)
        {
            tobeDelete.val = tobeDelete.next.val;
            tobeDelete.next = tobeDelete.next.next;
        }
        // 链表中仅有一个节点
        else if (head == tobeDelete)
        {
            head = null;
        }
        // 删除的是尾节点
        // 只能顺序遍历删除
        else
        {
            // 若删除节点不在链表中会报错，由于效率限制，这必须由调用者来保证
            ListNode temp = head;
            while (temp.next != tobeDelete)
            {
                temp = temp.next;
            }

            temp.next = null;
        }

        return head;
    }
}

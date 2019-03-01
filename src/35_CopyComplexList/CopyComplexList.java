/**
 * @Author sdh
 * @Date Created in 2019/3/1 13:57
 * @description
 */

/**
 * 【题目】 复杂链表的复制
 * <p>
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的 head。
 * 注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空
 */
public class CopyComplexList
{
    /**
     * 复杂链表的复制
     *
     * @param pHead 链表头结点
     * @return 复制的链表
     */
    public RandomListNode clone(RandomListNode pHead)
    {
        if (pHead == null)
        {
            return null;
        }

        // 第一步：复制节点，并插入至被复制节点的后面
        RandomListNode cur = pHead;
        while (cur != null)
        {
            RandomListNode cloneNode = new RandomListNode(cur.label);
            cloneNode.next = cur.next;
            cur.next = cloneNode;
            cur = cloneNode.next;
        }

        // 第二步：连接复制节点对应的随机节点
        cur = pHead;
        while (cur != null)
        {
            if (cur.random != null)
            {
                cur.next.random = cur.random.next;
            }

            cur = cur.next.next;
        }

        // 第三步：把原链表和复制链表分离
        // 最终pHead为原链表，pHead.next为复制链表
        cur = pHead;
        RandomListNode result = pHead.next, temp;
        while (cur.next != null)
        {
            temp = cur.next;
            cur.next = temp.next;
            cur = temp;
        }
        return result;
    }
}
[TOC]

## 删除链表中重复的节点

在一个**排序**的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
例如，链表1->2->3->3->4->4->5 处理后为 1->2->5。

### 解法
+ 由于题目中的链表是**排序**的，因此可以顺序遍历，若前后两个节点的值相同，则删除；
+ 为了确保删除后的链表仍是相连的，需要将当前节点的前一个节点和第一个不重复的节点相连，因此利用一个 $pre$ 节点记录前一个节点，并维持 $pre$ 始终与下一个不重复的节点相连；
+ 此外需要注意的是，头结点也有可能被删除。


#### 代码
```java
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
```



### 测试用例参考
1. 功能测试（重复的节点位于链表的头部/中间/尾部；链表中没有重复的节点）；
2. 特殊输入测试（指向链表头节点的为空指针；链表中所有节点都是重复的）。



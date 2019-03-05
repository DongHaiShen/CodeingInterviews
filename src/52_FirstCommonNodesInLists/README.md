[TOC]

## 两个链表的第一个公共节点

输入两个链表，找出它们的第一个公共节点。

### 解法
+ 采用22中的思想：当用一个指针遍历链表不能解决，可以考虑用两个指针；
+ 首先遍历两个链表，求出各自的长度，然后让长链表先走若干步，使得两个链表等长；
+ 之后只需顺序遍历判断即可


#### 代码
```java
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
```



### 测试用例参考
1. 功能测试（输入的两个链表有公共节点；第一个公共节点在链表的中间，第一个公共节点在链表的末尾，第一个公共节点是链表的头节点；输入的两个链表没有公共节点）；
2. 特殊输入测试（输入的链表头节点是空指针）。

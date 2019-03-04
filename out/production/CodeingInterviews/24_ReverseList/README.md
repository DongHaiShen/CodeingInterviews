[TOC]

## 反转链表

输入一个链表，反转链表后，输出新链表的表头。

### 解法
使用三个指针 $pre$, $cur$ 和 $next$，分别记录前一个节点、当前节点和后一个节点：
+ 以 $cur$ 为观测视角，需要先将其后一个节点保存至 $next$，**否则改变指针后无法再获取**；
+ 然后将 $cur$ 指向其前一个节点；
+ 指针向后移动一格，顺序操作至尾部；
+ 最后将原头节点指向 null，$pre$ 成为新头节点


#### 代码
```java
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
```



### 测试用例参考
1. 功能测试（链表中有多个结点/只有一个节点）；
2. 特殊输入测试（链表头节点为空指针）。





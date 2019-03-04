[TOC]

## 链表中环的入口结点

给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。

### 解法
利用两个指针 $fast$ 和$slow$，$fast$ 一次走两步，$slow$ 一次走一步：
+ 如果有环，则 $fast$ 和 $slow$ **一定会在环中相遇**；
+ 此时将一个指针**重置回链表头**，然后**两个指针都一次走一步**；
+ **最终它们必定会在环的入口出重逢** （\*）

上述解法中的 (\*) 式经测试正确，但尚未得知如何推导，常规方法是：
+ **从相遇点开始，一边向前移动一边计数，直到再次回到相遇点，即可得到环中节点数 $n$**；
+ 然后将两个指针都重置回链表头，**让一个指针先行 $n$ 步**，然后一起移动，当相遇时正好是环的入口处，因为快指针比慢指针多走了环的一圈


#### 代码
```java
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
```



### 测试用例参考
1. 功能测试（链表中包含/不包含环；链表中有多个或者只有一个节点）；
2. 特殊输入测试（链表头节点为空指针）。





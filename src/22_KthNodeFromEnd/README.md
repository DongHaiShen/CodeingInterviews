[TOC]

## 链表中倒数第k个结点

输入一个链表，输出该链表中倒数第 $k$ 个结点。

### 解法
+ 常规解法是先遍历一次得到链表总节点数 $n$，然后再找出倒数第 $k$ 个，**需要遍历两遍**；
+ 为了实现只遍历一次，可以**定义两个指针**：
  1. **第一个指针先走 $k-1$ 步**；
  2. **然后两个指针一起走**；
  3. 那么当第一个指针到链表末尾，第二个指针刚好指向倒数第k个
+ 需要注意一些特殊情况：
  1. 链表为空；
  2. $k$ 小于等于0；
  3. **$k$ 比链表总节点 $n$ 还要大**

**注意：当用一个指针遍历链表不能解决，可以考虑用两个指针，让其中一个走的快一些，或是让它先走若干步**


#### 代码
```java
public class KthNodeFromEnd
{
    /**
     * 找出链表倒数第k个节点，k从1开始
     *
     * @param head 链表头部
     * @param k    倒数第k个
     * @return 倒数第k个节点
     */
    public ListNode findKthToTail(ListNode head, int k)
    {
        if (head == null || k <= 0)
        {
            return null;
        }

        // 使用双指针，第一个指针先走 k-1 步
        ListNode pre = head;
        for (int i = 0; i < k - 1; i++)
        {
            // k比链表总结点n大，使得指向了null
            if (pre.next == null)
            {
                return null;
            }
            pre = pre.next;
        }

        // 然后两个指针一起走
        // 当第一个指针到链表末尾，第二个指针刚好指向倒数第k个
        ListNode cur = head;
        while (pre.next != null)
        {
            pre = pre.next;
            cur = cur.next;
        }
        return cur;
    }
}
```



### 测试用例参考
1. 功能测试（第 k 个节点在链表的中间/头部/尾部）；
2. 特殊输入测试（输入空指针；链表的节点总数小于 k；k=0）。



### 相关题目
1. 求链表的中间节点。若节点总数为奇数，返回中间节点；若为偶数，返回中间两个节点中的任意一个
+ 定义两个指针，**一个指针一次走一步，另一个一次走两步**；
+ 当走得快的指针走到末尾，走的慢的指针正好指向中间




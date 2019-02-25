[TOC]

## 在O(1)时间内删除链表节点

给定单向链表的头指针和一个节点指针，定义一个函数在O(1)时间内删除该节点。

### 解法
常规思路是顺序遍历找到节点后删除，显然复杂度为O(n)，因为需要找到被删除节点的前一个节点

可以采用另一种巧妙的方式，不需要查找前一个节点：
+ 为了删除节点 $i$，**可以先把节点 $i$ 的下一个节点 $j$ 的内容复制给 $i$**；
+ 同时把 $i$ 的指针指向 $j$ 的下一个节点；
+ 然后把 $j$ 给删除，则效果和查找并删除 $i$ 相同

此外，若被删除节点为尾节点，则只能顺序遍历删除，不过平均复杂度为：
$( (n-1) * O(1) + O(n) ) / n = O(1)$， 符合要求

**注意：该方法需要保证被删除节点确实在链表中**，因为判断链表中是否包含某节点本身需要 O(n) 时间。由于受到 O(1) 的时间限制，这只能由调用者来保证

#### 代码
```java
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
```



### 测试用例参考
1. 功能测试（从有多个节点的链表的中间/头部/尾部删除一个节点；从只有一个节点的链表中删除唯一的节点）；
2. 特殊输入测试（指向链表头节点的为空指针；指向要删除节点的为空指针）。



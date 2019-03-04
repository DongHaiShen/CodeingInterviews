[TOC]

## 从尾到头打印链表

### 题目描述
输入一个链表的头节点，按链表值从尾到头的顺序返回一个ArrayList

### 解法

#### 解法1 （推荐）
**利用栈结构 "后进先出" 的特性**，先将链表节点依次压入栈，然后再依次存入数组

时间复杂度：O(n)

空间复杂度：O(n)

#### 代码
```java
import java.util.ArrayList;
import java.util.Stack;

public class PrintListInReversedOrder
{
    /**
     * 利用栈结构先进后出的特性，先把链表中的节点压入栈，然后再依次存入数组
     *
     * @param listNode 链表头节点
     * @return 反序后的arraylist
     */
    public ArrayList<Integer> printListFromTailToHeadIteratively(ListNode listNode)
    {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (listNode == null)
        {
            return arrayList;
        }

        Stack<Integer> stack = new Stack<>();
        while (listNode != null)
        {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty())
        {
            arrayList.add(stack.pop());
        }

        return arrayList;
    }
}
```



#### 解法2
**利用递归的思想**：

+ 若当前节点不是尾节点，则继续递归向后；
+ 否则存入到数组中；
+ 利用调用栈将节点值反向存入数组

时间复杂度：O(n)

空间复杂度：O(n) 

**注意：当链表较长时，函数调用层级会很深，容易导致栈溢出**

#### 代码
```java
import java.util.ArrayList;
import java.util.Stack;

public class PrintListInReversedOrder
{
    /**
     * 利用递归的方式，不断向后查找直至尾节点，然后根据调用栈依次存入数组
     *
     * @param listNode 链表头节点
     * @return 反序后的arraylist
     */
    public ArrayList<Integer> printListFromTailToHeadRecursively(ListNode listNode)
    {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (listNode == null)
        {
            return arrayList;
        }

        addListNodeRecursively(listNode, arrayList);
        return arrayList;
    }

    /**
     * 通过递归反向添加节点值
     *
     * @param listNode  链表头节点
     * @param arrayList 反序后的arraylist
     */
    public void addListNodeRecursively(ListNode listNode, ArrayList<Integer> arrayList)
    {
        if (listNode.next != null)
        {
            addListNodeRecursively(listNode.next, arrayList);
        }
        arrayList.add(listNode.val);
    }
}
```



### 测试用例参考
1. 功能测试（输入的链表有多个结点；输入的链表只有一个结点）；
2. 特殊输入测试（输入的链表结点指针为空）。
import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author sdh
 * @Date Created in 2019/2/19 18:22
 * @description
 */

/**
 * 【题目】 从尾到头打印链表
 * <p>
 * 输入一个链表的头节点，按链表值从尾到头的顺序返回一个ArrayList
 */
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

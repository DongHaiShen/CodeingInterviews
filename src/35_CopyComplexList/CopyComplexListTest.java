/**
 * @Author sdh
 * @Date Created in 2019/3/1 13:57
 * @description
 */
public class CopyComplexListTest
{
    public static void main(String[] args)
    {
        CopyComplexList test = new CopyComplexList();

        //          -----------------
        //         \|/              |
        //  1-------2-------3-------4-------5
        //  |       |      /|\             /|\
        //  --------+--------               |
        //          -------------------------
        RandomListNode head = new RandomListNode();
        head.label = 1;
        head.next = new RandomListNode();
        head.next.label = 2;
        head.next.next = new RandomListNode();
        head.next.next.label = 3;
        head.next.next.next = new RandomListNode();
        head.next.next.next.label = 4;
        head.next.next.next.next = new RandomListNode();
        head.next.next.next.next.label = 5;

        head.random = head.next.next;
        head.next.random = head.next.next.next.next.next;
        head.next.next.next.random = head.next;

        RandomListNode tmp = head;
        printList(head);
        RandomListNode newHead = test.clone(head);
        printList(head);
        System.out.println(isSame(head, tmp));
        printList(newHead);
        System.out.println(isSame(head, newHead));


        // 有指向自身的情况
        //          -----------------
        //         \|/              |
        //  1-------2-------3-------4-------5
        //         |       | /|\           /|\
        //         |       | --             |
        //         |------------------------|
        RandomListNode head2 = new RandomListNode();
        head2.label = 1;
        head2.next = new RandomListNode();
        head2.next.label = 2;
        head2.next.next = new RandomListNode();
        head2.next.next.label = 3;
        head2.next.next.next = new RandomListNode();
        head2.next.next.next.label = 4;
        head2.next.next.next.next = new RandomListNode();
        head2.next.next.next.next.label = 5;

        head2.next.random = head2.next.next.next.next;
        head2.next.next.next.random = head2.next.random;
        head2.next.next.random = head2.next.next;

        System.out.println("\n");
        tmp = head2;
        printList(head2);
        RandomListNode newHead2 = test.clone(head2);
        printList(head2);
        System.out.println(isSame(head2, tmp));
        printList(newHead2);
        System.out.println(isSame(head2, newHead2));


        RandomListNode head3 = new RandomListNode();
        head3.label = 1;

        System.out.println("\n");
        tmp = head3;
        printList(head3);
        RandomListNode newHead3 = test.clone(head3);
        printList(head3);
        System.out.println(isSame(head3, tmp));
        printList(newHead3);
        System.out.println(isSame(head3, newHead3));

        System.out.println("\n");
        RandomListNode head4 = test.clone(null);
        printList(head4);
    }

    /**
     * 输出链表信息
     *
     * @param head 链表头结点
     */
    public static void printList(RandomListNode head)
    {
        while (head != null)
        {
            System.out.print(head.label + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    /**
     * 判断两个链表是否是同一个链表，不是值相同
     *
     * @param h1 链表头1
     * @param h2 链表头2
     * @return true：两个链表是同一个链表，false：不是
     */
    public static boolean isSame(RandomListNode h1, RandomListNode h2)
    {
        while (h1 != null && h2 != null)
        {
            if (h1 == h2)
            {
                h1 = h1.next;
                h2 = h2.next;
            }
            else
            {
                return false;
            }
        }

        return h1 == null && h2 == null;
    }
}

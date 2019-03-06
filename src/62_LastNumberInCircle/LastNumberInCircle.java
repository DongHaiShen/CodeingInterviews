import java.util.LinkedList;

/**
 * @Author sdh
 * @Date Created in 2019/3/6 18:22
 * @description
 */

/**
 * 【题目】 圆圈中最后剩下的数字
 * <p>
 * 0，1，……n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第 m个数字
 * 求出这个圆圈里剩下的最后一个数字（约瑟夫环问题）
 */
public class LastNumberInCircle
{
    /**
     * 链表模拟过程
     *
     * @param n n个数
     * @param m 每次删除第m个
     * @return 最后结果
     */
    public int lastRemainingWithList(int n, int m)
    {
        if (n == 0 || m == 0)
        {
            return -1;
        }

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++)
        {
            list.add(i);
        }

        int next = 0;
        while (list.size() > 1)
        {
            next = (next + m - 1) % list.size();
            list.remove(next);
        }
        return list.get(0);
    }

    /**
     * 利用公式
     *
     * @param n n个数
     * @param m 每次删除第m个
     * @return 最后结果
     */
    public int lastRemainingWithFormula(int n, int m)
    {
        if (n == 0 || m == 0)
        {
            return -1;
        }

        int result = 0;

        for (int i = 2; i <= n; i++)
        {
            result = (result + m) % i;
        }
        return result;
    }
}

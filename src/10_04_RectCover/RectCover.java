/**
 * @Author sdh
 * @Date Created in 2019/2/21 17:14
 * @description
 */

/**
 * 【题目】 矩形覆盖
 * <p>
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class RectCover
{
    /**
     * 矩形覆盖的方法数
     *
     * @param target 被覆盖矩形的大小为 2*target
     * @return 覆盖方法数
     */
    public int rectCover(int target)
    {
        if (target < 3)
        {
            return target;
        }

        int prePre = 1, pre = 2, cur = prePre + pre;

        for (int i = 3; i <= target; i++)
        {
            cur = prePre + pre;
            prePre = pre;
            pre = cur;
        }
        return cur;
    }
}

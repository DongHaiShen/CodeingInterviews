/**
 * @Author sdh
 * @Date Created in 2019/2/21 16:52
 * @description
 */

/**
 * 【题目】 跳台阶
 * <p>
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class JumpFloor
{
    /**
     * 跳台阶的跳法数
     *
     * @param target 台阶的级数
     * @return 跳法数
     */
    public int jumpFloor(int target)
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

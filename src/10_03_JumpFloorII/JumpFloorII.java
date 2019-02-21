/**
 * @Author sdh
 * @Date Created in 2019/2/21 17:04
 * @description
 */

/**
 * 【题目】 变态跳台阶
 * <p>
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class JumpFloorII
{
    /**
     * 跳台阶的跳法数
     *
     * @param target 台阶的级数
     * @return 跳法数
     */
    public int jumpFloorII(int target)
    {
        return (int) Math.pow(2, target - 1);
    }
}

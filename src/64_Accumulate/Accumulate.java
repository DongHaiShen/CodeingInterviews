/**
 * @Author sdh
 * @Date Created in 2019/3/6 19:21
 * @description
 */

/**
 * 【题目】 求1+2+……+n
 * <p>
 * 求1+2+……+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 */
public class Accumulate
{
    /**
     * 求1+2+……+n
     *
     * @param n 数字n
     * @return 计算结果
     */
    public int sum(int n)
    {
        int result = n;

        // 利用逻辑与短路，当n减到0，前者为false，直接跳过后续判断
        boolean flag = (result > 0) && ((result += sum(n - 1)) > 0);
        return result;
    }
}

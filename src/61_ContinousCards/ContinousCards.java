import java.util.Arrays;

/**
 * @Author sdh
 * @Date Created in 2019/3/6 18:02
 * @description
 */

/**
 * 【题目】 扑克牌的顺子
 * <p>
 * 从扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10 为数字本身，A 为 1，J 为 11，Q 为 12，K 为 13，大小王可以看做任意数字。
 * 为了方便，大小王均以 0 来表示，并且假设这副牌中大小王均有两张。
 */
public class ContinousCards
{
    /**
     * 判断牌是否连续
     *
     * @param numbers 数组
     * @return 判断结果
     */
    public boolean isContinuous(int[] numbers)
    {
        if (numbers == null || numbers.length == 0)
        {
            return false;
        }

        // 先排序
        Arrays.sort(numbers);

        // 统计0的个数
        int zeroCount = 0;
        for (int e : numbers)
        {
            if (e == 0)
            {
                zeroCount++;
            }
        }

        // 王最多只有4张
        if (zeroCount > 4)
        {
            return false;
        }

        // 统计总空缺值
        int gap = 0;
        for (int i = zeroCount; i < numbers.length - 1; i++)
        {
            if (numbers[i] == numbers[i + 1])
            {
                return false;
            }
            gap += numbers[i + 1] - numbers[i] - 1;
        }

        // 0的个数是否足以填补空缺值
        return zeroCount >= gap;
    }
}

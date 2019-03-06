/**
 * @Author sdh
 * @Date Created in 2019/3/6 18:54
 * @description
 */
public class MaximalProfitTest
{
    public static void main(String[] args)
    {
        MaximalProfit test = new MaximalProfit();

        int[] data1 = new int[]{9, 11, 8, 5, 7, 12, 16, 14};
        int[] data2 = new int[]{9, 8, 7, 6, 5, 4, 3, 1};
        System.out.println(test.maxDiff(data1)); // 11
        System.out.println(test.maxDiff(data2)); // -1
    }
}

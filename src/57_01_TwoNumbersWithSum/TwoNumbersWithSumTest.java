import java.util.ArrayList;

/**
 * @Author sdh
 * @Date Created in 2019/3/6 12:48
 * @description
 */
public class TwoNumbersWithSumTest
{
    public static void main(String[] args)
    {
        TwoNumbersWithSum test = new TwoNumbersWithSum();

        int[] data = new int[]{1, 2, 4, 7, 11, 15};
        ArrayList<Integer> result = test.findNumbersWithSum(data, 15);
        System.out.println(result.get(0));
        System.out.println(result.get(1));

        int[] data2 = {1, 2, 4, 7, 11, 16};
        ArrayList<Integer> result2 = test.findNumbersWithSum(data2, 17);
        System.out.println(result2.get(0));
        System.out.println(result2.get(1));

        int[] data3 = {1, 2, 4, 7, 11, 16};
        ArrayList<Integer> result3 = test.findNumbersWithSum(data3, 10);
        System.out.println(result3.get(0));
        System.out.println(result3.get(1));
    }
}

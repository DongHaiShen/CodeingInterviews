/**
 * @Author sdh
 * @Date Created in 2019/3/5 12:12
 * @description
 */
public class MaxValueOfGiftsTest
{
    public static void main(String[] args)
    {
        MaxValueOfGifts test = new MaxValueOfGifts();

        int[][] data = {
                {1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5}};
        System.out.println(test.getMaxValue(data));
    }
}

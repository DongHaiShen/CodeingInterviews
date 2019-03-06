/**
 * @Author sdh
 * @Date Created in 2019/3/6 14:43
 * @description
 */
public class MaxInSlidingWindowTest
{
    public static void main(String[] args)
    {
        MaxInSlidingWindow test = new MaxInSlidingWindow();

        // {};
        int[] data1 = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(test.maxInWindows(data1, 10));

        // {3, 3, 5, 5, 6, 7};
        int[] data2 = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(test.maxInWindows(data2, 3));

        // {7, 9, 11, 13, 15};
        int[] data3 = new int[]{1, 3, 5, 7, 9, 11, 13, 15};
        System.out.println(test.maxInWindows(data3, 4));

        //  {16, 14, 12};
        int[] data4 = new int[]{16, 14, 12, 10, 8, 6, 4};
        System.out.println(test.maxInWindows(data4, 5));

        //  {10, 14, 12, 11};
        int[] data5 = new int[]{10, 14, 12, 11};
        System.out.println(test.maxInWindows(data5, 1));

        //  {14};
        int[] data6 = new int[]{10, 14, 12, 11};
        System.out.println(test.maxInWindows(data6, 4));
    }
}

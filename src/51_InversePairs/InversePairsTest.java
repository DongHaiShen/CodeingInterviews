/**
 * @Author sdh
 * @Date Created in 2019/3/5 14:54
 * @description
 */
public class InversePairsTest
{
    public static void main(String[] args)
    {
        InversePairs test = new InversePairs();

        int[] data = {1, 2, 3, 4, 7, 6, 5};
        System.out.println(test.inversePairs(data)); // 3

        int[] data2 = {6, 5, 4, 3, 2, 1};
        System.out.println(test.inversePairs(data2)); //  15

        int[] data3 = {1, 2, 3, 4, 5, 6};
        System.out.println(test.inversePairs(data3)); // 0

        int[] data4 = {1};
        System.out.println(test.inversePairs(data4)); // 0

        int[] data5 = {1, 2};
        System.out.println(test.inversePairs(data5)); // 0

        int[] data6 = {2, 1};
        System.out.println(test.inversePairs(data6)); // 1

        int[] data7 = {1, 2, 1, 2, 1};
        System.out.println(test.inversePairs(data7)); // 3
    }
}

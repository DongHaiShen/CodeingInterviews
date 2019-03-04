/**
 * @Author sdh
 * @Date Created in 2019/3/4 16:22
 * @description
 */
public class GreatestSumOfSubarraysTest
{
    public static void main(String[] args)
    {
        GreatestSumOfSubarrays test = new GreatestSumOfSubarrays();

        int[] data = {1, -2, 3, 10, -4, 7, 2, -5};
        int[] data2 = {-2, -8, -1, -5, -9};
        int[] data3 = {2, 8, 1, 5, 9};

        System.out.println(test.findGreatestSumOfSubArray(data));
        System.out.println(test.findGreatestSumOfSubArray(data2));
        System.out.println(test.findGreatestSumOfSubArray(data3));
        System.out.println();

        System.out.println(test.findGreatestSumOfSubArrayWithDP(data));
        System.out.println(test.findGreatestSumOfSubArrayWithDP(data2));
        System.out.println(test.findGreatestSumOfSubArrayWithDP(data3));
    }
}

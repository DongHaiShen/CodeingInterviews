/**
 * @Author sdh
 * @Date Created in 2019/3/6 10:45
 * @description
 */
public class NumberAppearingOnceTest
{
    public static void main(String[] args)
    {
        NumberAppearingOnce test = new NumberAppearingOnce();

        int[] data1 = new int[]{10, 4, 5, 3, 5, 4, 3, 3, 4, 5};
        int[] data2 = new int[]{0, -4, 5, 3, 5, -4, 3, 3, -4, 5};
        int[] data3 = new int[]{-10, -4, 5, 3, 5, -4, 3, 3, -4, 5};
        System.out.println(test.findNumberAppearingOnce(data1));
        System.out.println(test.findNumberAppearingOnce(data2));
        System.out.println(test.findNumberAppearingOnce(data3));
    }
}

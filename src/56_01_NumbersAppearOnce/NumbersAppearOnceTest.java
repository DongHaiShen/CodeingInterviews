/**
 * @Author sdh
 * @Date Created in 2019/3/6 9:59
 * @description
 */
public class NumbersAppearOnceTest
{
    public static void main(String[] args)
    {
        NumbersAppearOnce test = new NumbersAppearOnce();

        int[] data1 = {2, 4, 3, 6, 3, 2, 5, 5};
        int num1[] = {0}, num2[] = {0};
        test.findNumsAppearOnce(data1, num1, num2);
        System.out.println(num1[0] + " " + num2[0]);

        int[] data2 = {4, 6};
        test.findNumsAppearOnce(data2, num1, num2);
        System.out.println(num1[0] + " " + num2[0]);

        int[] data3 = {4, 6, 1, 1, 1, 1};
        test.findNumsAppearOnce(data3, num1, num2);
        System.out.println(num1[0] + " " + num2[0]);
    }
}

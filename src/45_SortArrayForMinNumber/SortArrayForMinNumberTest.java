/**
 * @Author sdh
 * @Date Created in 2019/3/4 18:40
 * @description
 */
public class SortArrayForMinNumberTest
{
    public static void main(String[] args)
    {
        SortArrayForMinNumber test = new SortArrayForMinNumber();

        int[] data = {3, 5, 1, 4, 2};
        System.out.println(test.printMinNumber(data));

        int[] data2 = {3, 32, 321};
        System.out.println(test.printMinNumber(data2));

        int[] data3 = {3, 323, 32123};
        System.out.println(test.printMinNumber(data3));

        int[] data4 = {1, 11, 111};
        System.out.println(test.printMinNumber(data4));

        int[] data5 = {321};
        System.out.println(test.printMinNumber(data5));
    }
}

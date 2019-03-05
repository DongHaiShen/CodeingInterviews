/**
 * @Author sdh
 * @Date Created in 2019/3/5 16:42
 * @description
 */
public class MissingNumberTest
{
    public static void main(String[] args)
    {
        MissingNumber test = new MissingNumber();

        int[] data1 = new int[]{0, 1, 2, 3, 4, 5}; //6
        int[] data2 = new int[]{0, 1, 3, 4, 5}; //2
        int[] data3 = new int[]{1, 2}; //0
        int[] data4 = new int[]{0, 1}; //2
        System.out.println(test.getMissingNumber(data1));
        System.out.println(test.getMissingNumber(data2));
        System.out.println(test.getMissingNumber(data3));
        System.out.println(test.getMissingNumber(data4));
    }
}

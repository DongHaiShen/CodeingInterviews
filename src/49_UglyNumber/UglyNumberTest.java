/**
 * @Author sdh
 * @Date Created in 2019/3/5 13:36
 * @description
 */
public class UglyNumberTest
{
    public static void main(String[] args)
    {
        UglyNumber test = new UglyNumber();

        System.out.println(test.getUglyNumber(1)); // 1
        System.out.println(test.getUglyNumber(2)); // 2
        System.out.println(test.getUglyNumber(3)); // 3
        System.out.println(test.getUglyNumber(4)); // 4
        System.out.println(test.getUglyNumber(5)); // 5
        System.out.println(test.getUglyNumber(6)); // 6
        System.out.println(test.getUglyNumber(7)); // 8
        System.out.println(test.getUglyNumber(8)); // 9
        System.out.println(test.getUglyNumber(9)); // 10
        System.out.println(test.getUglyNumber(10)); // 12
        System.out.println(test.getUglyNumber(11)); // 15
        System.out.println(test.getUglyNumber(1500)); // 859963392
        System.out.println(test.getUglyNumber(0)); // 0
    }
}

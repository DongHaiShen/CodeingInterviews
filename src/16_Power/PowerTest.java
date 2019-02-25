/**
 * @Author sdh
 * @Date Created in 2019/2/25 10:31
 * @description
 */
public class PowerTest
{
    public static void main(String[] args)
    {
        Power test= new Power();

        System.out.println(0.0000000000000000000000001111 == 0);
        System.out.println(0.0000000000000000000000000000 == 0);

        System.out.println(test.power(2, -4));
        System.out.println(test.power(2, 4));
        System.out.println(test.power(2, 0));
        System.out.println(test.power(0.00000000000000000000000000001, -1));
        System.out.println(test.power(0.00000000000000000000000000001, 1));
        System.out.println(test.power(0.00000000000000000000000000001, 0));
        System.out.println(test.power(0.00000000000000000000000000000, 0));

    }
}

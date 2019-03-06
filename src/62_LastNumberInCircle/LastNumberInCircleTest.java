/**
 * @Author sdh
 * @Date Created in 2019/3/6 18:22
 * @description
 */
public class LastNumberInCircleTest
{
    public static void main(String[] args)
    {
        LastNumberInCircle test = new LastNumberInCircle();

        System.out.println(test.lastRemainingWithList(5, 3)); // 最后余下3
        System.out.println(test.lastRemainingWithList(5, 2)); // 最后余下2
        System.out.println(test.lastRemainingWithList(6, 7)); // 最后余下4
        System.out.println(test.lastRemainingWithList(6, 6)); // 最后余下3
        System.out.println(test.lastRemainingWithList(0, 0)); // -1
        System.out.println(test.lastRemainingWithList(4000, 997)); // 1027
        System.out.println();


        System.out.println(test.lastRemainingWithFormula(5, 3)); // 最后余下3
        System.out.println(test.lastRemainingWithFormula(5, 2)); // 最后余下2
        System.out.println(test.lastRemainingWithFormula(6, 7)); // 最后余下4
        System.out.println(test.lastRemainingWithFormula(6, 6)); // 最后余下3
        System.out.println(test.lastRemainingWithFormula(0, 0)); // -1
        System.out.println(test.lastRemainingWithFormula(4000, 997)); // 1027
    }
}

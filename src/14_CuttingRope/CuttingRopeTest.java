/**
 * @Author sdh
 * @Date Created in 2019/2/23 19:32
 * @description
 */
public class CuttingRopeTest
{
    public static void main(String[] args)
    {
        CuttingRope test = new CuttingRope();

        System.out.println(test.maxProductAfterCuttingWithDP(16));
        System.out.println(test.maxProductAfterCuttingWithDP(2));
        System.out.println(test.maxProductAfterCuttingWithDP(3));
        System.out.println(test.maxProductAfterCuttingWithDP(4));

        System.out.println(test.maxProductAfterCuttingWithGreed(16));
        System.out.println(test.maxProductAfterCuttingWithGreed(2));
        System.out.println(test.maxProductAfterCuttingWithGreed(3));
        System.out.println(test.maxProductAfterCuttingWithGreed(4));
    }
}

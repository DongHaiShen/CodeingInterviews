/**
 * @Author sdh
 * @Date Created in 2019/2/27 18:12
 * @description
 */
public class StackPushPopOrderTest
{
    public static void main(String[] args)
    {
        StackPushPopOrder test = new StackPushPopOrder();
        
        int[] push = {1, 2, 3, 4, 5};
        int[] pop1 = {4, 5, 3, 2, 1};
        int[] pop2 = {3, 5, 4, 2, 1};
        int[] pop3 = {4, 3, 5, 1, 2};
        int[] pop4 = {3, 5, 4, 1, 2};

        System.out.println("true: " + test.isPopOrder(push, pop1));
        System.out.println("true: " + test.isPopOrder(push, pop2));
        System.out.println("false: " + test.isPopOrder(push, pop3));
        System.out.println("false: " + test.isPopOrder(push, pop4));

        int[] push5 = {1};
        int[] pop5 = {2};
        System.out.println("false: " + test.isPopOrder(push5, pop5));

        int[] push6 = {1};
        int[] pop6 = {1};
        System.out.println("true: " + test.isPopOrder(push6, pop6));

        System.out.println("false: " + test.isPopOrder(null, null));
    }
}

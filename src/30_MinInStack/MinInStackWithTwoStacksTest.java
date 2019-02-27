/**
 * @Author sdh
 * @Date Created in 2019/2/27 16:06
 * @description
 */
public class MinInStackWithTwoStacksTest
{
    public static void main(String[] args)
    {
        MinInStackWithTwoStacks test = new MinInStackWithTwoStacks();

        test.push(3);
        System.out.println(test.min() == 3);
        test.push(4);
        System.out.println(test.min() == 3);
        test.push(2);
        System.out.println(test.min() == 2);
        test.push(3);
        System.out.println(test.min() == 2);
        test.pop();
        System.out.println(test.min() == 2);
        test.pop();
        System.out.println(test.min() == 3);
        test.push(0);
        System.out.println(test.min() == 0);
//        test.pop();
//        test.pop();
//        test.pop();
        System.out.println(test.top());
        System.out.println(test.min());
    }
}

/**
 * @Author sdh
 * @Date Created in 2019/2/20 22:29
 * @description
 */
public class StackWithTwoQueuesTest
{
    public static void main(String[] args)
    {
        StackWithTwoQueues test = new StackWithTwoQueues();
        System.out.println(test.pop());

        test.push(1);
        test.push(2);
        test.push(3);
        System.out.println(test.pop());
        System.out.println(test.pop());

        test.push(4);
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
    }
}

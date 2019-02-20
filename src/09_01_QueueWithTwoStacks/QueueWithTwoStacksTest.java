/**
 * @Author sdh
 * @Date Created in 2019/2/20 21:21
 * @description
 */
public class QueueWithTwoStacksTest
{
    public static void main(String[] args)
    {
        QueueWithTwoStacks test = new QueueWithTwoStacks();
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

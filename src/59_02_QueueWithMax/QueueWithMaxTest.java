/**
 * @Author sdh
 * @Date Created in 2019/3/6 15:48
 * @description
 */
public class QueueWithMaxTest
{
    public static void main(String[] args)
    {
        QueueWithMax test = new QueueWithMax();

        test.offer(2);
        test.offer(3);
        test.offer(4);
        test.offer(2);
        test.offer(6);
        test.offer(2);
        test.offer(5);
        test.offer(1);
        System.out.println(test.max()); // 6

        test.poll();
        test.poll();
        test.poll();
        test.poll();
        System.out.println(test.max()); // 6

        test.poll();
        System.out.println(test.max()); // 5

        test.poll();
        System.out.println(test.max()); // 5

        test.poll();
        System.out.println(test.max()); // 1
    }
}

/**
 * @Author sdh
 * @Date Created in 2019/3/4 15:47
 * @description
 */
public class StreamMedianTest
{
    public static void main(String[] args)
    {
        StreamMedian test = new StreamMedian();

        test.insert(5);
        System.out.println(test.getMedian()); // 5

        test.insert(2);
        System.out.println(test.getMedian()); // 3.5

        test.insert(3);
        System.out.println(test.getMedian()); // 3

        test.insert(4);
        System.out.println(test.getMedian()); // 3.5

        test.insert(1);
        System.out.println(test.getMedian()); // 3

        test.insert(6);
        System.out.println(test.getMedian()); // 3.5

        test.insert(7);
        System.out.println(test.getMedian()); // 4

        test.insert(0);
        System.out.println(test.getMedian()); // 3.5

        test.insert(8);
        System.out.println(test.getMedian()); // 4
    }
}

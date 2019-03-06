/**
 * @Author sdh
 * @Date Created in 2019/3/6 13:13
 * @description
 */
public class ContinuousSquenceWithSumTest
{
    public static void main(String[] args)
    {
        ContinuousSquenceWithSum test = new ContinuousSquenceWithSum();

        System.out.println(test.findContinuousSequence(1));
        System.out.println(test.findContinuousSequence(3));
        System.out.println(test.findContinuousSequence(4));
        System.out.println(test.findContinuousSequence(9));
        System.out.println(test.findContinuousSequence(15));
        System.out.println(test.findContinuousSequence(100));
    }
}

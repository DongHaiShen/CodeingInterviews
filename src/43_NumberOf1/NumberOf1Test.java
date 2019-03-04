/**
 * @Author sdh
 * @Date Created in 2019/3/4 16:57
 * @description
 */
public class NumberOf1Test
{
    public static void main(String[] args)
    {
        NumberOf1 test = new NumberOf1();

        System.out.println(test.numberOf1Between1AndN(1)); // 1
        System.out.println(test.numberOf1Between1AndN(5)); // 1
        System.out.println(test.numberOf1Between1AndN(10)); // 2
        System.out.println(test.numberOf1Between1AndN(55)); // 16
        System.out.println(test.numberOf1Between1AndN(99)); // 20
        System.out.println(test.numberOf1Between1AndN(10000)); // 4001
        System.out.println(test.numberOf1Between1AndN(21345)); // 18821
        System.out.println(test.numberOf1Between1AndN(0)); // 0
    }
}

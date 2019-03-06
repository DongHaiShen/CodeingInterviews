/**
 * @Author sdh
 * @Date Created in 2019/3/6 19:38
 * @description
 */
public class AddTwoNumbersTest
{
    public static void main(String[] args)
    {
        AddTwoNumbers test = new AddTwoNumbers();

        System.out.println(test.add(1, 2) + ", " + (1 + 2));
        System.out.println(test.add(13, 34) + ", " + (13 + 34));
        System.out.println(test.add(19, 85) + ", " + (19 + 95));
        System.out.println(test.add(865, 245) + ", " + (865 + 245));
    }
}

/**
 * @Author sdh
 * @Date Created in 2019/3/6 14:23
 * @description
 */
public class LeftRotateStringTest
{
    public static void main(String[] args)
    {
        LeftRotateString test = new LeftRotateString();

        System.out.println(new String(test.leftRotateString("abcdefg", 2)));
        System.out.println(new String(test.leftRotateString("abcdefg", 1)));
        System.out.println(new String(test.leftRotateString("abcdefg", 6)));
        System.out.println(new String(test.leftRotateString("abcdefg", 7)));
        System.out.println(new String(test.leftRotateString("abcdefg", 0)));
    }
}

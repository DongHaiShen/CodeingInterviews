/**
 * @Author sdh
 * @Date Created in 2019/3/5 14:06
 * @description
 */
public class FirstNotRepeatingCharTest
{
    public static void main(String[] args)
    {
        FirstNotRepeatingChar test = new FirstNotRepeatingChar();
        
        System.out.println(test.firstNotRepeatingChar("google")); // 4
        System.out.println(test.firstNotRepeatingChar("aabccdbd")); // -1
        System.out.println(test.firstNotRepeatingChar("abcdefg")); // 0
        System.out.println(test.firstNotRepeatingChar("gfedcba")); // 0
        System.out.println(test.firstNotRepeatingChar("zgfedcba")); // 0
    }
}

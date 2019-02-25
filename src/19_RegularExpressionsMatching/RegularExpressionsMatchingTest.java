/**
 * @Author sdh
 * @Date Created in 2019/2/25 14:06
 * @description
 */
public class RegularExpressionsMatchingTest
{
    public static void main(String[] args)
    {
        RegularExpressionsMatching test = new RegularExpressionsMatching();

        System.out.println(test.match("".toCharArray(), "".toCharArray()) + "[" + true + "]");
        System.out.println(test.match("".toCharArray(), ".*".toCharArray()) + "[" + true + "]");
        System.out.println(test.match("".toCharArray(), ".".toCharArray()) + "[" + false + "]");
        System.out.println(test.match("".toCharArray(), "c*".toCharArray()) + "[" + true + "]");
        System.out.println();

        System.out.println(test.match("a".toCharArray(), ".*".toCharArray()) + "[" + true + "]");
        System.out.println(test.match("a".toCharArray(), "a.".toCharArray()) + "[" + false + "]");
        System.out.println(test.match("a".toCharArray(), "".toCharArray()) + "[" + false + "]");
        System.out.println(test.match("a".toCharArray(), ".".toCharArray()) + "[" + true + "]");
        System.out.println(test.match("a".toCharArray(), "ab*".toCharArray()) + "[" + true + "]");
        System.out.println(test.match("a".toCharArray(), "ab*a".toCharArray()) + "[" + false + "]");
        System.out.println();

        System.out.println(test.match("aa".toCharArray(), "aa".toCharArray()) + "[" + true + "]");
        System.out.println(test.match("aa".toCharArray(), "a*".toCharArray()) + "[" + true + "]");
        System.out.println(test.match("aa".toCharArray(), ".*".toCharArray()) + "[" + true + "]");
        System.out.println(test.match("aa".toCharArray(), ".".toCharArray()) + "[" + false + "]");
        System.out.println();

        System.out.println(test.match("ab".toCharArray(), ".*".toCharArray()) + "[" + true + "]");
        System.out.println(test.match("ab".toCharArray(), ".*".toCharArray()) + "[" + true + "]");
        System.out.println();

        System.out.println(test.match("aaa".toCharArray(), "aa*".toCharArray()) + "[" + true + "]");
        System.out.println(test.match("aaa".toCharArray(), "aa.a".toCharArray()) + "[" + false + "]");
        System.out.println(test.match("aaa".toCharArray(), "a.a".toCharArray()) + "[" + true + "]");
        System.out.println(test.match("aaa".toCharArray(), ".a".toCharArray()) + "[" + false + "]");
        System.out.println(test.match("aaa".toCharArray(), "a*a".toCharArray()) + "[" + true + "]");
        System.out.println(test.match("aaa".toCharArray(), "ab*a".toCharArray()) + "[" + false + "]");
        System.out.println(test.match("aaa".toCharArray(), "ab*ac*a".toCharArray()) + "[" + true + "]");
        System.out.println(test.match("aaa".toCharArray(), "ab*a*c*a".toCharArray()) + "[" + true + "]");
        System.out.println(test.match("aaa".toCharArray(), ".*".toCharArray()) + "[" + true + "]");
        System.out.println();

        System.out.println(test.match("aab".toCharArray(), "c*a*b".toCharArray()) + "[" + true + "]");
        System.out.println();

        System.out.println(test.match("aaca".toCharArray(), "ab*a*c*a".toCharArray()) + "[" + true + "]");
        System.out.println(test.match("aaba".toCharArray(), "ab*a*c*a".toCharArray()) + "[" + false + "]");
        System.out.println(test.match("bbbba".toCharArray(), ".*a*a".toCharArray()) + "[" + true + "]");
        System.out.println(test.match("bcbbabab".toCharArray(), ".*a*a".toCharArray()) + "[" + false + "]");
    }
}

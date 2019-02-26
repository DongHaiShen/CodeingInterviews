/**
 * @Author sdh
 * @Date Created in 2019/2/26 10:47
 * @description
 */
public class NumericStringsTest
{
    public static void main(String[] args)
    {
        NumericStrings test = new NumericStrings();

        System.out.println(test.isNumeric("100".toCharArray()) + "[" + true + "]");
        System.out.println(test.isNumeric("123.45e+6".toCharArray()) + "[" + true + "]");
        System.out.println(test.isNumeric("+500".toCharArray()) + "[" + true + "]");
        System.out.println(test.isNumeric("5e2".toCharArray()) + "[" + true + "]");
        System.out.println(test.isNumeric("3.1416".toCharArray()) + "[" + true + "]");
        System.out.println(test.isNumeric("600.".toCharArray()) + "[" + true + "]");
        System.out.println(test.isNumeric("-.123".toCharArray()) + "[" + true + "]");
        System.out.println(test.isNumeric("-1E-16".toCharArray()) + "[" + true + "]");
        System.out.println(test.isNumeric("100".toCharArray()) + "[" + true + "]");
        System.out.println(test.isNumeric("1.79769313486232E+308".toCharArray()) + "[" + true + "]");
        System.out.println();

        System.out.println(test.isNumeric("12e".toCharArray()) + "[" + false + "]");
        System.out.println(test.isNumeric("1a3.14".toCharArray()) + "[" + false + "]");
        System.out.println(test.isNumeric("1+23".toCharArray()) + "[" + false + "]");
        System.out.println(test.isNumeric("1.2.3".toCharArray()) + "[" + false + "]");
        System.out.println(test.isNumeric("+-5".toCharArray()) + "[" + false + "]");
        System.out.println(test.isNumeric("12e+5.4".toCharArray()) + "[" + false + "]");
    }
}

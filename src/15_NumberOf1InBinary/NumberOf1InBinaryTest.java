/**
 * @Author sdh
 * @Date Created in 2019/2/23 21:44
 * @description
 */
public class NumberOf1InBinaryTest
{
    public static void main(String[] args)
    {
        NumberOf1InBinary test = new NumberOf1InBinary();

        System.out.println(test.numberOfOne(0B00000000_00000000_00000000_00000000)); // 0
        System.out.println(test.numberOfOne(0B00000000_00000000_00000000_00000001)); // 1
        System.out.println(test.numberOfOne(0B11111111_11111111_11111111_11111111)); // -1
        System.out.println(0B01111111_11111111_11111111_11111111 == Integer.MAX_VALUE);
        System.out.println(test.numberOfOne(0B01111111_11111111_11111111_11111111)); // Integer.MAX_VALUE
        System.out.println(0B10000000_00000000_00000000_00000000 == Integer.MIN_VALUE);
        System.out.println(test.numberOfOne(0B10000000_00000000_00000000_00000000)); // Integer.MIN_VALUE

        System.out.println("");
        System.out.println(test.numberOfOneWithFormula(0B00000000_00000000_00000000_00000000)); // 0
        System.out.println(test.numberOfOneWithFormula(0B00000000_00000000_00000000_00000001)); // 1
        System.out.println(test.numberOfOneWithFormula(0B11111111_11111111_11111111_11111111)); // -1
        System.out.println(test.numberOfOneWithFormula(0B01111111_11111111_11111111_11111111)); // Integer.MAX_VALUE
        System.out.println(test.numberOfOneWithFormula(0B10000000_00000000_00000000_00000000)); // Integer.MIN_VALUE
    }
}

/**
 * @Author sdh
 * @Date Created in 2019/2/21 15:12
 * @description
 */
public class FibonacciTest
{
    public static void main(String[] args)
    {
        Fibonacci test = new Fibonacci();

        System.out.println(test.fibonacciWithRecursion(10));
        System.out.println(test.fibonacciWithIteration(10));
        System.out.println(test.fibonacciWithMatrix(10));
        System.out.println(test.fibonacciWithFormula(10));
    }
}

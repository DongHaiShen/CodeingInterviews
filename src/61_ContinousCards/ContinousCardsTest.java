/**
 * @Author sdh
 * @Date Created in 2019/3/6 18:02
 * @description
 */
public class ContinousCardsTest
{
    public static void main(String[] args)
    {
        ContinousCards test = new ContinousCards();

        int[] numbers1 = {1, 3, 2, 5, 4};
        System.out.println(test.isContinuous(numbers1));

        int[] numbers2 = {1, 3, 2, 6, 4};
        System.out.println(test.isContinuous(numbers2));

        int[] numbers3 = {0, 3, 2, 6, 4};
        System.out.println(test.isContinuous(numbers3));

        int[] numbers4 = {0, 3, 1, 6, 4};
        System.out.println(test.isContinuous(numbers4));

        int[] numbers5 = {1, 3, 0, 5, 0};
        System.out.println(test.isContinuous(numbers5));

        int[] numbers6 = {1, 3, 0, 7, 0};
        System.out.println(test.isContinuous(numbers6));

        int[] numbers7 = {1, 0, 0, 5, 0};
        System.out.println(test.isContinuous(numbers7));

        int[] numbers8 = {1, 0, 0, 7, 0};
        System.out.println(test.isContinuous(numbers8));

        int[] numbers9 = {3, 0, 0, 0, 0};
        System.out.println(test.isContinuous(numbers9));

        int[] numbers10 = {0, 0, 0, 0, 0};
        System.out.println(test.isContinuous(numbers10));

        int[] numbers11 = {1, 0, 0, 1, 0};
        System.out.println(test.isContinuous(numbers11));
    }
}

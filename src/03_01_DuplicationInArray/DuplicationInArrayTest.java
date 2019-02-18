/**
 * @Author sdh
 * @Date Created in 2019/2/17 22:50
 * @description
 */
public class DuplicationInArrayTest
{
    public static void main(String[] args)
    {
        DuplicationInArray test = new DuplicationInArray();
        int duplication[] = new int[1];

        int[] numbers1 = {2, 1, 3, 1, 4};
        System.out.println(test.duplicate(numbers1, 5, duplication));

        int[] numbers2 = {2, 4, 3, 1, 4};
        System.out.println(test.duplicate(numbers2, 5, duplication));

        int[] numbers3 = {2, 4, 2, 1, 4};
        System.out.println(test.duplicate(numbers3, 5, duplication));

        int[] numbers4 = {2, 1, 3, 0, 4};
        System.out.println(test.duplicate(numbers4, 5, duplication));

        int[] numbers5 = {2, 1, 3, 5, 4};
        System.out.println(test.duplicate(numbers5, 5, duplication));
    }
}

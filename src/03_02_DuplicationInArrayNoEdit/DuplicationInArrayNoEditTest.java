/**
 * @Author sdh
 * @Date Created in 2019/2/18 16:19
 * @description
 */
public class DuplicationInArrayNoEditTest
{
    public static void main(String[] args)
    {
        DuplicationInArrayNoEdit test = new DuplicationInArrayNoEdit();
        int duplication[] = new int[1];

        int[] numbers1 = {2, 1, 3, 1, 4};
        System.out.println(test.getDuplication(numbers1));

        int[] numbers2 = {2, 4, 3, 1, 4};
        System.out.println(test.getDuplication(numbers2));

        int[] numbers3 = {2, 4, 2, 1, 4};
        System.out.println(test.getDuplication(numbers3));

        int[] numbers4 = {2, 1, 3, 5, 4};
        System.out.println(test.getDuplication(numbers4));
    }
}

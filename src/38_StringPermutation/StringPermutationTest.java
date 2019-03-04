import java.util.ArrayList;

/**
 * @Author sdh
 * @Date Created in 2019/3/4 9:53
 * @description
 */
public class StringPermutationTest
{
    public static void main(String[] args)
    {
        StringPermutation test = new StringPermutation();

        String s1 = "abc";
        print(test.permutation(s1));
        System.out.println();

        String s2 = "abcd";
        print(test.permutation(s2));
    }

    public static void print(ArrayList<String> result)
    {
        for (String s : result)
        {
            System.out.println(s);
        }
    }
}

/**
 * @Author sdh
 * @Date Created in 2019/3/5 14:33
 * @description
 */
public class FirstCharacterInStreamTest
{
    public static void main(String[] args)
    {
        FirstCharacterInStream test = new FirstCharacterInStream();

        String str = "google";
        for (int i = 0; i < str.length(); i++)
        {
            test.insert(str.charAt(i));
            System.out.println(test.firstAppearingOnce());
        }
    }
}

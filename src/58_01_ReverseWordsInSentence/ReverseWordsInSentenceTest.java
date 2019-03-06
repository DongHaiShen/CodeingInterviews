/**
 * @Author sdh
 * @Date Created in 2019/3/6 13:43
 * @description
 */
public class ReverseWordsInSentenceTest
{
    public static void main(String[] args)
    {
        ReverseWordsInSentence test = new ReverseWordsInSentence();

        System.out.println(new String(test.reverseSentence("I am a student.")));
        System.out.println(new String(test.reverseSentence("Wonderful")));
        System.out.println(new String(test.reverseSentence("")));
        System.out.println(new String(test.reverseSentence("    ")));
    }
}

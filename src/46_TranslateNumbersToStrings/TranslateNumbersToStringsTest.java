/**
 * @Author sdh
 * @Date Created in 2019/3/5 10:21
 * @description
 */
public class TranslateNumbersToStringsTest
{
    public static void main(String[] args)
    {
        TranslateNumbersToStrings test = new TranslateNumbersToStrings();

        System.out.println(test.getTranslationCount(-10));  //0
        System.out.println(test.getTranslationCount(1234));  //3
        System.out.println(test.getTranslationCount(12258)); //5
        System.out.println(test.getTranslationCount(12)); //2
        System.out.println(test.getTranslationCount(23)); //2
        System.out.println(test.getTranslationCount(34)); //1
        System.out.println(test.getTranslationCount(3)); //1
    }
}

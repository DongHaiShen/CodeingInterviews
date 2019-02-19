/**
 * @Author sdh
 * @Date Created in 2019/2/18 22:39
 * @description
 */
public class ReplaceSpacesTest
{
    public static void main(String[] args)
    {
        ReplaceSpaces test = new ReplaceSpaces();

        StringBuffer stringBuffer1 = new StringBuffer("We are happy.");
        System.out.println(test.replaceSpace(stringBuffer1));

        StringBuffer stringBuffer2 = new StringBuffer(" Wearehappy.");
        System.out.println(test.replaceSpace(stringBuffer2));

        StringBuffer stringBuffer3 = new StringBuffer("Wearehappy. ");
        System.out.println(test.replaceSpace(stringBuffer3));

        StringBuffer stringBuffer4 = new StringBuffer("Wearehappy.");
        System.out.println(test.replaceSpace(stringBuffer4));

        StringBuffer stringBuffer5 = null;
        System.out.println(test.replaceSpace(stringBuffer5));

        StringBuffer stringBuffer6 = new StringBuffer("");
        System.out.println(test.replaceSpace(stringBuffer6));

        StringBuffer stringBuffer7 = new StringBuffer(" ");
        System.out.println(test.replaceSpace(stringBuffer7));

        StringBuffer stringBuffer8 = new StringBuffer("     ");
        System.out.println(test.replaceSpace(stringBuffer8));
    }
}

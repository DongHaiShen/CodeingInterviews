/**
 * @Author sdh
 * @Date Created in 2019/3/6 20:36
 * @description
 */
public class StringToIntTest
{
    public static void main(String[] args)
    {
        StringToInt test = new StringToInt();

        funcTest(test);
        edgeTest(test);
    }

    public static void funcTest(StringToInt test)
    {
        try
        {
            System.out.println(test.strToInt(" 100")); //100
            System.out.println(test.strToInt("-100")); //-100
            System.out.println(test.strToInt("0")); //0
            System.out.println(test.strToInt("-0"));//0
            System.out.println(test.strToInt("1.23"));  //1
            System.out.println(test.strToInt("-1.23")); //-1
            System.out.println(test.strToInt(".123"));  //0
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void edgeTest(StringToInt test)
    {
        try
        {
            System.out.println(test.strToInt("2147483647"));  //2147483647
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
            System.out.println(test.strToInt("-2147483647")); //-2147483647
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
            System.out.println(test.strToInt("2147483647"));  //2147483647
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
            System.out.println(test.strToInt("2147483648"));  //上溢
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
            System.out.println(test.strToInt("-2147483648")); //-2147483648
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
            System.out.println(test.strToInt("-2147483649")); //下溢
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
            System.out.println(test.strToInt(null)); //待转换字符串为null或空串
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
            System.out.println(test.strToInt(""));   //待转换字符串为null或空串
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}

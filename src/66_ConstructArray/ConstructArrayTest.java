/**
 * @Author sdh
 * @Date Created in 2019/3/6 19:53
 * @description
 */
public class ConstructArrayTest
{
    public static void main(String[] args)
    {
        ConstructArray test = new ConstructArray();

        int[] data = {1, 2, 3, 4, 5};
        print(test.multiply(data));

        int[] data1 = {1, 2, -3, 4, 5};
        print(test.multiply(data1));

        int[] data2 = {1, 2, 0, 4, 5};
        print(test.multiply(data2));

        int[] data3 = {};
        print(test.multiply(data3));
    }

    public static void print(int[] data)
    {
        for (int e: data)
        {
            System.out.print(e+ " ");
        }
        System.out.println();
    }
}

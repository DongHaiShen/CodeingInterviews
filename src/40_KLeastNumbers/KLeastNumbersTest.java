import java.util.ArrayList;

/**
 * @Author sdh
 * @Date Created in 2019/3/4 15:08
 * @description
 */
public class KLeastNumbersTest
{
    public static void main(String[] args)
    {
        KLeastNumbersWithPartition test1 = new KLeastNumbersWithPartition();
        KLeastNumbersWithHeap test2 = new KLeastNumbersWithHeap();
        System.out.println("第一种解法：");
        test1(test1);
        System.out.println();
        System.out.println("第二种解法：");
        test2(test2);

    }

    public static void test1(KLeastNumbersWithPartition test)
    {
        int[] data = {4, 5, 1, 6, 2, 7, 3, 8};

        ArrayList<Integer> output = test.getLeastNumbers(data, 4);
        for (int i : output)
        {
            System.out.print(i + " ");
        }
        System.out.println();

        ArrayList<Integer> output2 = test.getLeastNumbers(data, 8);
        for (int i : output2)
        {
            System.out.print(i + " ");
        }
        System.out.println();


        ArrayList<Integer> output3 = test.getLeastNumbers(data, 1);
        for (int i : output3)
        {
            System.out.print(i + " ");
        }
        System.out.println();


        int[] data2 = {4, 5, 1, 6, 2, 7, 2, 8};
        ArrayList<Integer> output4 = test.getLeastNumbers(data2, 2);
        for (int i : output4)
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void test2(KLeastNumbersWithHeap test)
    {
        int[] data = {4, 5, 1, 6, 2, 7, 3, 8};

        ArrayList<Integer> output = test.getLeastNumbers(data, 4);
        for (int i : output)
        {
            System.out.print(i + " ");
        }
        System.out.println();

        ArrayList<Integer> output2 = test.getLeastNumbers(data, 8);
        for (int i : output2)
        {
            System.out.print(i + " ");
        }
        System.out.println();


        ArrayList<Integer> output3 = test.getLeastNumbers(data, 1);
        for (int i : output3)
        {
            System.out.print(i + " ");
        }
        System.out.println();


        int[] data2 = {4, 5, 1, 6, 2, 7, 2, 8};
        ArrayList<Integer> output4 = test.getLeastNumbers(data2, 2);
        for (int i : output4)
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

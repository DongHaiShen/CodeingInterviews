/**
 * @Author sdh
 * @Date Created in 2019/2/26 12:27
 * @description
 */
public class ReorderArrayTest
{
    public static void main(String[] args)
    {
        ReorderArray test = new ReorderArray();

        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        test.reOrderArrayWhileKeepOrder(array);
        printArray(array);
    }

    public static void printArray(int[] arr)
    {
        if (arr != null && arr.length > 0)
        {
            for (int i : arr)
            {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

/**
 * @Author sdh
 * @Date Created in 2019/2/18 19:18
 * @description
 */
public class FindInPartiallySortedMatrixTest
{
    public static void main(String[] args)
    {
        FindInPartiallySortedMatrix test = new FindInPartiallySortedMatrix();
        int[][] matrix = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(test.find(7, matrix));    // 要查找的数在数组中
        System.out.println(test.find(5, matrix));    // 要查找的数不在数组中
        System.out.println(test.find(1, matrix));    // 要查找的数是数组中最小的数字
        System.out.println(test.find(15, matrix));   // 要查找的数是数组中最大的数字
        System.out.println(test.find(0, matrix));    // 要查找的数比数组中最小的数字还小
        System.out.println(test.find(16, matrix));   // 要查找的数比数组中最大的数字还大
        System.out.println(test.find(16, null));     // 健壮性测试，输入空指针
    }
}

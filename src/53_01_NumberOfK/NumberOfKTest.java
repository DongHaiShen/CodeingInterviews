/**
 * @Author sdh
 * @Date Created in 2019/3/5 16:10
 * @description
 */
public class NumberOfKTest
{
    public static void main(String[] args)
    {
        NumberOfK test = new NumberOfK();

        // 查找的数字出现在数组的中间
        int[] data1 = {1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(test.getNumberOfK(data1, 3)); // 4

        // 查找的数组出现在数组的开头
        int[] data2 = {3, 3, 3, 3, 4, 5};
        System.out.println(test.getNumberOfK(data2, 3)); // 4

        // 查找的数组出现在数组的结尾
        int[] data3 = {1, 2, 3, 3, 3, 3};
        System.out.println(test.getNumberOfK(data3, 3)); // 4

        // 查找的数字不存在
        int[] data4 = {1, 3, 3, 3, 3, 4, 5};
        System.out.println(test.getNumberOfK(data4, 2)); // 0

        // 查找的数字比第一个数字还小，不存在
        int[] data5 = {1, 3, 3, 3, 3, 4, 5};
        System.out.println(test.getNumberOfK(data5, 0)); // 0

        // 查找的数字比最后一个数字还大，不存在
        int[] data6 = {1, 3, 3, 3, 3, 4, 5};
        System.out.println(test.getNumberOfK(data6, 0)); // 0

        // 数组中的数字从头到尾都是查找的数字
        int[] data7 = {3, 3, 3, 3};
        System.out.println(test.getNumberOfK(data7, 3)); // 4

        // 数组中的数字从头到尾只有一个重复的数字，不是查找的数字
        int[] data8 = {3, 3, 3, 3};
        System.out.println(test.getNumberOfK(data8, 4)); // 0

        // 数组中只有一个数字，是查找的数字
        int[] data9 = {3};
        System.out.println(test.getNumberOfK(data9, 3)); // 1

        // 数组中只有一个数字，不是查找的数字
        int[] data10 = {3};
        System.out.println(test.getNumberOfK(data10, 4)); // 0
    }
}

/**
 * @Author sdh
 * @Date Created in 2019/3/4 12:34
 * @description
 */
public class MoreThanHalfNumberTest
{
    public static void main(String[] args)
    {
        MoreThanHalfNumber test = new MoreThanHalfNumber();

        // 存在出现次数超过数组长度一半的数字
        int numbers[] = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(test.moreThanHalfNum(numbers));

        // 出现次数超过数组长度一半的数字都出现在数组的前半部分
        int numbers2[] = {2, 2, 2, 2, 2, 1, 3, 4, 5};
        System.out.println(test.moreThanHalfNum(numbers2));

        // 出现次数超过数组长度一半的数字都出现在数组的后半部分
        int numbers3[] = {1, 3, 4, 5, 2, 2, 2, 2, 2};
        System.out.println(test.moreThanHalfNum(numbers3));

        // 只有一个数
        int numbers4[] = {1};
        System.out.println(test.moreThanHalfNum(numbers4));

        // 输入空指针
        System.out.println(test.moreThanHalfNum(null));

        // 不存在出现次数超过数组长度一半的数字
        int numbers5[] = {1, 2, 3, 2, 4, 2, 5, 2, 3};
        System.out.println(test.moreThanHalfNum(numbers5));
    }
}

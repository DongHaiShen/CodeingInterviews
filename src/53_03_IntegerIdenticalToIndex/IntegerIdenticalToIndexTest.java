/**
 * @Author sdh
 * @Date Created in 2019/3/5 18:08
 * @description
 */
public class IntegerIdenticalToIndexTest
{
    public static void main(String[] args)
    {
        IntegerIdenticalToIndex test = new IntegerIdenticalToIndex();

        System.out.println(test.getNumberSameAsIndex(new int[]{-3, -1, 1, 3, 5})); // 3
        System.out.println(test.getNumberSameAsIndex(new int[]{0, 1, 2, 3, 4}));   // 0~4
        System.out.println(test.getNumberSameAsIndex(new int[]{4, 5, 6, 7, 8}));   // -1
    }
}

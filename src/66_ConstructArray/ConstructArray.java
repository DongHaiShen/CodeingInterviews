/**
 * @Author sdh
 * @Date Created in 2019/3/6 19:53
 * @description
 */

/**
 * 【题目】 构建乘积数组
 * <p>
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1]
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class ConstructArray
{
    /**
     * 构建乘积数组
     *
     * @param A 原数组
     * @return 乘积数组
     */
    public int[] multiply(int[] A)
    {
        if (A == null || A.length == 0)
        {
            return null;
        }

        int[] result = new int[A.length];
        result[0] = 1;

        // 自上而下计算左半部分乘积，即0~i-1
        for (int i = 1; i < A.length; i++)
        {
            result[i] = result[i - 1] * A[i - 1];
        }

        int temp = 1;
        for (int j = A.length - 2; j >= 0; j--)
        {
            // 先自下而上计算右半部分乘积，即n-1~i+1
            temp *= A[j + 1];

            // 然后和左半部分相乘
            result[j] *= temp;
        }
        return result;
    }
}

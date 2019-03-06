[TOC]

## 构建乘积数组

给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1]
其中B中的元素B[i]=A[0]\*A[1]\*...\*A[i-1]\*A[i+1]\*...*A[n-1]。不能使用除法。

### 解法
+ B[i] 中唯独少了 A[i]，即 B[i] 等于A中所有数字的乘积除以 A[i]，但要求不能用除法；
+ 可把 B[i] 拆分成 **A[0] 连乘至 A[i-1] 和 A[i+1] 连乘至 A[n-1] 两部分**，分别记为 C[i] 和 D[i]；
+ 可以自上而下计算 C[i]，即`C[i] = C[i-1] * A[i-1]`；
+ 同理可以自下而上计算 D[i]，即`D[i] = D[i+1] * A[i+1]`；
+ 最后把两部分相乘


#### 代码
```java
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
```



### 测试用例参考
1. 功能测试（输入数组包含正数、负数、一个0、多个0）；
2. 边界值测试（输入数组的长度为0）








[TOC]

## 矩形覆盖

我们可以用 $2*1$的小矩形横着或者竖着去覆盖更大的矩形。
请问用n个$2*1$的小矩形无重叠地覆盖一个$2*n$的大矩形，总共有多少种方法？

### 解法
为了覆盖$2*n$的大矩形，可以：
+ 先竖着放置一个 $2*1$ 的小矩形，剩下即为 $2*(n-1)$个大矩形
+ 先横着放置一个 $2*1$ 的小矩形，显然在其下方也必须放置一个 $2*1$ 的小矩形，剩下即为 $2*(n-2)$个大矩形

因此 $f(n) = f(n-1) + f(n-2)$

**注意：同样的此处的 $f(1) = 1，f(2) = 2$， 而10_01中的 $f(2) = 1$，因此需要调整边界**

时间复杂度：此处采用解法2，为O(n)

#### 代码
```java
public class RectCover
{
    /**
     * 矩形覆盖的方法数
     *
     * @param target 被覆盖矩形的大小为 2*target
     * @return 覆盖方法数
     */
    public int rectCover(int target)
    {
        if (target < 3)
        {
            return target;
        }

        int prePre = 1, pre = 2, cur = prePre + pre;

        for (int i = 3; i <= target; i++)
        {
            cur = prePre + pre;
            prePre = pre;
            pre = cur;
        }
        return cur;
    }
}
```



### 测试用例参考
1. 功能测试（如输入 3、5、10 等）；
2. 边界值测试（如输入 0、1、2）；
3. 性能测试（输入较大的数字，如 40、50、100 等）。
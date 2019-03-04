[TOC]

## 跳台阶

### 题目描述
一只青蛙一次可以跳上1级台阶，也可以跳上2级。
求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。

### 解法
经过分析可知，n级台阶的跳法数 $f(n) = f(n-1) + f(n-2)$，即为斐波那契数列，因此解法与10_01中相同

**注意：此处的 $f(1) = 1，f(2) = 2$， 而10_01中的 $f(2) = 1$，因此需要调整边界**

时间复杂度：此处采用解法2，为O(n)

#### 代码
```java
public class JumpFloor
{
    /**
     * 跳台阶的跳法数
     *
     * @param target 台阶的级数
     * @return 跳法数
     */
    public int jumpFloor(int target)
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
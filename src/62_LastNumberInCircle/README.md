[TOC]

## 圆圈中最后剩下的数字

0，1，……n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第 m个数字
求出这个圆圈里剩下的最后一个数字（约瑟夫环问题）

### 解法

#### 解法1
+ 利用链表模拟过程，利用取模执行环操作

#### 代码
```java
import java.util.LinkedList;

public class LastNumberInCircle
{
    /**
     * 链表模拟过程
     *
     * @param n n个数
     * @param m 每次删除第m个
     * @return 最后结果
     */
    public int lastRemainingWithList(int n, int m)
    {
        if (n == 0 || m == 0)
        {
            return -1;
        }

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++)
        {
            list.add(i);
        }

        int next = 0;
        while (list.size() > 1)
        {
            next = (next + m - 1) % list.size();
            list.remove(next);
        }
        return list.get(0);
    }
}
```



#### 解法2
+ 利用数学推导公式：
```
f(n,m) = 0							n = 1
f(n,m) = [ f(n-1,m) + m ] % n		n ≥ 1
```
其中 `f(n,m)` 表示在 n 个数字中每次删除第 m 个所剩下来的最后数字

#### 代码
```java
public class LastNumberInCircle
{
    /**
     * 利用公式
     *
     * @param n n个数
     * @param m 每次删除第m个
     * @return 最后结果
     */
    public int lastRemainingWithFormula(int n, int m)
    {
        if (n == 0 || m == 0)
        {
            return -1;
        }

        int result = 0;

        for (int i = 2; i <= n; i++)
        {
            result = (result + m) % i;
        }
        return result;
    }
}
```


### 测试用例参考
1. 功能测试（输入的m小于n；输入的m大于或者等于n）；
2. 特殊输入测试（圆圈中有0个数字）；
3. 性能测试（从最初有4000个数字的圆圈中每次删除第997个数字）
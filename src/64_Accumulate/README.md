[TOC]

## 求1+2+……+n

求1+2+……+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）

### 解法
+ 利用**逻辑与短路**：
  1. 当 n 不为0，递归从后向前进行计算；
  2. 当 n 减为0，因为前者为 false，直接跳过后续计算返回结果


#### 代码
```java
public class Accumulate
{
    /**
     * 求1+2+……+n
     *
     * @param n 数字n
     * @return 计算结果
     */
    public int sum(int n)
    {
        int result = n;

        // 利用逻辑与短路，当n减到0，前者为false，直接跳过后续判断
        boolean flag = (result > 0) && ((result += sum(n - 1)) > 0);
        return result;
    }
}
```



### 测试用例参考
1. 功能测试（输入5、10）；
2. 边界值测试（输入0和1）
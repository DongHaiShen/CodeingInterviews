[TOC]

## 扑克牌的顺子

从扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
2～10 为数字本身，A 为 1，J 为 11，Q 为 12，K 为 13，大小王可以看做任意数字。
为了方便，大小王均以 0 来表示，并且假设这副牌中大小王均有两张。

### 解法
+ 关键点在于如何使用大小王，即0，具体步骤如下：
  1. 首先对数组进行排序，统计出0的个数；
  2. 然后计算后面数字的**总空缺值**，在计算过程中若发现重复值可直接返回 false；
  3. 最后观察 **0 的个数能否填补总空缺值**，若能则返回 true；


#### 代码
```java
import java.util.Arrays;

public class ContinousCards
{
    /**
     * @param numbers
     * @return
     */
    public boolean isContinuous(int[] numbers)
    {
        if (numbers == null || numbers.length == 0)
        {
            return false;
        }

        // 先排序
        Arrays.sort(numbers);

        // 统计0的个数
        int zeroCount = 0;
        for (int e : numbers)
        {
            if (e == 0)
            {
                zeroCount++;
            }
        }

        // 王最多只有4张
        if (zeroCount > 4)
        {
            return false;
        }

        // 统计总空缺值
        int gap = 0;
        for (int i = zeroCount; i < numbers.length - 1; i++)
        {
            if (numbers[i] == numbers[i + 1])
            {
                return false;
            }
            gap += numbers[i + 1] - numbers[i] - 1;
        }

        // 0的个数是否足以填补空缺值
        return zeroCount >= gap;
    }
}
```



### 测试用例参考
1. 功能测试（抽出的牌中有一个或者多个大、小王；抽出的牌中没有大、小王；抽出的牌中有对子）；
2. 特殊输入测试（输入空指针）。
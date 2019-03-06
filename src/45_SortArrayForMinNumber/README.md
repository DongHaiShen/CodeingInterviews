[TOC]

## 把数组排成最小的数

输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
例如输入数组 [3, 32, 321]，则打印出这3个数字能排成的最小数字321323。

### 解法
+ 直观的想法是对数据进行全排列，然后找到最小的，但是复杂度高，且很可能排列组合后的数已经超出 int 范围；
+ 因此需要先把数字转成字符串，然后自定义排序规则，这里显然就是按顺序比较数字大小即可，最后进行排序，可以调用已有的一些库函数

#### 代码
```java
import java.util.Arrays;

public class SortArrayForMinNumber
{
    /**
     * 数组元素组成的最小的数字
     *
     * @param numbers 数组元素
     * @return 最小的数字
     */
    public String printMinNumber(int[] numbers)
    {
        // 把数字转成字符串，因为数字组合可能超出int范围
        int n = numbers.length;
        String[] strNums = new String[n];
        for (int i = 0; i < n; ++i)
        {
            strNums[i] = String.valueOf(numbers[i]);
        }

        // 调用现成sort方法，自定义比较规则
        Arrays.sort(strNums, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));

        // 得到结果
        StringBuilder sb = new StringBuilder();
        for (String str : strNums)
        {
            sb.append(str);
        }
        return sb.toString();
    }
}
```



### 测试用例参考
1. 功能测试（输入的数组中有多个数字；输入的数组中的数字有重复的数位；输入的数组中只有一个数字）；
2. 特殊输入测试（表示数组的指针为空指针）。
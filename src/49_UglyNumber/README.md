[TOC]

## 丑数

把只包含质因子2、3和5的数称作丑数（Ugly Number）。
例如6、8都是丑数，但14不是，因为它包含质因子7。
习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。

### 解法
+ 根据丑数的定义，除1以外，一个丑数应当是另一个丑数乘以2、3或5；
+ 因此可以考虑根据已有的丑数直接计算出新丑数，避免对大量非丑数进行依次判断；
+ 通过维护三个下标，保证每次得到的都是最新且最小的丑数


#### 代码
```java
import java.util.ArrayList;

public class UglyNumber
{
    /**
     * 获取第index个丑数
     *
     * @param index 第index个丑数
     * @return 对应丑数
     */
    public int getUglyNumber(int index)
    {
        if (index < 1)
        {
            return 0;
        }

        ArrayList<Integer> arrayList = new ArrayList<>();

        // 第一个丑数是1
        arrayList.add(1);

        // 利用三个下标维护三个对应值，每次加入最小的那个，保证数组有序
        int index2 = 0, index3 = 0, index5 = 0;
        int n2, n3, n5, min;
        while (arrayList.size() < index)
        {
            n2 = arrayList.get(index2) * 2;
            n3 = arrayList.get(index3) * 3;
            n5 = arrayList.get(index5) * 5;

            min = Math.min(n2, Math.min(n3, n5));
            arrayList.add(min);

            if (min == n2) index2++;
            if (min == n3) index3++;
            if (min == n5) index5++;
        }
        return arrayList.get(arrayList.size() - 1);
    }
}
```



### 测试用例参考
1. 功能测试（输入2、3、4、5、6等）。
2. 特殊输入测试（边界值1；无效输入0）。
3. 性能测试（输入较大的数字，比如1500）。
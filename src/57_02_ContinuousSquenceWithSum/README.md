[TOC]

## 和为S的连续正数序列

输入一个正数 s，打印出所有和为 s 的**连续正数序列**（至少含有两个数）。
例如输入 15，由于 1+2+3+4+5=4+5+6=7+8=15，所以结果打印出 3 个连续序列 1～5、4～6 和 7～8。

### 解法
+ 同样利用前后两个指针，第一个初始化为1，第二个初始化为2（连续正数序列）；
+ 若当前序列和小于目标值，则按顺序再加入一个新值，并更新前指针；
+ 若当前序列和大于目标值，则剔除最小的一个值，并更新后指针


#### 代码
```java
import java.util.ArrayList;

public class ContinuousSquenceWithSum
{
    /**
     * 输出所有和为sum的连续正数序列
     *
     * @param sum 数字和
     * @return 所有和为sum的连续正数序列
     */
    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (sum < 3)
        {
            return result;
        }

        int left = 1, right = 2, middle = (sum + 1) >> 1, curSum = left + right;
        while (left < middle)
        {
            if (curSum == sum)
            {
                result.add(addNewList(left, right));
                right++;
                curSum += right;
            }

            // 当前序列和过大，就把最左边一个数剔除
            else if (curSum > sum)
            {
                curSum -= left;
                left++;
            }

            // 否则加入最右边的下一个数
            else
            {
                right++;
                curSum += right;
            }
        }
        return result;
    }

    /**
     * 生成一个满足要求的序列
     *
     * @param sum 数字和
     * @return 满足要求的序列
     */
    public ArrayList<Integer> addNewList(int left, int right)
    {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = left; i <= right; i++)
        {
            arrayList.add(i);
        }
        return arrayList;
    }
}
```



### 测试用例参考
1. 功能测试（存在和为 s 的连续序列，如 9、100 等；不存在和为 s 的连续序列，如 4、0 等）；
2. 边界值测试（连续序列的最小和 3）。
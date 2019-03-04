import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author sdh
 * @Date Created in 2019/3/4 15:21
 * @description
 */

/**
 * 【题目】 获取数组中最小的k个数
 * <p>
 * 输入 n 个整数，找出其中最小的 K 个数。例如输入 4,5,1,6,2,7,3,8 这 8 个数字，则最小的 4 个数字是 1,2,3,4。
 */
public class KLeastNumbersWithHeap
{
    /**
     * 获取数组中最小的k个数
     *
     * @param input 输入的数组
     * @param k     最小元素个数
     * @return 最小的k个数
     */
    public ArrayList<Integer> getLeastNumbers(int[] input, int k)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || input.length == 0 || input.length < k || k < 1)
        {
            return result;
        }

        // 大根堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int n : input)
        {
            if (maxHeap.size() < k)
            {
                maxHeap.add(n);
            }
            else
            {
                if (maxHeap.peek() > k)
                {
                    maxHeap.poll();
                    maxHeap.add(n);
                }
            }
        }

        result.addAll(maxHeap);
        return result;
    }
}

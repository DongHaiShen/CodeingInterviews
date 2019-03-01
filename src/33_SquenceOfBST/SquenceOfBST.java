/**
 * @Author sdh
 * @Date Created in 2019/3/1 9:59
 * @description
 */

/**
 * 【题目】 二叉搜索树的后序遍历序列
 * <p>
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 */
public class SquenceOfBST
{
    /**
     * 判断数组是否是某个二叉搜索树的后序遍历序列
     *
     * @param sequence 数组
     * @return 判断结果
     */
    public boolean verifySequenceOfBST(int[] sequence)
    {
        if (sequence == null || sequence.length <= 0)
        {
            return false;
        }

        return verifySequenceOfBSTCore(sequence, 0, sequence.length - 1);
    }

    /**
     * 递归判断
     *
     * @param sequence 数组
     * @param start    起始位置
     * @param end      结束位置
     * @return 判断结果
     */
    public boolean verifySequenceOfBSTCore(int[] sequence, int start, int end)
    {
        if (start >= end)
        {
            return true;
        }

        // 后序遍历中最后一个值为根节点
        int root = sequence[end], index = start;

        // 从左向右找第一个大于根结点的值的位置
        // 即从start到index-1为左子树
        while (index < end && sequence[index] < root)
        {
            index++;
        }

        // 从index到end-1应为右子树
        // 即若之后还有小于根节点的值，则违背BST的定义
        while (index < end)
        {
            if (sequence[index] < root)
            {
                return false;
            }
            index++;
        }

        return verifySequenceOfBSTCore(sequence, start, index - 1) && verifySequenceOfBSTCore(sequence, index, end - 1);
    }
}

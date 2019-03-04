[TOC]

## 二叉搜索树的后序遍历序列

输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
假设输入的数组的任意两个数字都互不相同。

### 解法
+ 在后序遍历序列中，最后一个元素为根节点；
+ 先在序列中从左向右找第一个大于根结点的值的位置 $index$，根据BST的性质，从 $start$ 到 $index - 1$ 实际为左子树；
+ 同理从 $index$ 到 $end - 1$ 实际为右子树，应当都大于根节点，即若之后还有小于根节点的值，则违背BST的定义；
+ 递归判断左右子树

**注意：若要求处理二叉树的遍历序列，可以先找到其根节点，然后把序列拆分为左右子树，再递归进行**

#### 代码
```java
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
```



### 测试用例参考
1. 功能测试（输入的后序遍历序列对应一棵二叉树，包括完全二叉树、所有节点都没有左/右子树的二叉树、只有一个节点的二叉树；输入的后续遍历序列没有对应一棵二叉树）；
2. 特殊输入测试（后序遍历序列为空指针）。



### 相关题目
1. 输入一个整数数组，判断该数组是不是某二叉搜索树的**前序**遍历的结果
+ 与后序遍历相似，只是在前序遍历中，**第一个元素为根节点**

import java.util.ArrayList;

/**
 * @Author sdh
 * @Date Created in 2019/3/1 11:33
 * @description
 */

/**
 * 【题目】 二叉树中和为某一值的路径
 * <p>
 * 输入一棵二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class PathInTree
{
    public ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    /**
     * 找出二叉树中和为某一值的路径
     * 必须从根节点到叶节点
     *
     * @param root   二叉树的根结点
     * @param target 目标值
     * @return 全部结果list
     */
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target)
    {
        result.clear();
        findPathCore(root, target, 0, new ArrayList<>());
        return result;
    }

    /**
     * 递归查找
     *
     * @param root      二叉树的根结点
     * @param target    目标值
     * @param curSum    目前累计值
     * @param arrayList 单条结果list
     */
    public void findPathCore(TreeNode root, int target, int curSum, ArrayList<Integer> arrayList)
    {
        if (root == null)
        {
            return;
        }

        curSum += root.val;
        arrayList.add(root.val);

        // 若累计值达到目标值，且当前节点为叶节点则保存
        if (curSum == target && root.left == null && root.right == null)
        {
            result.add(new ArrayList<>(arrayList));
        }

        // 否则递归执行
        else
        {
            findPathCore(root.left, target, curSum, arrayList);
            findPathCore(root.right, target, curSum, arrayList);
        }

        // 回到上一个节点
        arrayList.remove(arrayList.size() - 1);
    }
}

[TOC]

## 二叉树中和为某一值的路径

输入一棵二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)

### 解法
+ 从根节点出发，把值依次进行累加；
+ 若累加值等于目标值，且当前节点恰好为叶节点（**由于路径要求必须要到叶节点**），则打印；
+ 否则递归处理左右节点；
+ **需要注意在回溯至父节点时，需要把先路径上的该节点删除**


#### 代码
```java
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
```



### 测试用例参考
1. 功能测试（二叉树中有一条、多条符合要求的路径；二叉树中没有符合要求的路径）；
2. 特殊输入测试（指向二叉树根节点的指针为空指针）。


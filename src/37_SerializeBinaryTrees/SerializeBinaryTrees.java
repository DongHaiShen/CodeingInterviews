/**
 * @Author sdh
 * @Date Created in 2019/3/3 15:54
 * @description
 */

/**
 * 【题目】 序列化二叉树
 * <p>
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 */
public class SerializeBinaryTrees
{
    // 标识空指针
    public String SIG_OF_NULL = "#";

    // 分隔符
    public String SEPARATOR = ",";

    /**
     * 序列化
     *
     * @param root 根节点
     * @return 序列化字符串
     */
    public String serialize(TreeNode root)
    {
        StringBuilder result = new StringBuilder();
        if (root == null)
        {
            return result.toString();
        }

        serializeHelper(root, result);

        // 移除最后一个分隔符
        result.deleteCharAt(result.lastIndexOf(SEPARATOR));
        return result.toString();
    }

    /**
     * 利用前序遍历
     *
     * @param root   根节点
     * @param result 结果
     */
    public void serializeHelper(TreeNode root, StringBuilder result)
    {
        if (root == null)
        {
            result.append(SIG_OF_NULL);
            result.append(SEPARATOR);
            return;
        }

        result.append(root.val);
        result.append(SEPARATOR);
        serializeHelper(root.left, result);
        serializeHelper(root.right, result);
    }

    // 反序列化索引标记
    public int INDEX = -1;

    /**
     * 反序列化
     *
     * @param str 字符串
     * @return 反序列化后的根节点
     */
    public TreeNode deserialize(String str)
    {
        if (str == null || str.length() == 0)
        {
            return null;
        }

        String[] treeNodeStr = str.split(SEPARATOR);
        return deserializeHelper(treeNodeStr);
    }

    /**
     * 从前序遍历中反序列化
     *
     * @param treeNodeStr 字符串
     * @return 反序列化后根节点
     */
    public TreeNode deserializeHelper(String[] treeNodeStr)
    {
        INDEX++;
        TreeNode node = null;

        // index不越界并且当前节点不为空指针
        if (INDEX < treeNodeStr.length && !"#".equals(treeNodeStr[INDEX]))
        {
            node = new TreeNode(Integer.valueOf(treeNodeStr[INDEX]));
            node.left = deserializeHelper(treeNodeStr);
            node.right = deserializeHelper(treeNodeStr);
        }
        return node;
    }
}

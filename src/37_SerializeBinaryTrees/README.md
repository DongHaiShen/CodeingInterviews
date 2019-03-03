[TOC]

## 序列化二叉树

请实现两个函数，分别用来序列化和反序列化二叉树。

### 解法
+ 题目只要求可以实现序列化和反序列化即可，因此具体格式可自己设定。这里使用**前序遍历**来实现，空指针用 `#` 标记，分隔符用 `,` 标记；
+ 序列化过程即为标准的前序遍历，注意空指针要特殊处理；
+ 反序列化过程同理，逐个处理字符串的每个值，其中第一个值为根，然后递归处理左右节点，遇到空指针标记直接返回 `null`


#### 代码
```java
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
```



### 测试用例参考
1. 功能测试（输入的二叉树是完全二叉树；所有节点都没有左/右子树的二叉树；只有一个节点的二叉树；所有节点的值都相同的二叉树）；
2. 特殊输入测试（指向二叉树根结点的指针为空指针）。

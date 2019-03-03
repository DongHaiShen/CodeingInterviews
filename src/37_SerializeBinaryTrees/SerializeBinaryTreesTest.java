/**
 * @Author sdh
 * @Date Created in 2019/3/3 15:54
 * @description
 */
public class SerializeBinaryTreesTest
{
    public static void main(String[] args)
    {
        SerializeBinaryTrees test = new SerializeBinaryTrees();
        test01(test);
    }

    private static void test01(SerializeBinaryTrees test)
    {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n4.right = n9;

        String result = test.serialize(n1);
        System.out.println(result);
        System.out.println();

        TreeNode root = test.deserialize(result);
        print(root);

    }

    private static void print(TreeNode root)
    {
        if (root != null)
        {
            print(root.left);
            System.out.printf("%-3d", root.val);
            print(root.right);
        }
    }
}

/**
 * @Author sdh
 * @Date Created in 2019/2/20 19:38
 * @description
 */
public class TreeLinkNode
{
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;

    // next指向的是该节点的父节点
    TreeLinkNode next = null;

    public TreeLinkNode() {}

    public TreeLinkNode(int val)
    {
        this.val = val;
    }
}

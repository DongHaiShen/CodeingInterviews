import java.util.LinkedList;
import java.util.List;

/**
 * @Author sdh
 * @Date Created in 2019/3/7 10:36
 * @description
 */
public class CommonTreeNode
{
    int val;
    List<CommonTreeNode> children = new LinkedList<>();

    public CommonTreeNode()
    {
    }

    public CommonTreeNode(int val)
    {
        this.val = val;
    }
}

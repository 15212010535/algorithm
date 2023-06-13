package code.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 后序遍历
 */
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    private void postorder(TreeNode node, List<Integer> res) {
        if (node == null)
            return;
        postorder(node.left, res);
        postorder(node.right, res);
        res.add(node.val);
    }

}

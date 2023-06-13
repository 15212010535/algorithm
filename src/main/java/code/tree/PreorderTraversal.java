package code.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的前序遍历
 */
public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root,res);
        return res;
    }

    private void preorder(TreeNode node, List<Integer> res) {
        if(node ==null){
            return;
        }
        res.add(node.val);
        preorder(node.left,res);
        preorder(node.right,res);
    }
}

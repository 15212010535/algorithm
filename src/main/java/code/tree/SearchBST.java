package code.tree;

/**
 * 二叉搜索树中的搜索
 */
public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val)
            return root;
        TreeNode left = searchBST(root.left, val);
        if (left != null)
            return left;
        return searchBST(root.right, val);
    }
}

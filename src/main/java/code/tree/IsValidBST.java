package code.tree;

/**
 * 验证二叉搜索树
 */
public class IsValidBST {
    TreeNode max;

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }
        if (max != null && root.val <= max.val)
            return false;
        max = root;
        return isValidBST(root.right);
    }
}

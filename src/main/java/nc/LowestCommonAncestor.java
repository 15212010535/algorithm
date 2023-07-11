package nc;

/**
 * 在二叉树中找到两个节点的最近公共祖先
 */
public class LowestCommonAncestor {
    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        // write code here
        if (root == null) {
            return -1;
        }
        if (root.val == o1 || root.val == o2) {
            return root.val;
        }
        int left = lowestCommonAncestor(root.left, o1, o2);
        int right = lowestCommonAncestor(root.right, o1, o2);

        if (left == -1 && right == -1) {
            return -1;
        } else if (left == -1 && right != -1) {
            return right;
        } else if (left != -1 && right == -1) {
            return left;
        } else {
            return root.val;
        }
    }
}

package code.dp;

import code.tree.TreeNode;

/**
 * 打家劫舍 III
 */
public class Rob3 {
    public int rob3(TreeNode root) {
        int[] res = robAction(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robAction(TreeNode root) {
        // res[0]：不偷当前节点
        // res[1]：偷当前节点
        int[] res = new int[2];
        if (root == null)
            return res;
        int[] left = robAction(root.left);
        int[] right = robAction(root.right);
        // 不偷：左子树最大值 + 右子树最大值
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 偷：当前值 + 不偷左字数 + 不偷右子树
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}

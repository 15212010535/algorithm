package code.greedy;

import code.tree.TreeNode;

/**
 * 监控二叉树
 */
public class MinCameraCover {
    int res = 0;

    public int minCameraCover(TreeNode root) {
        if (minCame(root) == 0) {
            res++;
        }
        return res;
    }

    private int minCame(TreeNode root) {
        if (root == null)
            return 2;
        int left = minCame(root.left);
        int right = minCame(root.right);

        if (left == 2 && right == 2) {
            return 0;
        } else if (left == 0 || right == 0) {
            res++;
            return 1;
        } else {
            return 2;
        }
    }


}

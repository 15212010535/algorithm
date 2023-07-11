package nc;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 判断一棵树是否是搜索二叉树和完全二叉树
 */
public class JudgeIt {
    public boolean[] judgeIt(TreeNode root) {
        // write code here
        boolean[] res = new boolean[2];
        if (root == null) {
            res[0] = true;
            res[1] = true;
            return res;
        }
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        res[0] = isBST(root, min, max);
        res[1] = isCBT(root);
        return res;
    }

    private boolean isCBT(TreeNode root) {
        if (root == null)
            return true;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        boolean reachedNull = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode curr;
            while (size > 0) {
                curr = queue.pollFirst();
                if (curr.left == null) {
                    reachedNull = true;
                } else {
                    if (reachedNull) {
                        return false;
                    } else {
                        queue.offerLast(curr.left);
                    }
                }
                if (curr.right == null) {
                    reachedNull = true;
                } else {
                    if (reachedNull) {
                        return false;
                    } else {
                        queue.offerLast(curr.right);
                    }
                }

                size--;
            }
        }
        return reachedNull;
    }

    private boolean isBST(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max)
            return false;
        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }
}

package code.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最大深度
 */
public class MaxDepth {
    public int maxDepthOne(TreeNode root) {
        int max_depth = 0;
        if (root == null)
            return max_depth;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                size--;
            }
            max_depth++;
        }
        return max_depth;
    }

    public int maxDepthTwo(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepthTwo(root.right), maxDepthTwo(root.left)) + 1;
    }
}

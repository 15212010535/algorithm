package code.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 完全二叉树的节点个数
 */
public class CountNodes {
    public int countNodesOne(TreeNode root) {
        if (root == null)
            return 0;
        return countNodesOne(root.left) + countNodesOne(root.right) + 1;
    }

    public int countNodesTwo(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                count++;
                if (node.right != null)
                    queue.add(node.right);
                if (node.left != null)
                    queue.add(node.left);
            }
        }
        return count;
    }
}

package code.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 找树左下角的值
 */
public class FindBottomLeftValue {
    private int Deep = -1;
    private int value = 0;

    public int findBottomLeftValue(TreeNode root) {
        value = root.val;
        findLeftValue(root, 0);
        return value;
    }

    private void findLeftValue(TreeNode root, int depth) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            if (depth > Deep) {
                value = root.val;
                Deep = depth;
            }
        }
        if (root.left != null)
            findLeftValue(root.left, depth + 1);
        if (root.right != null)
            findLeftValue(root.right, depth + 1);
    }


    public int findBottomLeftValueTwo(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int cur = size;
            while (size > 0) {
                TreeNode node = queue.poll();
                if (cur == size) {
                    assert node != null;
                    res = node.val;
                }
                assert node != null;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                size--;
            }
        }
        return res;
    }

}

package code.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 翻转二叉树
 */
public class InvertTree {
    public TreeNode invertTreeOne(TreeNode root) {
        if (root == null)
            return root;
        invertTreeOne(root.left);
        invertTreeOne(root.right);
        swapChildren(root);
        return root;
    }

    public void swapChildren(TreeNode root) {
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
    }

    public TreeNode invertTreeTwo(TreeNode root) {
        if (root == null)
            return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                assert node != null;
                swap(node);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                size--;
            }
        }
        return root;
    }

    public void swap(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}

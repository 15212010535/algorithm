package code.tree;

import java.util.Stack;

/**
 *  路径总和
 */
public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public boolean hasPathSumTwo(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(root);
        stack2.push(root.val);
        while (!stack1.isEmpty()) {
            int size = stack1.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = stack1.pop();
                Integer sum = stack2.pop();
                if (node.left == null && node.right == null && sum == targetSum)
                    return true;
                if (node.right != null) {
                    stack1.push(node.right);
                    stack2.push(sum + node.right.val);
                }
                if (node.left != null) {
                    stack1.push(node.left);
                    stack2.push(sum + node.left.val);
                }
            }
        }
        return false;
    }
}

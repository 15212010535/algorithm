package code.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 平衡二叉树
 */
public class IsBalanced {
    public boolean isBalancedOne(TreeNode root) {
        return getHeight(root) != -1;
    }

    public int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1)
            return -1;
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1)
            return -1;
        if (Math.abs(rightHeight - leftHeight) > 1)
            return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalancedTwo(TreeNode root) {
        if(root == null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root!=null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            TreeNode inNode = stack.peek();
            if(inNode.right == null || inNode.right == pre){
                if(Math.abs(getHeightTwo(inNode.left) - getHeightTwo(inNode.right))>1)
                    return false;
                stack.pop();
                pre = inNode;
                root = null;
            }else {
                root = inNode.right;
            }
        }
        return true;
    }

    /**
     * 层序遍历，求结点的高度
     */
    public int getHeightTwo(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int depth = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if (poll.left != null) {
                    deque.offer(poll.left);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                }
            }
        }
        return depth;
    }
}

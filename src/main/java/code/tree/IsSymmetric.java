package code.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 对称二叉树
 */
public class IsSymmetric {

    public boolean isSymmetric1(TreeNode root) {
        return compare(root.left, root.right);
    }

    public boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right != null)
            return false;
        if (left != null && right == null)
            return false;
        if (left == null && right == null)
            return true;
        if (left.val != right.val)
            return false;
        boolean compareOutside = compare(left.left, right.right);
        boolean compareInside = compare(left.right, right.left);
        return compareOutside && compareInside;
    }


    public boolean isSymmetric2(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addFirst(root.left);
        deque.addLast(root.right);
        while (!deque.isEmpty()){
            TreeNode left = deque.pollFirst();
            TreeNode right = deque.pollLast();
            if(left == null && right == null)
                continue;
            if(left == null || right == null || left.val != right.val)
                return false;
            deque.addFirst(left.left);
            deque.addFirst(left.right);
            deque.addLast(right.right);
            deque.addLast(right.left);
        }
        return true;
    }
}

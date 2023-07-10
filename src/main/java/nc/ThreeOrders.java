package nc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 实现二叉树先序，中序和后序遍历
 */
public class ThreeOrders {
    public int[][] threeOrders(TreeNode root) {
        // write code here
        List<Integer> path = new ArrayList<>();
        int[][] res = new int[3][];
        preOrder(root, path);
        res[0] = path.stream().mapToInt(Integer::valueOf).toArray();
        path.clear();
        inOrder(root, path);
        res[1] = path.stream().mapToInt(Integer::valueOf).toArray();
        path.clear();
        postOrder(root, path);
        res[2] = path.stream().mapToInt(Integer::valueOf).toArray();
        path.clear();
        return res;
    }

    private void postOrder(TreeNode root, List<Integer> path) {
        if (root == null)
            return;
        postOrder(root.left, path);
        postOrder(root.right, path);
        path.add(root.val);
    }

    private void inOrder(TreeNode root, List<Integer> path) {
        if (root == null)
            return;
        inOrder(root.left, path);
        path.add(root.val);
        inOrder(root.right, path);
    }

    private void preOrder(TreeNode root, List<Integer> path) {
        if (root == null)
            return;
        path.add(root.val);
        preOrder(root.left, path);
        preOrder(root.right, path);
    }

}

package code.tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        List<Integer> path = new ArrayList<>();
        preOrderDfs(root, targetSum, path, res);
        return res;
    }

    public void preOrderDfs(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> res) {
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (targetSum - root.val == 0)
                res.add(new ArrayList<>(path));
            return;
        }
        if (root.left != null) {
            preOrderDfs(root.left, targetSum - root.val, path, res);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            preOrderDfs(root.right, targetSum - root.val, path, res);
            path.remove(path.size() - 1);
        }
    }
}

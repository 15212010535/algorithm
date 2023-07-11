package nc;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中和为某一值的路径(二)
 */
public class FindPath {
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        List<Integer> path = new ArrayList<>();
        findPathHelper(root, path, res, target);
        return res;
    }

    private void findPathHelper(TreeNode root, List<Integer> path, ArrayList<ArrayList<Integer>> res, int target) {
        path.add(root.val);
        if (root.left == null && root.right == null) {
            Integer reduce = path.stream().reduce(0, Integer::sum);
            if (reduce == target) {
                res.add(new ArrayList<>(path));
            }
        }
        if (root.left != null) {
            findPathHelper(root.left, path, res, target);
            if (path.size() == 0)
                return;
            else path.remove(path.size() - 1);
        }
        if (root.right != null) {
            findPathHelper(root.right, path, res, target);
            if (path.size() == 0)
                return;
            else path.remove(path.size() - 1);
        }
    }
}

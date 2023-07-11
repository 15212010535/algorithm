package nc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 二叉树根节点到叶子节点的所有路径和
 */
public class SumNumbers {

    List<String> res;

    public int sumNumbers(TreeNode root) {
        // write code here
        if (root == null)
            return 0;
        res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        travels(root, path);
        List<Integer> collect = res.stream().map(Integer::valueOf).collect(Collectors.toList());
        int sum = 0;
        for (Integer integer : collect) {
            sum += integer;
        }
        return sum;
    }

    private void travels(TreeNode root, StringBuilder path) {
        path.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(path.toString());
            return;
        }
        if (root.left != null) {
            travels(root.left, path);
            if (path.length() == 0)
                return;
            else
                path.deleteCharAt(path.length() - 1);
        }
        if (root.right != null) {
            travels(root.right, path);
            if (path.length() == 0)
                return;
            else
                path.deleteCharAt(path.length() - 1);
        }
    }
}

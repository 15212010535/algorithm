package code.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层次遍历
 */
public class LevelOrder {
    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
//        checkFun01(root, 0);
        checkFun02(root);
        return res;
    }

    private void checkFun02(TreeNode node) {
        if (node == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int len = queue.size();
            while (len > 0) {
                TreeNode tmpNode = queue.poll();
                list.add(tmpNode.val);
                if (tmpNode.left != null)
                    queue.offer(tmpNode.left);
                if (tmpNode.right != null)
                    queue.offer(tmpNode.right);
                len--;
            }
            res.add(list);
        }
    }

    private void checkFun01(TreeNode node, Integer deep) {
        if (node == null)
            return;
        deep++;
        if (res.size() < deep) {
            List<Integer> item = new ArrayList<>();
            res.add(item);
        }
        res.get(deep - 1).add(node.val);
        checkFun01(node.left, deep);
        checkFun01(node.right, deep);
    }
}

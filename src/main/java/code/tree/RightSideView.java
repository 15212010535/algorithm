package code.tree;

import java.util.*;

/**
 * 二叉树的右视图
 */
public class RightSideView {
    public List<Integer> rightSideViewOne(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            int size = queue.size();
            int cur = size;
            while (size > 0) {
                TreeNode node = queue.poll();
                if (cur == size) {
                    res.add(node.val);
                }
                if (node.right != null)
                    queue.add(node.right);
                if (node.left != null)
                    queue.add(node.left);
                size--;
            }
        }
        return res;
    }

    public List<Integer> rightSideViewTwo(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        int max_deep = -1;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> deepQueue = new LinkedList<>();
        nodeQueue.add(root);
        deepQueue.add(0);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            Integer deep = deepQueue.poll();
            if (node != null) {
                max_deep = Math.max(max_deep, deep);
                map.put(deep, node.val);
                nodeQueue.add(node.left);
                nodeQueue.add(node.right);
                deepQueue.add(deep + 1);
                deepQueue.add(deep + 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= max_deep; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}

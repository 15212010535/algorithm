package nc;

import java.util.*;

/**
 * 按之字形顺序打印二叉树
 */
public class Print {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        // write code here
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        queue.add(pRoot);
        boolean flag = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> temp = new LinkedList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (flag) {
                    temp.addFirst(node.val);
                } else {
                    temp.addLast(node.val);
                }
                size--;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            flag = !flag;
            res.add(new ArrayList<>(temp));
        }
        return res;
    }
}

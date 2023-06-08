package base;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的锯齿形层序遍历
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            if (!s1.isEmpty()) {
                while (!s1.isEmpty()) {
                    TreeNode node = s1.pop();
                    list.add(node.val);
                    if (node.left != null)
                        s2.push(node.left);
                    if (node.right != null)
                        s2.push(node.right);
                }
            } else {
                while (!s2.isEmpty()) {
                    TreeNode node = s2.pop();
                    list.add(node.val);
                    if (node.right != null)
                        s1.push(node.right);
                    if (node.left != null)
                        s1.push(node.left);
                }
            }
            res.add(list);
        }
        return res;
    }
}

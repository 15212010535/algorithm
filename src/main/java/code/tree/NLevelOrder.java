package code.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

/**
 * N叉树的层序遍历
 */
public class NLevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tempList = new ArrayList<>();
            while (size > 0) {
                Node node = queue.poll();
                tempList.add(node.val);
                if (node.children != null) {
                    List<Node> children = node.children;
                    queue.addAll(children);
                }
                size--;
            }
            res.add(tempList);
        }
        return res;
    }
}

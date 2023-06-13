package code.tree;

import java.util.LinkedList;
import java.util.Queue;

class ConnectNode {
    public int val;
    public ConnectNode left;
    public ConnectNode right;
    public ConnectNode next;

    public ConnectNode() {
    }

    public ConnectNode(int _val) {
        val = _val;
    }

    public ConnectNode(int _val, ConnectNode _left, ConnectNode _right, ConnectNode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

/**
 * 填充每个节点的下一个右侧节点指针
 */
public class Connect {
    public ConnectNode connect(ConnectNode root) {
        if (root == null) {
            return root;
        }
        Queue<ConnectNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                ConnectNode node = queue.poll();
                if(size - 1>0) {
                    node.next = queue.peek();
                }
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                size--;
            }
        }
        return root;
    }
}

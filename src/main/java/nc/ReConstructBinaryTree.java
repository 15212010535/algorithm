package nc;

import java.util.HashMap;
import java.util.Map;

/**
 * 重建二叉树, 前序和中序
 */
public class ReConstructBinaryTree {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode reConstructBinaryTree(int[] preOrder, int[] vinOrder) {
        // write code here
        for (int i = 0; i < vinOrder.length; i++) {
            map.put(vinOrder[i], i);
        }
        return findNode(preOrder, 0, preOrder.length, vinOrder, 0, vinOrder.length);
    }

    private TreeNode findNode(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
        if (preStart >= preOrder.length || inStart > inEnd)
            return null;
        // 找到前序遍历第一个元素在中序遍历中的位置
        Integer rootIndex = map.get(preOrder[preStart]);
        TreeNode root = new TreeNode(inOrder[rootIndex]);
        int lenOfLeft = rootIndex - inStart;
        // 排除已经创建的节点
        root.left = findNode(preOrder, preStart+1, preStart + lenOfLeft, inOrder, inStart, rootIndex-1);
        root.right = findNode(preOrder, preStart + lenOfLeft + 1, preEnd, inOrder, rootIndex+1, inEnd);
        return root;
    }
}

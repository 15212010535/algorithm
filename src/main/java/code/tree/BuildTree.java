package code.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 从中序和后序遍历序列构造二叉树。
 */
public class BuildTree {
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return findNode(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    private TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        if (inBegin >= inEnd || postBegin >= postEnd)
            return null;
        int rootIndex = map.get(postorder[postEnd - 1]);
        TreeNode treeNode = new TreeNode(inorder[rootIndex]);
        int lenOfLeft = rootIndex - inBegin;
        treeNode.left = findNode(inorder, inBegin, rootIndex, postorder, postBegin, postBegin + lenOfLeft);
        treeNode.right = findNode(inorder, rootIndex + 1, inEnd, postorder, postBegin + lenOfLeft, postEnd - 1);
        return treeNode;
    }
}

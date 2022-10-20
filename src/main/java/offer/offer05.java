package offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 重建二叉树
 */
public class offer05 {

    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            // 返回栈顶元素但不移除它
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }


    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
//        int[] preorder = {1,2,3};
//        int[] inorder = {3,2,1};

        TreeNode node = buildTree(preorder, inorder);
        List<Integer> integers = InorderTraversal.inorderTraversal(node);
        integers.forEach(System.out::println);
    }
}

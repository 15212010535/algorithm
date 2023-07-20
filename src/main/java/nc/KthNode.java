package nc;

/**
 * 二叉搜索数的第K个节点
 */
public class KthNode {
    int res = -1;
    int cur = 0;

    public int kthNode(TreeNode proot, int k) {
        // write code here
        inorder(proot, k);
        return res;
    }

    public void inorder(TreeNode root, int k) {
        if (root == null || res != -1) {
            return;
        }
        inorder(root.left, k);
        cur++;
        if (cur == k) {
            res = root.val;
        }
        inorder(root.right, k);
    }
}

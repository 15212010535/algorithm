package 树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InorderTraversal {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public static void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    System.out.println(i);
                    System.out.println(j);
                    return res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 4};
        int[] ints = twoSum(arr, 6);
        Arrays.stream(ints).forEach(System.out::println);
    }
}

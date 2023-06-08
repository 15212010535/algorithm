package base;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 全排序
 *  给定一个不含重复数字的数组nums，返回其所有可能的全排列。
 */
public class Permute {

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] flag = new boolean[nums.length];
        ArrayDeque<Integer> path = new ArrayDeque<>();
        permuteHelper(nums, flag, path);
        return ans;
    }

    private void permuteHelper(int[] nums, boolean[] flag, ArrayDeque<Integer> path) {
        if (nums.length == path.size()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flag[i])
                continue;
            path.addLast(nums[i]);
            flag[i] = true;
            permuteHelper(nums, flag, path);
            path.removeLast();
            flag[i] = false;
        }
    }
}

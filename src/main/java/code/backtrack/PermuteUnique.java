package code.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列 II
 */
public class PermuteUnique {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        Arrays.fill(used, false);
        backTrack(nums, used);
        return result;
    }

    public void backTrack(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                backTrack(nums, used);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}

package base;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列：
 * 数组中存在重复元素，同一层不能存在同样元素
 */
public class permuteUnique {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0)
            return ans;
        ArrayDeque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dps(nums, used, path);
        return ans;
    }

    private void dps(int[] nums, boolean[] used, ArrayDeque<Integer> path) {
        if (nums.length == path.size()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            // 同一层不能存在相同的元素,且前一个元素没有被使用过，如果使用过，则表明当前元素则为前一个元素的下一个元素，
            // 则此元素如果使用上一个元素作为下一个元素，则重复，剪枝掉。
            if ((i > 0 && nums[i] == nums[i - 1]) && !used[i - 1])
                continue;
            path.addLast(nums[i]);
            used[i] = true;
            dps(nums, used, path);
            path.removeLast();
            used[i] = false;
        }
    }
}

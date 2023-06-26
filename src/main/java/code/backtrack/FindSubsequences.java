package code.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 递增子序列
 */
public class FindSubsequences {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums, 0);
        return result;
    }

    public void backTracking(int[] nums, int startIndex) {
        if (path.size() >= 2) {
            result.add(new ArrayList<>(path));
        }
        HashSet<Integer> hs = new HashSet<>();
        for (int j = startIndex; j < nums.length; j++) {
            if (!path.isEmpty() && path.get(path.size() - 1) > nums[j] || hs.contains(nums[j]))
                continue;
            hs.add(nums[j]);
            path.add(nums[j]);
            backTracking(nums, j + 1);
            path.remove(path.size() - 1);
        }
    }
}

package code.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 */
public class Permute {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0)
            return result;
        backtrack(nums, path);
        return result;
    }

    public void backtrack(int[] nums, LinkedList<Integer> path) {
        if (path.size() == nums.length)
            result.add(new ArrayList<>(path));
        for (int num : nums) {
            if (path.contains(num))
                continue;
            path.add(num);
            backtrack(nums, path);
            path.removeLast();
        }
    }
}

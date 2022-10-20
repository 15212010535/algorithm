package 刷题;

import java.util.LinkedList;
import java.util.List;

/**
 * 决策树
 */
public class Permute {

    static List<List<Integer>> res = new LinkedList<>();

    static List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    static void backtrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
        }

        for (int num : nums) {
            // 排除不合法的选择
            if (track.contains(num))
                continue;
            // 做选择
            track.add(num);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(permute(nums));
    }
}

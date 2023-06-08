package base;

import java.util.*;

/**
 * 组合总数
 */
public class CombinationSum2 {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return ans;
        }
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        combinationSum2Help(candidates, target, 0, path);
        return ans;
    }

    private void combinationSum2Help(int[] arr, int target, int start, Deque<Integer> path) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
        }
        for (int i = start; i < arr.length; i++) {
            if (target < arr[i])
                return;
            if (i > start && arr[i] == arr[i - 1]) // 同一层不能重复
                continue;
            path.add(arr[i]);
            combinationSum2Help(arr, target - arr[i], i + 1, path);
            path.removeLast();
        }
    }

}

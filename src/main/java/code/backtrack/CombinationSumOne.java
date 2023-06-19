package code.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和
 */
public class CombinationSumOne {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        Arrays.sort(candidates);
        backtracking(result, path, candidates, target, 0, 0);
        return result;
    }

    public void backtracking(List<List<Integer>> result, LinkedList<Integer> path, int[] candidates, int target, int sum, int index) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] > target)
                break;
            path.add(candidates[i]);
            backtracking(result, path, candidates, target, sum + candidates[i], i);
            path.removeLast();
        }
    }
}

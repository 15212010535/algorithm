package code.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和 II
 */
public class CombinationSumTwo {

    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] used;
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        Arrays.fill(used,false);
        Arrays.sort(candidates);
        backtrack(candidates,target,0);
        return ans;
    }

    public void backtrack(int[] candidates, int target, int startIndex) {
        if(sum == target)
            ans.add(new ArrayList<>(path));

        for (int i = startIndex; i < candidates.length; i++) {
            if(sum + candidates[i] > target)
                break;
            if(i > 0  && candidates[i] == candidates[i-1] && !used[i-1])
                continue;
            used[i] = true;
            path.add(candidates[i]);
            sum+=candidates[i];
            backtrack(candidates,target,i+1);
            used[i] = false;
            path.removeLast();
            sum -= candidates[i];
        }
    }


}

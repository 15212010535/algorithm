package code.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和
 */
public class CombinationSum {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int k, int n) {
        backTracking(n, k, 1, 0);
        return result;
    }

    public void backTracking(int n, int k, int startIndex, int sum) {
        if (sum > n)
            return;
        if (path.size() == k) {
            if (sum == n)
                result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backTracking(n, k, i + 1, sum);
            path.removeLast();
            sum -= i;
        }
    }
}

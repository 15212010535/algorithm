package nc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 加起来和为目标值的组合(二)
 */
public class CombinationSum2 {

    ArrayList<ArrayList<Integer>> res =  new ArrayList<>();;
    boolean[] used;
    LinkedList<Integer> path = new LinkedList<>();
    int sum = 0;

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // write code here
        Arrays.sort(num);
        if (num.length == 0) {
            return res;
        }
        if (num[0] > target) {
            return res;
        }
        used = new boolean[num.length];
        combinationSumHelper(num, 0, target);
        return res;
    }

    public void combinationSumHelper(int[] num, int startIndex, int target) {
        if (target == sum) {
            res.add(new ArrayList<Integer>(path));
        }
        for (int i = startIndex; i < num.length; i++) {
            if (sum + num[i] > target)
                break;
            if (i > 0 && num[i] == num[i - 1] && !used[i - 1])
                continue;
            used[i] = true;
            path.add(num[i]);
            sum += num[i];
            combinationSumHelper(num, i + 1, target);
            sum -= num[i];
            used[i] = false;
            path.removeLast();
        }
    }
}

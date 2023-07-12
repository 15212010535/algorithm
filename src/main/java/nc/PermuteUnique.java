package nc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 有重复项数字的全排列
 */
public class PermuteUnique {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (num.length == 0)
            return res;
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[num.length];
        Arrays.sort(num);
        backTrack(num, used, path, res);
        return res;
    }

    private void backTrack(int[] num, boolean[] used, List<Integer> path, ArrayList<ArrayList<Integer>> res) {
        if (path.size() == num.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if ((i > 0 && num[i] == num[i - 1] && !used[i - 1]) || used[i])
                continue;
            path.add(num[i]);
            used[i] = true;
            backTrack(num, used, path, res);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}

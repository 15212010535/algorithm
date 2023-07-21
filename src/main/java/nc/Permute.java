package nc;

import java.util.ArrayList;

/**
 * 没有重复项数字的全排列
 */
public class Permute {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        if (num.length == 0)
            return res;
        boolean[] used = new boolean[num.length];
        permuteHelper(res, path, used, num);
        return res;
    }

    public void permuteHelper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path, boolean[] used, int[] num) {
        if (path.size() == num.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (used[i]){
                continue;
            }
            used[i] = true;
            path.add(num[i]);
            permuteHelper(res, path, used, num);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}

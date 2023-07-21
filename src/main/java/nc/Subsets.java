package nc;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 集合的所有子集(一)
 */
public class Subsets {

    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (S.length == 0) {
            return res;
        }
        ArrayList<Integer> path = new ArrayList<>();
        Arrays.sort(S);
        backtrac(res, path, 0, S);
        return res;
    }

    public void backtrac(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path, int start, int[] s) {
        res.add(new ArrayList<>(path));
        System.out.println(path);
        for (int i = start; i < s.length; i++) {
            path.add(s[i]);
            backtrac(res, path, i + 1, s);
            path.remove(path.size() - 1);
        }
    }
}

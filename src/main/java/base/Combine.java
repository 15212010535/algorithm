package base;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 组合
 */
public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (n <= 0 || k <= 0 || n < k)
            return ans;
        Stack<Integer> stack = new Stack<>();
        combineHelper(ans, stack, 1, n, k);
        return ans;
    }

    private void combineHelper(List<List<Integer>> ans, Stack<Integer> stack, int index, int n, int k) {
        if (stack.size() == k) {
            ans.add(new ArrayList<>(stack));
            return;
        }
        // k - stack.size()：剩下寻找的个数
        // n - i + 1：【i，n】区间
        // 区间大于剩下寻找的个数的长度。
        for (int i = index; i <= n - (k - stack.size()) + 1; i++) {
            stack.push(i);
            combineHelper(ans, stack, i + 1, n, k);
            stack.pop();
        }
    }
}

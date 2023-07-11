package nc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 输出二叉树的右视图
 */
public class RightView {
    Map<Integer, Integer> map;
    List<Integer> res;

    public int[] solve(int[] preOrder, int[] inOrder) {
        // write code here
        res = new ArrayList<>();
        map = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }
        buildTree(preOrder, 0, preOrder.length, inOrder, 0, inOrder.length, 0);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private void buildTree(int[] preOrder, int preBegin, int preEnd, int[] inOrder, int inBegin, int inEnd, int deep) {
        if (preBegin >= preOrder.length || inBegin > inEnd) {
            return;
        }
        if (deep == res.size()) {
            res.add(preOrder[preBegin]);
        } else {
            res.set(deep, preOrder[preBegin]);
        }
        // 根据前序，取中序
        Integer lenOfLeft = map.get(preOrder[preBegin]);
        buildTree(preOrder, preBegin + 1, preBegin + lenOfLeft - inBegin, inOrder, inBegin,lenOfLeft - 1, deep + 1);
        buildTree(preOrder, preBegin + lenOfLeft -inBegin + 1, preEnd, inOrder,  lenOfLeft + 1, inEnd, deep + 1);
    }
}

package code.tree;

import java.util.*;

/**
 * 二叉搜索树中的众树
 */
public class FindMode {
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list.stream().mapToInt(Integer::intValue).toArray();
        searchBST(root, map);
        for (Map.Entry m : map.entrySet()) {
            queue.add(new int[]{(int) m.getKey(), (int) m.getValue()});
        }
        int[] poll = queue.poll();
        list.add(poll[0]);
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            if (p[1] == poll[1]) {
                list.add(p[0]);
            } else {
                break;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public void searchBST(TreeNode curr, Map<Integer, Integer> map) {
        if (curr == null)
            return;
        map.put(curr.val, map.getOrDefault(curr.val, 0) + 1);
        searchBST(curr.left, map);
        searchBST(curr.right, map);
    }
}

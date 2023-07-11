package nc;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * 字符串出现次数的TopK问题
 */
public class TopKstrings {
    public String[][] topKstrings(String[] strings, int k) {
        // write code here
        if (k == 0){
            return new String[][]{};
        }
        String[][] res = new String[k][2];
        TreeMap<String, Integer> map = new TreeMap<>();
        for (String str : strings) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(k, (o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o2.getKey().compareTo(o1.getKey());
            } else {
                return o1.getValue() - o2.getValue();
            }
        });
        Comparator<? super Map.Entry<String, Integer>> comparator = queue.comparator();
        for(Map.Entry<String,Integer> entry :map.entrySet()){
            if (queue.size() < k){
                queue.offer(entry);
            } else if (comparator.compare(queue.peek(),entry) < 0) {
                //如果堆顶元素 < 新数，则删除堆顶，加入新数入堆
                queue.poll();
                queue.offer(entry);
            }
        }
        for (int i = k-1; i >=0; --i) {
            Map.Entry<String,Integer> entry =(Map.Entry)queue.poll();
            res[i][0] = entry.getKey();
            res[i][1] = String.valueOf(entry.getValue());
        }
        return res;
    }
}

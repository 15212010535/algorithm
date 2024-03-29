package code.backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 重新安排行程
 */
public class FindItinerary {
    private LinkedList<String> res;
    private final LinkedList<String> path = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        tickets.sort((a, b) -> a.get(1).compareTo(b.get(1)));
        path.add("JFK");
        boolean[] used = new boolean[tickets.size()];
        backTracking((ArrayList<List<String>>) tickets, used);
        return res;
    }

    private boolean backTracking(ArrayList<List<String>> tickets, boolean[] used) {
        if (path.size() == tickets.size() + 1) {
            res = new LinkedList<>(path);
            return true;
        }
        for (int i = 0; i < tickets.size(); i++) {
            if (!used[i] && tickets.get(i).get(0).equals(path.getLast())) {
                path.add(tickets.get(i).get(1));
                used[i] = true;
                if (backTracking(tickets, used))
                    return true;
                used[i] = false;
                path.removeLast();
            }
        }
        return false;
    }
}

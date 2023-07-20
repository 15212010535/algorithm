package nc;

import java.util.ArrayList;

/**
 * 最大数
 */
public class MaxNumber {
    public String solve(int[] nums) {
        ArrayList<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        list.sort((o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        if (list.get(0).equals("0"))
            return "0";
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        return sb.toString();
    }
}

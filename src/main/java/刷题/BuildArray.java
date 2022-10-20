package 刷题;

import java.util.ArrayList;
import java.util.List;

public class BuildArray {

    public static List<String> buildArray(int[] target, int n) {
        List<String> str = new ArrayList<>();
        int j = 1;
        for (int i = 0; i < target.length; ) {
            if (target[i] == j) {
                str.add("Push");
                i++;
            } else {
                str.add("Push");
                str.add("Pop");
            }
            j++;
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(buildArray(new int[]{1, 3}, 3));
    }
}

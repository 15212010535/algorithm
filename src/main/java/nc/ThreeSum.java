package nc;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 三数之和
 */
public class ThreeSum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // write code here
        int len = num.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (len < 3)
            return res;
        Arrays.sort(num);
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && num[i] == num[i - 1])
                continue;
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                if (num[i] + num[left] + num[right] == 0) {
                    res.add(new ArrayList<>(Arrays.asList(num[i], num[left], num[right])));
                    while (left<right && num[left] == num[left+1])left++;
                    while (left<right && num[right] == num[right-1])right--;
                    right--;
                    left++;
                } else if (num[i] + num[left] + num[right] > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}

package nc;

import java.util.Arrays;

/**
 * 缺失的第一个正整数
 */
public class MinNumberDisappeared {
    public int minNumberDisappeared(int[] nums) {
        // write code here
        int res = 1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0){
                continue;
            }else if (nums [i] == res){
                res++;
            } else {
                return res;
            }
        }
        return nums[nums.length - 1] + 1;
    }
}

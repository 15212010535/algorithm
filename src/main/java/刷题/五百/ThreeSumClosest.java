package 刷题.五百;

import java.util.Arrays;

/**
 * 16、最接近的三数之和
 */
public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int best = Integer.MAX_VALUE;
        int n = nums.length;

        // 枚举a
        for (int i = 0; i < n; i++) {

            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            // 使用双指针枚举b和c
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target)
                    return target;

                // 根据差值的绝对值来更新结果
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                // 过滤掉相同的元素
                if (sum > target) {
                    int k0 = k - 1;
                    while (j < k0 && nums[k0] == nums[k])
                        --k0;
                    k = k0;
                } else {
                    int j0 = j + 1;
                    while (j0 < k && nums[j0] == nums[j])
                        ++j0;
                    j = j0;
                }
            }
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}

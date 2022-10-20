package 刷题.五百;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15、三数之和
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();

        // 对数组进行排序
        for (int first = 0; first < n; ++first) {
            // 因为是三个数，需要保证三个和上一次的数不相同
            if (first > 0 && nums[first] == nums[first - 1])
                continue;
            int third = n - 1;
            int target = -nums[first];
            // 枚举b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不同
                if (second > first + 1 && nums[second] == nums[second - 1])
                    continue;
                // 需要保证b的指针在c的指针左侧,找到满足要求的指针c，即b+c < a
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                if (second == third)
                    break;
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    lists.add(list);
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}

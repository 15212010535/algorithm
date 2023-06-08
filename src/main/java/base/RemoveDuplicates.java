package base;

/**
 * 删除有序数组中的重复项
 */
public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 1;
        int right = 1;
        while (right < nums.length) {
            if (nums[right] != nums[right - 1]) {
                nums[left++] = nums[right];
            }
            right++;
        }
        return left ;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}

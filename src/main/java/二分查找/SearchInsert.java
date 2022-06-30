package 二分查找;


/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 */
public class SearchInsert {
    public static int searchInsert(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        int index = 0;
        while (left <= right) {
            index = (right + left) / 2;
            if (target > nums[index]) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        int index = searchInsert(nums, target);
        System.out.println(index);
    }
}

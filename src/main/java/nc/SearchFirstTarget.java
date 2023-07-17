package nc;

/**
 * 二分查找-II
 */
public class SearchFirstTarget {
    public int search(int[] nums, int target) {
        // write code here
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid =(left + right) >> 1;
            if (nums[mid] == target) {
                while (mid > 0&& nums[mid] == nums[mid-1])
                    mid--;
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}

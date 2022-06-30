package 二分查找;

/**
 * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1
 */
public class Search {
    public static int search(int[] nums, int target) {
        int right = nums.length;
        int left = 0;
        int index = (right + left) / 2;
        int i = 0;
        while (i < nums.length) {
            System.out.println(index);
            if (target == nums[index]) {
                break;
            } else if (target > nums[index]) {
                left = index + 1;
                index = (right + left) / 2;
            } else {
                right = index - 1;
                index = (right + left) / 2;
            }
            if (index >= nums.length || index < 0) {
                index = -1;
                break;
            }
            i++;
        }
        if (i == nums.length)
            return -1;
        else
            return index;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int index = search(nums, -1);
        System.out.println(index);
    }

}

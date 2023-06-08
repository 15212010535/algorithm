package code.array;

public class RemoveElement {

    /**
     * 快慢指针
     * @param nums
     * @param val
     * @return
     */
    public int removeElementOne(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    /**
     * 双指针
     * @param nums
     * @param val
     * @return
     */
    public int removeElementTwo(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while (right >=0 && nums[right] == val)
            right--;
        while (left<=right){
            if(nums[left] == val){
                nums[left] = nums[right];
                right--;
            }
            left++;
            while (right>=0 && nums[right] == val)
                right--;
        }
        return left;
    }
}

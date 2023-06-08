package code.array;

/**
 * 有序数组的平方
 */
public class SortedSquares {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[nums.length];
        int j = nums.length - 1;
        while (left<= right){
            if(nums[left] * nums[left] > nums[right]*nums[right]){
                res[j--] = nums[left] * nums[left++];
            }else {
                res[j--] = nums[right] * nums[right--];
            }
        }
        return res;
    }
}

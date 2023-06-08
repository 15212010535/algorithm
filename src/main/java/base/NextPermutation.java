package base;

/**
 * 下一个排列
 * 双循环
 * 1、从后往前找到不满足递增的下标i
 * 2、从后往前找到第一个大于num[i]的，交换位置
 * 3、将i+1 到 length-1 逆序
 */
public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return;
        int i = len - 2;
        while (i >= 0 && nums[i] >= nums[i + 1])
            i--;
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
        i += 1;
        while (i < len - 1) {
            int temp = nums[i];
            nums[i] = nums[len - 1];
            nums[len - 1] = temp;
            i++;
            len--;
        }
    }

    public static void main(String[] args) {
        nextPermutation(new int[]{1, 3, 2});
    }
}

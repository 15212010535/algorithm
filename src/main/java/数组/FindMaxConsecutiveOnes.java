package 数组;

/**
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 * 实例:
 * 输入：nums = [1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 */
public class FindMaxConsecutiveOnes {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int tmp = 0;
        for (int num : nums) {
            if (num == 1) {
                tmp++;
            } else {
                if (tmp > count)
                    count = tmp;
                tmp = 0;
            }
        }
        if (tmp > count)
            count = tmp;
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int count = findMaxConsecutiveOnes(nums);
        System.out.println(count);
    }
}

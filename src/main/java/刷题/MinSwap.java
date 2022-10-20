package 刷题;

/**
 * 使序列递增的最小交换次数
 */
public class MinSwap {

    public static int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int a = 0, b = 1;
        for (int i = 1; i < n; i++) {
            int at = a, bt = b;
            a = b = n;
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                a = Math.min(a, at);
                b = Math.min(b, bt + 1);
            }
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                a = Math.min(a, bt);
                b = Math.min(b, at + 1);
            }
        }
        return Math.min(a, b);
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{0, 7, 8, 10, 10, 11, 12, 13, 19, 18};
        int[] num2 = new int[]{4, 4, 5, 7, 11, 14, 15, 16, 17, 20};
        System.out.println(minSwap(num1, num2));
    }
}

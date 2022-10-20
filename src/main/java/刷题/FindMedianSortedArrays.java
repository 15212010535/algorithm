package 刷题;

public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length > 0) {
            return nums2.length % 2 == 0 ? (nums2[nums2.length / 2] + nums2[nums2.length / 2 - 1]) / 2. : nums2[nums2.length / 2];
        }
        if (nums1.length > 0 && nums2.length == 0) {
            return nums1.length % 2 == 0 ? (nums1[nums1.length / 2] + nums1[nums1.length / 2 - 1]) / 2. : nums1[nums1.length / 2];
        }

        // 遍历
        int length = (nums2.length + nums1.length) / 2 - 1;
        int m = 0, n = 0;
        for (int i = 0; i < length; i++) {
            int a = m < nums1.length ? nums1[m] : -1;
            int b = n < nums2.length ? nums2[m] : -1;
            
            m++;
            n++;
        }
        return 1;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}

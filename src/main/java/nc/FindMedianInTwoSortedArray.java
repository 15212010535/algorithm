package nc;

/**
 * 在两个长度相等的排序数组中找到上中位数
 */
public class FindMedianInTwoSortedArray {
    public int findMedianInTwoSortedArray(int[] arr1, int[] arr2) {
        // write code here
        int n = arr1.length;
        int left = 0;
        int right = n;
        while(left<right){
            int i = left + ((right-left)>>1);
            int j = n - i;
            if(arr1[i] < arr2[j-1]){
                left = i+1;
            }else{
                right = i;
            }
        }
        int bound1 = left;
        int bound2 = n - left;
        if(bound1 == n){
            return arr1[n-1];
        }
        if(bound2 == n){
            return arr2[n-1];
        }
        return Math.max(arr1[bound1-1], arr2[bound2-1]);
    }
}

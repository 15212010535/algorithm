package code.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 两个数组的交集
 */
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length==0||nums2 == null || nums2.length == 0)
            return new int[0];
        Set<Integer> set = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        for(int num : nums1)
            set.add(num);

        for(int num : nums2){
            if (set.contains(num)){
                resSet.add(num);
            }
        }
        return resSet.stream().mapToInt(x->x).toArray();
    }
}

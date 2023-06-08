package base;

/**
 * 移除元素
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int ans = 0;
        for(int num: nums){
            if(num!=val)
                nums[ans++]=num;
        }
        return ans;
    }
}

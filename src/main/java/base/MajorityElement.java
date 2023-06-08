package base;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int ret = nums[0];
        int count = 1;
        for (int num : nums) {
            if (num == ret)
                count++;
            else {
                if (--count == 0) {
                    count = 1;
                    ret = num;
                }
            }
        }
        return ret;
    }
}

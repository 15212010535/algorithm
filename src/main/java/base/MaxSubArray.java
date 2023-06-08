package base;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set("111");
        ThreadLocal t1 = new ThreadLocal();
        t1.set("4444");
        ThreadLocal t2 = new ThreadLocal();
        t2.set("5555");
        System.out.println("threadLocal.get() = " + threadLocal.get());
        System.out.println("threadLocal.get() = " + threadLocal.get());
        System.out.println("threadLocal.get() = " + threadLocal.get());
    }
}

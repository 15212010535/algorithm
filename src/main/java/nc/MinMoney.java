package nc;

import java.util.Arrays;

/**
 * 兑换零钱(一)
 */
public class MinMoney {
    int res = Integer.MAX_VALUE;

    public int minMoney(int[] arr, int aim) {
        // write code here
        if (aim == 0)
            return 0;
        Arrays.sort(arr);
        process(arr, aim, arr.length - 1, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void process(int[] arr, int aim, int idx, int count) {
        if (idx < 0)
            return;
        for (int i = aim / arr[idx]; i >= 0; i--) {
            int remain = aim - i * arr[i];
            int cnt = count + i;
            if (cnt >= res)
                break;
            if (remain == 0) {
                res = Math.min(res, cnt);
                break;
            }
            if (cnt + 1 >= res)
                break;
            process(arr, remain, idx - 1, cnt);
        }
    }
}

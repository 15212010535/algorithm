package base;

/**
 * 加油栈
 */
public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0; // 当前点出发
        while (i < n) {
            int sumOfGas = 0, sumOfCost = 0;
            int cnt = 0; // 经过的加油站数量
            while (cnt < n) {
                int j = (i + cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if (sumOfCost > sumOfGas) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
                i = i + cnt + 1; // 从不能过的下一个开始
            }
        }
        return -1;
    }
}

package offer;

/**
 * 旋转数组的最小数字
 */
public class offer10 {
    public static int minArray(int[] numbers) {
        if (numbers.length == 0)
            return -1;
        int i = 0;
        int j = numbers.length - 1;
        int min;
        if (numbers[i] >= numbers[j]) {
            min = numbers[j];
            for (int k = j - 1; k > 0; k--) {
                if (numbers[k] <= min)
                    min = numbers[k];
                else
                    return min;
            }
        } else {
            min = numbers[i];
            for (int k = 1; k < j; k++) {
                if (numbers[k] < min) {
                    min = numbers[k];
                } else
                    return min;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 3, 3};
        int i = minArray(arr);
        System.out.println(i);
    }
}

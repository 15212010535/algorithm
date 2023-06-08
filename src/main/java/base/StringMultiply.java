package base;

/**
 * 字符串乘法
 */
public class StringMultiply {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] arr = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int m = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n = num2.charAt(j) - '0';
                int sum = m * n + arr[i + j + 1];
                arr[i + j + 1] = sum % 10;
                arr[i + j] += sum / 10;
            }
        }
        StringBuilder stringBuffer = new StringBuilder();
        if (arr[0] != 0) {
            stringBuffer.append(arr[0]);
        }
        for (int i = 1; i < arr.length; i++) {
            stringBuffer.append(arr[i]);
        }
        return stringBuffer.toString();
    }
}

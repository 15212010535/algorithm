package 刷题.一千;

/**
 * 779. 第K个语法符号
 * 表示2的n-2次方: (1 << (n - 2)
 */
public class KthGrammar {

    public static int kthGrammar(int n, int k) {
        if (n == 0) {
            return 0;
        }
        // 递归前一半
        if (k <= (1 << (n - 2))) {
            return kthGrammar(n - 1, k);
        }
        // 递归后一半, ^1 只需要一半，所以反转就可以
        return kthGrammar(n - 1, k - (1 << (n - 2))) ^ 1;
    }

    public static void main(String[] args) {
        System.out.println(kthGrammar(4, 1));
    }
}

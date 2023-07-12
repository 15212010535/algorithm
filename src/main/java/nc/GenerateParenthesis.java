package nc;

import java.util.ArrayList;

/**
 * 括号生成
 */
public class GenerateParenthesis {
    public ArrayList<String> generateParenthesis(int n) {
        // write code here
        ArrayList<String> res = new ArrayList<>();
        generateHelper(n, n, "", res);
        return res;
    }

    public void generateHelper(int left, int right, String path, ArrayList<String> res) {
        if (left == 0 && right == 0) { // 终止条件
            res.add(path);
            return;
        }
        if (left > right) { // 剪枝
            return;
        }
        if (left > 0)
            generateHelper(left - 1, right, path + "(", res);
        if (right > 0)
            generateHelper(left, right - 1, path + ")", res);
    }
}

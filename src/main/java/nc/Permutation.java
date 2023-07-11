package nc;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 字符串排列
 */
public class Permutation {
    ArrayList<String> res;
    StringBuilder path;
    boolean[] used;

    public ArrayList<String> permutation(String str) {
        // write code here
        int length = str.length();
        res = new ArrayList<>();
        if (length == 0){
            res.add(str);
            return res;
        }
        path = new StringBuilder();
        used = new boolean[length];
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        permutationHelper(chars);
        return res;
    }

    private void permutationHelper(char[] charArray) {
        if (path.length() == charArray.length) {
            res.add(path.toString());
            return;
        }
        for (int i = 0; i < charArray.length; i++) {
            if (i>0 && charArray[i] == charArray[i-1] && !used[i - 1]) {
                continue;
            }
            if(!used[i]){
                path.append(charArray[i]);
                used[i] = true;
                permutationHelper(charArray);
                path.deleteCharAt(path.length() - 1);
                used[i] = false;
            }
        }
    }
}

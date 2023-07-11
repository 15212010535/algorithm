package nc;

/**
 * 最长公共子序列
 */
public class LCS {
    public String lCS(String str1, String str2) {
        // write code here
        int start = 0;
        int end = 1;
        String result = "";
        while (end <= str2.length()){
            String s = str2.substring(start, end);
            if (str1.contains(s)){
                result = s;
            }else {
                start++;
            }
            end++;
        }
        return result;
    }
}

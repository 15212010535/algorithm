package nc;

import java.math.BigInteger;

/**
 * 大数相乘
 */
public class StringMult {
    public String solve(String s, String t) {
        // write code here
        BigInteger sb = new BigInteger(s);
        BigInteger tb = new BigInteger(t);
        return String.valueOf(sb.multiply(tb));
    }
}

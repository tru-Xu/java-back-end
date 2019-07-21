package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringInterval {

    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        return isInterval(s1, s1, s3);
    }

    private boolean isInterval(String s1, String s2, String s3) {

        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        char[] c = s3.toCharArray();
        String.valueOf(c);

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        String[] strings = new String[]{"123", "234"};
        List<String> s = Arrays.asList(strings);
        List<List<Character>> list = new ArrayList<>();

        ;
        //Arrays.sort();
        for(int i = 1; i < s1.length() + 1; i++) {
            dp[i][0] = dp[i-1][0] && (a[i - 1] == c[i - 1]);
        }
        for(int j = 1; j < s2.length() + 1; j++){
            dp[0][j] = dp[0][j-1] &&(b[j - 1] == c[j - 1]);
        }
        for(int i = 1; i <= s1.length(); i++) {
            for(int j = 1; j <= s2.length(); j++){
                dp[i][j] =  (dp[i - 1][j] && (a[i-1] == c[i - 1 + j]))
                        || (dp[i][j - 1] && (b[j-1] == c[i - 1 + j]));
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args){
        StringInterval stringInterval = new StringInterval();
        stringInterval.isInterleave("com.aily.bean","","com.aily.bean");
    }
}

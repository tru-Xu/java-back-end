package leetcode;

public class RegularMatch {

    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean dp[][] = new boolean[sLen + 1][pLen + 1];
        char[] sA = s.toCharArray();
        char[] pA = p.toCharArray();
        dp[0][0] = true;
        for(int i = 0; i < pLen; i++){
            if(pA[i] == '*'){
                dp[0][i + 1] = dp[0][i];
                if(i >= 1){
                    dp[0][i + 1] = dp[0][i + 1] || dp[0][i - 1];
                }
            }else if(pA[i] == '.'){
                dp[0][i + 1] = dp[0][i];
            }
        }
        for(int i = 0; i < sLen; i++){
            for(int j = 0; j < pLen; j++) {
                if(sA[i] == pA[j]){
                    dp[i + 1][j + 1] = dp[i][j];
                }else if(pA[j] == '.'){
                    dp[i + 1][j + 1] = dp[i][j] || dp[i + 1][j];
                }else if(pA[j] == '*') {
                    if(j >= 1){
                        dp[i + 1][j + 1] = dp[i + 1][j - 1] || dp[i + 1][j];
                        if(pA[j - 1] == sA[i] || pA[j - 1] == '.'){
                            dp[i + 1][j + 1] = dp[i][j + 1] || dp[i][j];
                        }
                    }
                }
            }
        }

        return dp[sLen][pLen];
    }
    public static void main(String[] args) {
        RegularMatch regularMatch = new RegularMatch();
        String s = "aaa";
        String p = ".*";

        regularMatch.isMatch(s, p);
    }
}

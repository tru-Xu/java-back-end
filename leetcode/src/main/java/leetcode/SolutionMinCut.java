package leetcode;

public class SolutionMinCut {

    public int minCut(String s) {
        int len  = s.length();
        if(len <= 1) {
            return 0;
        }
        char[] cs = s.toCharArray();
        int [][] dp = new int[len][len];
        for(int j = 0; j < len; j++) {
            for(int i = 0; i <= j; i++) {
                if(j - i > 2) {
                    dp[i][j] = (cs[i] == cs[j])&&(dp[j + 1][i - 1] == 1) ? 1 : 0;
                } else {
                    dp[i][j] = (cs[i] == cs[j]) ? 1 : 0;
                }
            }
        }
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = 1;
        }
        for(int i = 1; i < len; i++) {
            int min = result[i - 1] + 1;
            for(int j = 0; j < i; j++) {
                if (dp[j][i] == 1) {
                    min = result[j] < min ? result[j] : min;
                }
            }
            result[i] = min;
        }
        return result[len - 1] - 1;
    }

    public static void main(String[] args) {
        SolutionMinCut solutionMinCut = new SolutionMinCut();
        int res = solutionMinCut.minCut("abbab");
        System.out.println(res);
    }
}

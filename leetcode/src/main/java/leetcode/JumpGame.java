package leetcode;

public class JumpGame {

    public int jump(int[] A) {
        if(A.length <= 1) return 0;
        int dp[] = new int [A.length];
        dp[0] = 0;
        for(int i = 0; i < A.length; i++) {
            if(i == 0) {
                dp[0] = 0;
            }
            if(A[i] >= A.length - i - 1){
                return dp[i] + 1;
            }else {
                for(int j = i + 1; j <= i + A[i]; j++){
                    if(dp[j] == 0 || dp[i] + 1 < dp[j]){
                        dp[j] = dp[i] + 1;
                    }
                }
            }

        }
        return -1;
    }

    public static  void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        int[] a= new int[]{1, 2};
        int step = jumpGame.jump(a);
        System.out.println(step);
    }
}

package leetcode;

public class MutiString {

    public String multiply(String num1, String num2) {
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int len1 = num1.length();
        int len2 = num2.length();

        int[][] mul = new int[len2][len1 + len2];
        for(int i = len2 - 1; i >= 0; i--) {
            int next = 0;
            for(int j = len1 - 1; j >= 0; j--) {
                int n1 = c1[j] - '0';
                int n2 = c2[i] - '0';
                mul[len2 - 1 - i][i + j + 1] = ((n1 * n2 + next)%10);
                next = (n1 * n2 + next)/10;
            }
            if(next != 0){
                mul[len2 - 1 - i][i] = next;
            }
        }
        int[] res = new int[len1 + len2];
        int next = 0;
        for(int i = len1 + len2 - 1; i >= 0; i--){
            int sum = 0;
            for(int j = 0; j < len2; j++){
                sum += mul[j][i];
            }
            res[i] = (sum + next)%10;
            next = (sum + next)/10;
        }
        if(next != 0){
            res[0] = next;
        }
        String result = "";
        for(int i = 0; i < len1 + len2; i++){
            if(i != 0 || res[i] != 0){
                result += String.valueOf(res[i]);
            }
        }
        return result;
    }

    public static void main(String[] args){
        MutiString mutiString = new MutiString();
        String s = mutiString.multiply("98", "9");
        System.out.println(s);
    }
}

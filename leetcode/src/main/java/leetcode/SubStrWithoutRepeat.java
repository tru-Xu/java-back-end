package leetcode;

public class SubStrWithoutRepeat {

    public int lengthOfLongestSubstring(String s) {
        int[] flag = new int[256];
        char[] c = s.toCharArray();
        int max = 0;
        int start = 0;
        for(int i = 0; i < s.length(); i++) {
            if(flag[c[i]] > 0){
                max = (i - start) > max ? (i - start) : max;
                start = flag[c[i]];
            }
            flag[c[i]] = i + 1;
        }
        max = (s.length() - start) > max ? (s.length() - start) : max;
        return max;
    }

    public static void main(String[] args) {
        SubStrWithoutRepeat subStrWithoutRepeat = new SubStrWithoutRepeat();
        String a = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";

        subStrWithoutRepeat.lengthOfLongestSubstring(a);
    }
}

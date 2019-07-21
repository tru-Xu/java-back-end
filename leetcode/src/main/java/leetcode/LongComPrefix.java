package leetcode;

public class LongComPrefix {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        int start = 0;
        while(true){
            for(int i = 0; i < strs.length; i++) {
                if(null == strs[i] || strs[i].length() <= start){
                    return res;
                }else {
                    if(i != 0 && strs[i].charAt(start) != strs[i - 1].charAt(start)){
                        return res;
                    }
                }
            }
            res += strs[0].charAt(start);
            start++;
        }
        //return res;
    }

    public static void main(String[] args) {
        LongComPrefix longComPrefix = new LongComPrefix();
        String a = "";
        String[] s = new String[]{"com.aily.bean", "b"};
        longComPrefix.longestCommonPrefix(s);
    }
}

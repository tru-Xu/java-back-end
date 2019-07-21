package leetcode;

import java.util.ArrayList;

public class PartionPalindrome {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        int len = s.length();
        if(len < 1) {
            return res;
        }
        ArrayList<String> list = new ArrayList<>();
        doPartion(res, list, s);
        return res;
    }
    private void doPartion(ArrayList<ArrayList<String>> res, ArrayList<String> list, String s) {
        if(null == s || s.length() == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i <= s.length(); i++) {
            if(isPalinDrome(s.substring(0,i))) {
                list.add(s.substring(0,i));
                doPartion(res, list, s.substring(i, s.length()));
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalinDrome(String s) {
        if(null == s || s.length() == 0) {
            return false;
        }
        int midle = s.length()/2;
        for(int i = 0; i < midle; i++) {
            if(s.charAt(i) != s.charAt(s.length() - 1 -i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PartionPalindrome partionPalindrome = new PartionPalindrome();
        ArrayList<ArrayList<String>> res = partionPalindrome.partition("com.aily.bean");
        System.out.println(res);
    }
}

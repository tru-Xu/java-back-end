package com.aily.KMP;

public class KMP {

    public int[] getNext(String a) {
        int len = a.length();
        char[] chars = a.toCharArray();
        int i = 1;
        int k = 0;
        int[] next = new int[len + 1];
        next[0] = 0;
        while (i < len) {
            if (k == 0 || chars[i] == chars[k]) {
                if (chars[i] == chars[k])
                    ++k;

                next[i] = k;
                ++i;
            } else {
                k = next[k - 1];
            }
/*            while(k > 0 && chars[i] != chars[k]) {
                k = next[k - 1];
            }
            if(chars[i] == chars[k]) {
                k++;
            }
            next[i] = k;
            i++;*/
        }
        return next;
    }

    /**
     * next 修正
     *
     * @param a
     * @return
     */
    public int[] getNextVal(String a) {
        int len = a.length();
        char[] chars = a.toCharArray();
        int i = 1;
        int k = 0;
        int[] next = new int[len + 1];
        next[0] = 0;
        while (i < len) {
            if (k == 0 || chars[i] == chars[k]) {
                if (chars[i] == chars[k]) {
                    if (i > 0 && chars[i] == chars[next[i - 1] + 1]) {
                        next[i] = next[i - 1];
                    } else {
                        ++k;
                    }
                } else {
                    next[i] = k;
                }
                ++i;
            } else {
                k = next[k - 1];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        KMP kmp = new KMP();
        String s = "abaaaba";
        int[] next = kmp.getNext(s);
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i) + " " + next[i]);
        }
    }
}

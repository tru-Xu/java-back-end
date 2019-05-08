package leetcode;

import java.util.Scanner;

public class StringMuti {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        int[][] cArray = new int[a.length() + b.length()][a.length()];
        for(int i = a.length() - 1; i >= 0; i--) {
            int nextNum = 0;
            int aNum = aArray[i] - '0';
            for(int j =  b.length() - 1; j >= 0; j--) {
                int bNum = bArray[j] - '0';
                int row = a.length() + b.length() - 2 - i - j;
                int col =  a.length() - 1 - i;
                int rem = (bNum * aNum + nextNum)% 10 ;
                nextNum = (bNum * aNum + nextNum)/ 10 ;
                cArray[row][col] = rem;
            }
            cArray[a.length() + b.length() - 1 - i][a.length() - 1 - i] = nextNum;
        }
        int[] dArray = new int [a.length() + b.length()];
        int next = 0;
        for(int i = 0; i <= a.length() + b.length() - 1 ; i++) {
            for(int j = a.length() - 1; j >= 0; j--) {
                dArray[i] += cArray[i][j];
            }
            int temp = dArray[i];
            dArray[i] = (temp + next)%10;
            next = (temp + next)/10;
        }
        int end = 0;
        for(int k = a.length() + b.length() - 1; k >= 0; k--) {
            if(dArray[k] != 0) {
                end = k;
                break;
            }
        }
        String s = "";
        for(int i = end; i >= 0; i--) {
            String st = String.valueOf(dArray[i]);
            s =  s + st;
        }
        System.out.println(s);
    }

}

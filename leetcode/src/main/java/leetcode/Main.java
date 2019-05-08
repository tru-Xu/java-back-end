package leetcode;

import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        int max = getMax(a, n);

        System.out.println(max);
    }

    private static int getMax(int[] a, int n) {
        if(n < 3) return 0;
        int [] minA = new int[2];
        int [] maxA = new int[3];

        if(a[1] > a[0]) {
            minA[0] = a[0];
            maxA[0] = a[0];
            minA[1] = a[1];
            maxA[1] = a[1];
        }else {
            minA[0] = a[1];
            maxA[0] = a[1];
            minA[1] = a[0];
            maxA[1] = a[0];
        }
        if(a[2] > maxA[1]) {
            maxA[2] = a[2];
        }else if(a[2] > maxA[0]) {
            maxA[2] = maxA[1];
            maxA[1] = a[2];
        }else {
            maxA[2] = maxA[1];
            maxA[1] = maxA[0];
            maxA[0] = a[2];
        }
        if(a[2] < minA[0]) {
            minA[1] = minA[0];
            minA[0] = a[2];
        }else if(a[2] < minA[1]) {
            minA[1] = a[2];
        }

        for(int i = 3; i < n; i++) {
            if(a[i] < minA[0]) {
                minA[1] = minA[0];
                minA[0] = a[i];
            }else if (a[i] < minA[1]) {
                minA[1] = a[i];
            }

            if(a[i] > maxA[2]) {
                maxA[0] = maxA[1];
                maxA[1] = maxA[2];
                maxA[2] = a[i];
            }else if(a[i] > maxA[1]) {
                maxA[0] = maxA[1];
                maxA[1] = a[i];
            }else if(a[i] > maxA[0]) {
                maxA[0] = a[i];
            }

        }
        if(maxA[2] <= 0) {
            return maxA[0]*maxA[1]*maxA[2];
        }else {
            int smallMuti = minA[0]*minA[1];
            int bigMuti = maxA[0]*maxA[1];
            int twoMuti = (smallMuti > bigMuti ? smallMuti : bigMuti);
            return twoMuti*maxA[2];
        }

    }

}

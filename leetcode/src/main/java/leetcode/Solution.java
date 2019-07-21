package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n -1)/2, right = (m + n)/2;

        int leftValue = findNum(nums1, nums2, left);
        int rightValue = findNum(nums1, nums2, right);
        return (leftValue + rightValue)/2.0;
    }

    private int findNum(int[] nums1, int[] nums2, int k){
        if(nums1 == null || nums1.length == 0){
            return nums2[k];
        }
        if(nums2 == null || nums2.length == 0) {
            return nums1[k];
        }
        if(k == 0) {
            return nums1[0] < nums2[0] ? nums1[0] : nums2[0];
        }
        int m = nums1.length;
        int n = nums2.length;

        int mid1 = m >> 1;
        int mid2 = n >> 1;
        if(nums1[mid1] == nums2[mid2]) {
            return nums1[mid1];
        }else if(nums1[mid1] > nums2[mid2]){
            int[] newNums1 = new int[mid1 + 1];
            for(int i = 0; i <= mid1; i++) {
                newNums1[i] = nums1[i];
            }
            int[] newNums2 = new int[n - mid2];
            for(int i = mid2; i < n; i++) {
                newNums2[i - mid2] = nums2[i];
            }
            if(mid2 == 0) return nums1[0] > nums2[0] ? nums1[0] : nums2[0];
            return findNum(newNums1, newNums2, k - mid2);
        }else{
            int[] newNums1 = new int[m - mid1];
            for(int i = mid1; i < m; i++) {
                newNums1[i - mid1] = nums1[i];
            }
            int[] newNums2 = new int[mid2 + 1];
            for(int i = 0; i <= mid2; i++) {
                newNums2[i] = nums2[i];
            }
            if(mid1 == 0) return nums1[0] > nums2[0] ? nums1[0] : nums2[0];
            return findNum(newNums1, newNums2, k - mid1);
        }
    }
}

class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String doubleToString(double input) {
        return new DecimalFormat("0.00000").format(input);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums1 = stringToIntegerArray(line);
            line = in.readLine();
            int[] nums2 = stringToIntegerArray(line);

            double ret = new Solution().findMedianSortedArrays(nums1, nums2);

            String out = doubleToString(ret);

            System.out.print(out);
        }
    }
}
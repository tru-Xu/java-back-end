package leetcode;

import java.util.Stack;

public class TrapRainWater {

    public int trap(int[] A) {
        Stack<Integer> stack = new Stack<>();
        //stack.push(-1);

        int sum = 0;
        int low = 0;
        for(int i = 0; i < A.length; i++) {
            if(stack.isEmpty()) {
                stack.push(i);
            }else if(A[i] >= A[stack.peek()]){
                int index = stack.pop();
                int square = A[index] * (i - index - 1);
                sum += (square - low);
                stack.push(i);
                low = 0;
            }else {
                low += A[i];
            }
        }
        low = 0;
        int start = 0;
        if(!stack.isEmpty()) {
            start = stack.pop();
        }

        for(int i = A.length - 1; i >= start; i--){
            if(stack.isEmpty()) {
                stack.push(i);
            }else if(A[i] >= A[stack.peek()]){
                int index = stack.pop();
                int square = A[index] * (index - i - 1);
                sum += (square - low);
                stack.push(i);
                low = 0;
            }else {
                low += A[i];

            }
        }
        return sum;
    }

    public static void main(String[] args){
        TrapRainWater trapRainWater = new TrapRainWater();
        int[] A = new int[]{4, 2, 3};
        int sum = trapRainWater.trap(A);
        System.out.println(sum);
    }
}

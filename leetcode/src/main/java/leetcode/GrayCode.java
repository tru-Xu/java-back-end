package leetcode;

import java.util.ArrayList;

public class GrayCode {

    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        int first = 0;
        res.add(first);
        for(int i = 0; i < n; i++){
            first += 1<<i;
            res.add(first);
        }
        for(int i = 1; i < n; i++){

            //first << i;
            res.add(first);
        }
        return res;
    }

    public static void main(String[] args){
        int first = 0;

        for(int i = 0; i < 8; i++) {
            first += 1<<i;
            System.out.println(first);
        }
        int second = 0;
        for(int i = 0; i < 8; i++){
            second += 1<<i;
            ;
            System.out.println(second);
            System.out.println(first^second);
        }
    }
}

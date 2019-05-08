package leetcode;

import java.util.*;

public class FourSum {

    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        getFour(num, 0, target, 0, list, res);
        return res;
    }
    private void getFour(int[] num, int start, int target, int count, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> res){
        if(count == 4 && target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if(count >= 4 && target != 0){
            return;
        }

        for(int i = start; i + 4 - count <= num.length; i++){
            if(i != start && num[i] == num[i - 1]){
                continue;
            }
            list.add(num[i]);
            getFour(num, i + 1, target - num[i], count + 1, list, res);
            list.remove(list.size() - 1);

        }
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();

        int[] num = new int[]{2, 0, -1, 1};
        fourSum.fourSum(num, 2);


    }
}

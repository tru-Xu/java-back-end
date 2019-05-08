package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PascalTriangle {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> old = new ArrayList<>();
        old.add(1);
        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(old);
        for(int i = 1; i <= rowIndex; i++) {
            ArrayList<Integer> last = new ArrayList<>();
            last.add(1);
            for(int j = 1; j < i; j++) {
                int temp = old.get(j-1) + old.get(j);
                last.add(temp);
            }

            last.add(1);
            old.clear();
            old.addAll(last);
            if(i == rowIndex) {
                res.addAll(last);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PascalTriangle pascalTriangle = new PascalTriangle();
        ArrayList<Integer> res = pascalTriangle.getRow(3);
        System.out.println(res);
    }

}

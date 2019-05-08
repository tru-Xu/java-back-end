package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Queen {

    private static int num = 0;
    public int totalNQueens(int n) {
        int[] a = new int[n + 1];

        back(a, n, 1);
        return num;
    }

    private void back(int[] a, int n, int cur){
        if(cur == n + 1) {
            num++;
            return;
        }
        for(int i = 1; i <= n; i++){
            a[cur] = i;
            if(satify(a, cur)){
                back(a, n, cur + 1);
            }
        }
    }
    private boolean satify(int[] a, int cur){
        for(int i = 1; i < cur; i++){
            if(a[i] == a[cur] || a[cur] - a[i] == cur - i
                    || a[cur] - a[i] == i - cur){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Queen queen = new Queen();
        queen.totalNQueens(2);
        System.out.println(num);
        String[] strs = new String[3];
        char[] chars = new char[3];
        String s = new String(chars);
        //List<Character> cl = new ArrayList<>(chars);
    }
}

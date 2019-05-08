package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++){
            int[] a = new int[board.length + 1];
            int[] b = new int[board.length + 1];
            int[] c = new int[board.length + 1];
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] != '.'){
                    int num = board[i][j] - '0';
                    if(a[num] != 0) {
                        return false;
                    }else {
                        a[num] = 1;
                    }
                }
                if(board[j][i] != '.'){
                    int num = board[j][i] - '0';
                    if(b[num] != 0) {
                        return false;
                    }else {
                        b[num] = 1;
                    }
                }
                int row = i/3*3 + j/3;
                int col = i%3*3 + j%3;
                if(board[row][col] != '.'){
                    int num = board[row][col] - '0';
                    if(c[num] != 0) {
                        return false;
                    }else {
                        c[num] = 1;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        ValidSudoku validSudoku = new ValidSudoku();
        char[][] A = new char[][]{".87654321".toCharArray(),
                                   "2........".toCharArray(),
                "3........".toCharArray(),
                "4........".toCharArray(),
                "5........".toCharArray(),
                "6........".toCharArray(),
                "7........".toCharArray(),
                "8........".toCharArray(),
                "9........".toCharArray(),};
        boolean res = validSudoku.isValidSudoku(A);
        System.out.println(res);

        Map<String, Integer> map = new HashMap<>();
        System.out.println(map.get("1"));
    }
}

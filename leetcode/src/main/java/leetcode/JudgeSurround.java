package leetcode;

import java.util.*;

public class JudgeSurround {
    public void solve(char[][] board) {
        if(board == null || board.length == 0) {
            return;
        }
        int row = board.length;
        int col = board[0].length;
        for(int i = 0; i < row; i++) {
            if(board[i][0] == 'O') {
                judge(board, i, 0);
            }
            if(board[i][col - 1] == 'O') {

                judge(board, i, col - 1);
            }

        }
        for(int i = 0; i < col; i++) {
            if(board[0][i] == 'O') {
                judge(board, 0, i);
            }
            if(board[row - 1][i] == 'O') {
                judge(board, row - 1, i);
            }
        }
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if(board[i][j] == 'S') {
                    board[i][j] = 'O';
                }
            }
        }


    }

    private void judge(char[][] board, int i, int j) {
        int row = board.length;
        int col = board.length;
        if(i < 0 || i > row - 1 || j < 0 || j > col - 1) {
            return;
        }
        if(board[i][j] == 'O') {
            board[i][j] = 'S';
        }
        if(j < col - 2 && board[i][j + 1] == 'O') {
            board[i][j + 1] = 'S';
            judge(board, i, j + 1);
        }

        if(j > 1 && board[i][j - 1] == 'O') {
            board[i][j - 1] = 'S';
            judge(board, i, j - 1);
        }
        if(i < row - 2 && board[i + 1][j] == 'O') {
            board[i + 1][j] = 'S';
            judge(board, i + 1, j);
        }
        if(i > 1 && board[i - 1][j] == 'O') {
            board[i - 1][j] = 'S';
            judge(board, i - 1, j);
        }

    }

    private void findLaddersImpl(ArrayList<ArrayList<String>> res, ArrayList<String> list,
                                 HashSet<String> dict, String start, String end) {
        if(start == end) {
            res.add(list);
            return;
        }
        if(list.size() > dict.size()) {
            return;
        }
        Iterator<String> setIt = dict.iterator();
        while(setIt.hasNext()) {
            String setString = setIt.next();
            if (!list.contains(setString)) {
                list.add(setString);
                findLaddersImpl(res, list, dict, setString, end);
                list.remove(setString);
            }
        }
    }
    public static  void main (String[] args) {
        JudgeSurround surround = new JudgeSurround();
/*        char[][] charArray = {{'X','O','X','O','X','O'},
                              {'O','X','O','X','O','X'},
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'}};
        surround.solve(charArray);*/

        Map<Integer, Integer> hashMap = new HashMap<>();
        List<String> strings = new ArrayList<>();
        Set<String> strings1 = new HashSet<>();

        strings1.add("a");
        strings1.add("b");
        strings1.forEach(s -> {

        });
        strings.add("s");
        strings.addAll(strings1);
        strings.contains("s");
        Iterator<String> iterator = strings1.iterator();
        iterator.next();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());

        }

    }
}

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        HashSet<Integer> colHash = new HashSet<>();
        HashSet<Integer> posDiagonal = new HashSet<>();
        HashSet<Integer> negDiagonal = new HashSet<>();
        String[][] board = new String[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++){
                board[row][col] = ".";
            }
        }
        dfs(0, n, colHash, posDiagonal, negDiagonal, result, board);
        return result;
    }
    public static void dfs(int row,int n,HashSet<Integer> colHash, HashSet<Integer> posDiagonal,
        HashSet<Integer> negDiagonal, List<List<String>> result, String[][] board
    ) {
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (String[] r : board) {
                temp.add(String.join("", r));
            }
            result.add(temp);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (colHash.contains(col)|| posDiagonal.contains(row-col)|| negDiagonal.contains(row+col)) {
                continue;
            }
            colHash.add(col);
            posDiagonal.add(row-col);
            negDiagonal.add(row+col);
            board[row][col] = "Q";
            dfs(row+1, n, colHash, posDiagonal, negDiagonal, result, board);
            colHash.remove(col);
            posDiagonal.remove(row-col);
            negDiagonal.remove(row+col);
            board[row][col] = ".";
        }
    }
}

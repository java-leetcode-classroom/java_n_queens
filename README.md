# java_n_queens

The **n-queens** puzzle is the problem of placing `n` queens on an `n x n` chessboard such that no two queens attack each other.

Given an integer `n`, return *all distinct solutions to the **n-queens puzzle***. You may return the answer in **any order**.

Each solution contains a distinct board configuration of the n-queens' placement, where `'Q'` and `'.'` both indicate a queen and an empty space, respectively.

## Examples

**Example 1:**

![https://assets.leetcode.com/uploads/2020/11/13/queens.jpg](https://assets.leetcode.com/uploads/2020/11/13/queens.jpg)

```
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

```

**Example 2:**

```
Input: n = 1
Output: [["Q"]]

```

**Constraints:**

- `1 <= n <= 9`

## 解析

給定一個正整數 n , 要把 n 個西洋棋的皇后放到  n by n 的棋盤使得 n 個皇后不會相互攻擊

根據西洋棋規則，西洋棋的皇后可以走正反對角線還有上下左右直線。或者說是米字形範圍

這個限制就是用來檢查是否能夠放皇后的規則

要簡化的這個問題， 可以利用上面那個規則

因為每個皇后水平方向會互斥，代表每個列只能放一個皇后

可以簡化成對 n 列， 選擇一個 col 位置給 皇后放

檢查以下3個條件：

1. 該 col 是否已經有皇后選過
2. 該對角線是否已經有皇候選過
3. 該反對角線是否已經有皇候選過

如果都沒有則繼續往下選直到最後一個

否則換下一個位置繼續選

如下圖:

![](https://i.imgur.com/pMFyQkE.png)
![](https://i.imgur.com/uXNqWP9.png)

## 程式碼
```java
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

```
## 困難點

1. 理解窮舉的規則
2. 理解西洋棋皇后的規則

## Solve Point

- [x]  Understand what problem to solve
- [x]  Analysis Complexity
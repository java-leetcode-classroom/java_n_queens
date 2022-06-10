import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    final private Solution sol = new Solution();
    @Test
    void solveNQueensExample1() {
        assertEquals(List.of(List.of(".Q..","...Q","Q...","..Q."), List.of("..Q.","Q...","...Q",".Q..")), sol.solveNQueens(4));
    }
    @Test
    void solveNQueensExample2() {
        assertEquals(List.of(List.of("Q")), sol.solveNQueens(1));
    }
}
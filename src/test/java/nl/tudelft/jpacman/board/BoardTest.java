package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 * This is a test file for board building.
 */
public class BoardTest {

    /**
     * Tests board creation with a single valid square and verifies
     * that the board's invariant holds true after initialization.
     */
    @Test
    void testBoardWithValidSquare() {
        Square basicSquare = new BasicSquare();
        Square[][] basicGrid = new Square[1][1];
        basicGrid[0][0] = basicSquare;
        Board board = new Board(basicGrid);

        // Assert that the board's invariant is true
        assertThat(board.invariant()).isTrue();
    }

    /**
     * Tests the withinBorders method to check if the provided coordinates
     * fall within the bounds of the board's grid.
     */
    @Test
    void testWithinBorders() {
        Square basicSquare = new BasicSquare();
        Square[][] basicGrid = new Square[2][2];
        basicGrid[0][0] = basicSquare;
        basicGrid[0][1] = basicSquare;
        basicGrid[1][0] = basicSquare;
        basicGrid[1][1] = basicSquare;
        Board board = new Board(basicGrid);

        // Test for valid coordinates (within the grid)
        assertThat(board.withinBorders(0, 0)).isTrue();
        assertThat(board.withinBorders(1, 1)).isTrue();

        // Test for invalid coordinates (outside the grid)
        assertThat(board.withinBorders(2, 2)).isFalse();
        assertThat(board.withinBorders(-1, 0)).isFalse();
        assertThat(board.withinBorders(0, -1)).isFalse();
    }

    /**
     * Tests the board's behavior when accessing a square at specific coordinates,
     * ensuring that squareAt returns the expected square from the grid.
     */
    @Test
    void testBoardWithOneNullSquare() {
        Square basicSquare = new BasicSquare();
        Square[][] basicGrid = new Square[1][1];
        basicGrid[0][0] = basicSquare;
        Board board = new Board(basicGrid);

        // Assert that squareAt(0, 0) returns the correct square from grid
        assertThat(board.squareAt(0, 0)).isEqualTo(basicGrid[0][0]);
    }
}

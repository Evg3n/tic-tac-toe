package com.rubiconproject.tictactoe.condition;

import com.rubiconproject.tictactoe.Grid;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Yauheni Yudzitski <yauheni.yudzitski@gmail.com>
 */
public class NoMovesLeftConditionTest {
    private static final char X_MARK = 'X';
    private static final char O_MARK = 'O';

    private Grid grid;
    private Condition condition;

    @Before
    public void setUp() {
        grid = new Grid();
        condition = new NoMovesLeftCondition();
    }

    @Test
    public void isMetOnFullBoard() {
        grid.setCell(0, 0, X_MARK);
        grid.setCell(0, 1, O_MARK);
        grid.setCell(0, 2, X_MARK);

        grid.setCell(1, 0, O_MARK);
        grid.setCell(1, 1, X_MARK);
        grid.setCell(1, 2, O_MARK);

        grid.setCell(2, 0, X_MARK);
        grid.setCell(2, 1, X_MARK);
        grid.setCell(2, 2, O_MARK);

        Assert.assertTrue(condition.isMet(grid));
    }

    @Test
    public void isNotMetOnBoardWithFreeCells() {
        grid.setCell(0, 0, X_MARK);
        grid.setCell(0, 1, O_MARK);

        grid.setCell(1, 1, X_MARK);
        grid.setCell(1, 2, O_MARK);

        grid.setCell(2, 0, X_MARK);
        grid.setCell(2, 2, O_MARK);

        Assert.assertFalse(condition.isMet(grid));
    }

    @Test
    public void isNotMetOnEmptyBoard() {
        Assert.assertFalse(condition.isMet(grid));
    }
}
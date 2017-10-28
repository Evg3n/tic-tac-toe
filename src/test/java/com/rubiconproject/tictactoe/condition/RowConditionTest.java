package com.rubiconproject.tictactoe.condition;

import com.rubiconproject.tictactoe.Grid;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Yauheni Yudzitski <yauheni.yudzitski@gmail.com>
 */
public class RowConditionTest {
    private static final char X_MARK = 'X';
    private static final char O_MARK = 'O';

    private Grid grid;
    private RowCondition condition;

    @Before
    public void setUp() {
        grid = new Grid();
        condition = new RowCondition();
    }

    @Test
    public void isMetOnRowFilledWithOneMark() {
        grid.setCell(0, 0, X_MARK);
        grid.setCell(0, 1, X_MARK);
        grid.setCell(0, 2, O_MARK);

        grid.setCell(1, 0, X_MARK);
        grid.setCell(1, 1, X_MARK);
        grid.setCell(1, 2, X_MARK);

        Assert.assertTrue(condition.isMet(grid));
    }

    @Test
    public void isNotMetOnEmptyRow() {
        Assert.assertFalse(condition.isMet(grid));
    }

    @Test
    public void isNotMetOnRowFilledWithTwoMarks() {
        grid.setCell(1, 0, X_MARK);
        grid.setCell(1, 1, O_MARK);
        grid.setCell(1, 2, X_MARK);

        grid.setCell(0, 0, X_MARK);
        grid.setCell(0, 1, X_MARK);
        grid.setCell(0, 2, O_MARK);

        Assert.assertFalse(condition.isMet(grid));
    }
}
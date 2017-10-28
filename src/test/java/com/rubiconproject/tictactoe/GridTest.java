package com.rubiconproject.tictactoe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Yauheni Yudzitski <yauheni.yudzitski@gmail.com>
 */
public class GridTest {
    private static final char MARK = 'X';

    private Grid grid;

    @Before
    public void setUp() {
        grid = new Grid();
    }

    @Test
    public void setsCellWithValidCoordinates() {
        boolean result = grid.setCell(0, 0, MARK);

        Assert.assertTrue(result);
        Assert.assertTrue(grid.getGrid()[0][0] == MARK);
    }

    @Test
    public void doesNotSetCellWithRowNegativeCoordinate() {
        boolean result = grid.setCell(-1, 0, MARK);

        Assert.assertFalse(result);
    }

    @Test
    public void doesNotSetCellWithColumnNegativeCoordinate() {
        boolean result = grid.setCell(0, -1, MARK);

        Assert.assertFalse(result);
    }

    @Test
    public void doesNotSetCellWithRowCoordinateGreaterThanSize() {
        boolean result = grid.setCell(5, 0, MARK);

        Assert.assertFalse(result);
    }

    @Test
    public void doesNotSetCellWithColumnCoordinateGreaterThanSize() {
        boolean result = grid.setCell(0, 5, MARK);

        Assert.assertFalse(result);
    }

    @Test
    public void doesNotSetNotEmptyCell() {
        grid.setCell(0, 0, MARK);

        boolean result = grid.setCell(0, 0, MARK);

        Assert.assertFalse(result);
    }

    @Test
    public void freeCellsCountIsDecrementedAfterSuccess() {
        boolean result = grid.setCell(0, 0, MARK);

        Assert.assertTrue(result);
        Assert.assertTrue(grid.getFreeCellsCount() == 8);
    }

    @Test
    public void freeCellsCountIsNotDecrementedAfterFailure() {
        grid.setCell(0, 0, MARK);
        boolean result = grid.setCell(0, 0, MARK);

        Assert.assertFalse(result);
        Assert.assertTrue(grid.getFreeCellsCount() == 8);
    }

    @Test
    public void rowFreeCellsCountIsDecrementedAfterSuccess() {
        boolean result = grid.setCell(0, 0, MARK);

        Assert.assertTrue(result);
        Assert.assertTrue(grid.getRowFreeCellsCount()[0] == 2);
    }

    @Test
    public void rowFreeCellsCountIsNotDecrementedAfterFailure() {
        grid.setCell(0, 0, MARK);
        boolean result = grid.setCell(0, 0, MARK);

        Assert.assertFalse(result);
        Assert.assertTrue(grid.getRowFreeCellsCount()[0] == 2);
    }

    @Test
    public void columnFreeCellsCountIsDecrementedAfterSuccess() {
        boolean result = grid.setCell(0, 0, MARK);

        Assert.assertTrue(result);
        Assert.assertTrue(grid.getColumnFreeCellsCount()[0] == 2);
    }

    @Test
    public void columnFreeCellsCountIsNotDecrementedAfterFailure() {
        grid.setCell(0, 0, MARK);
        boolean result = grid.setCell(0, 0, MARK);

        Assert.assertFalse(result);
        Assert.assertTrue(grid.getColumnFreeCellsCount()[0] == 2);
    }
}
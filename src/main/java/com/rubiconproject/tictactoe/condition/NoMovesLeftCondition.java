package com.rubiconproject.tictactoe.condition;

import com.rubiconproject.tictactoe.Grid;

/**
 * Created by Yauheni Yudzitski <yauheni.yudzitski@gmail.com>
 * <p>
 * Checks if there are no more empty cells left in the grid.
 */
public class NoMovesLeftCondition implements Condition {
    @Override
    public boolean isMet(Grid grid) {
        return grid.getFreeCellsCount() == 0;
    }
}
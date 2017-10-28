package com.rubiconproject.tictactoe.condition;

import com.rubiconproject.tictactoe.Grid;

/**
 * Created by Yauheni Yudzitski <yauheni.yudzitski@gmail.com>
 */
public class NoMovesLeftCondition implements Condition {
    @Override
    public boolean isMet(Grid grid) {
        return grid.getFreeCellsCount() == 0;
    }
}
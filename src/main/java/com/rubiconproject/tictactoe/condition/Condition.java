package com.rubiconproject.tictactoe.condition;

import com.rubiconproject.tictactoe.Grid;

/**
 * Created by Yauheni Yudzitski <yauheni.yudzitski@gmail.com>
 * <p>
 * An interface for game over condition.
 */
public interface Condition {
    boolean isMet(Grid grid);
}
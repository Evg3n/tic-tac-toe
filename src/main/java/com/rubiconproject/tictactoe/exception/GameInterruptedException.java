package com.rubiconproject.tictactoe.exception;

/**
 * Created by Yauheni Yudzitski <yauheni.yudzitski@gmail.com>
 * <p>
 * Custom exception to throw in case of input end reached but no conditions met to stop the game.
 */
public class GameInterruptedException extends RuntimeException {
    public GameInterruptedException(Throwable cause) {
        super(cause);
    }
}
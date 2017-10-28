package com.rubiconproject.tictactoe.exception;

/**
 * Created by Yauheni Yudzitski <yauheni.yudzitski@gmail.com>
 */
public class GameInterruptedException extends RuntimeException {
    public GameInterruptedException(Throwable cause) {
        super(cause);
    }
}
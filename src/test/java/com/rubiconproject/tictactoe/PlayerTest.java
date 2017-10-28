package com.rubiconproject.tictactoe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by Yauheni Yudzitski <yauheni.yudzitski@gmail.com>
 */
public class PlayerTest {
    private Grid grid;
    private Player player;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        grid = new Grid();
        player = new Player('X');
    }

    @Test
    public void moveIsMadeOnValidInput() {
        Assert.assertTrue(player.makeMove(grid, new Scanner("0 0")));
    }

    @Test
    public void moveIsNotMadeOnStringInput() {
        Assert.assertFalse(player.makeMove(grid, new Scanner("a b")));
    }

    @Test
    public void throwsExceptionWhenInputEnds() {
        expectedException.expect(NoSuchElementException.class);
        expectedException.expectMessage("No more data in the input.");

        player.makeMove(grid, new Scanner("0"));
    }
}
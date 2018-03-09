package ru.job4j.chess;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Тест шахматной доски.
 *
 * @author Andrey Sumin
 * @since 09.03.2018
 */
public class TestChess {
    @Test
    public void testOfBishopWhenSrcXMoreThanDstXAndSrcYMoreThanDstY() {
        Board board = new Board();
        Cell src = new Cell(6, 5);
        Cell dst = new Cell(1, 0);
        Figure bishop = new Bishop(src);
        board.add(bishop);
        boolean result = board.move(src, dst);
        assertTrue(result);
    }

    @Test
    public void testOfBishopWhenSrcXMoreThanDstXAndSrcYLessThanDstY() {
        Board board = new Board();
        Cell src = new Cell(6, 3);
        Cell dst = new Cell(4, 5);
        Figure bishop = new Bishop(src);
        board.add(bishop);
        boolean result = board.move(src, dst);
        assertTrue(result);
    }

    @Test
    public void testOfBishopWhenSrcXLessThanDstXAndSrcYMoreThanDstY() {
        Board board = new Board();
        Cell src = new Cell(1, 3);
        Cell dst = new Cell(2, 2);
        Figure bishop = new Bishop(src);
        board.add(bishop);
        boolean result = board.move(src, dst);
        assertTrue(result);
    }

    @Test
    public void testOfBishopWhenSrcXLessThanDstXAndSrcYLessThanDstY() {
        Board board = new Board();
        Cell src = new Cell(1, 3);
        Cell dst = new Cell(3, 5);
        Figure bishop = new Bishop(src);
        board.add(bishop);
        boolean result = board.move(src, dst);
        assertTrue(result);
    }
}

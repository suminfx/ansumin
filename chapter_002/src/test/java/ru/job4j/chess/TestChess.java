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
    public void testOfBishopWhenSrcRightAndHigherThanDst() {
        Board board = new Board();
        Cell src = new Cell(7, 6);
        Cell dst = new Cell(1, 0);
        Figure bishop = new Bishop(src);
        board.add(bishop);
        boolean result = board.move(src, dst);
        assertTrue(result);
    }

    @Test
    public void testOfBishopWhenSrcRightAndLowerThanDst() {
        Board board = new Board();
        Cell src = new Cell(6, 3);
        Cell dst = new Cell(4, 5);
        Figure bishop = new Bishop(src);
        board.add(bishop);
        boolean result = board.move(src, dst);
        assertTrue(result);
    }

    @Test
    public void testOfBishopWhenSrcLeftAndHigherThenDst() {
        Board board = new Board();
        Cell src = new Cell(1, 3);
        Cell dst = new Cell(2, 2);
        Figure bishop = new Bishop(src);
        board.add(bishop);
        boolean result = board.move(src, dst);
        assertTrue(result);
    }

    @Test
    public void testOfBishopWhenSrcLeftAndLowerThanDst() {
        Board board = new Board();
        Cell src = new Cell(1, 3);
        Cell dst = new Cell(3, 5);
        Figure bishop = new Bishop(src);
        board.add(bishop);
        boolean result = board.move(src, dst);
        assertTrue(result);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void testOfBishopImpossibleMove() {
        Board board = new Board();
        Cell src = new Cell(0, 3);
        Cell dst = new Cell(3, 5);
        Figure bishop = new Bishop(src);
        board.add(bishop);
        board.move(src, dst);
    }

    @Test(expected = OccupiedWayException.class)
    public void testOfBishopOccupiedWay() {
        Board board = new Board();
        Cell src = new Cell(1, 3);
        Cell dst = new Cell(3, 5);
        Figure bishop = new Bishop(src);
        Figure bishop2 = new Bishop(new Cell(2, 4));
        board.add(bishop);
        board.add(bishop2);
        board.move(src, dst);
    }

    @Test
    public void testOfKingWhenWayClear() {
        Board board = new Board();
        Cell src = new Cell(2, 4);
        Cell dst = new Cell(3, 5);
        Figure king = new King(src);
        board.add(king);
        boolean result = board.move(src, dst);
        assertTrue(result);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void testOfKingImpossibleMove() {
        Board board = new Board();
        Cell src = new Cell(2, 4);
        Cell dst = new Cell(3, 6);
        Figure king = new King(src);
        board.add(king);
        board.move(src, dst);
    }

    @Test(expected = OccupiedWayException.class)
    public void testOfKingOccupiedWay() {
        Board board = new Board();
        Cell src = new Cell(2, 4);
        Cell dst = new Cell(3, 5);
        Figure king = new King(src);
        board.add(king);
        board.add(new Bishop(new Cell(3, 5)));
        board.move(src, dst);
    }

    @Test
    public void testOfRookWhenWayClear() {
        Board board = new Board();
        Cell src = new Cell(5, 4);
        Cell dst = new Cell(0, 4);
        Figure rook = new Rook(src);
        board.add(rook);
        boolean result = board.move(src, dst);
        assertTrue(result);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void testOfRookImpossibleMove() {
        Board board = new Board();
        Cell src = new Cell(5, 3);
        Cell dst = new Cell(0, 4);
        Figure rook = new Rook(src);
        board.add(rook);
        board.move(src, dst);
    }

    @Test(expected = OccupiedWayException.class)
    public void testOfRookOccupiedWay() {
        Board board = new Board();
        Cell src = new Cell(5, 4);
        Cell dst = new Cell(0, 4);
        Figure rook = new Rook(src);
        board.add(rook);
        board.add(new Bishop(new Cell(3, 4)));
        boolean result = board.move(src, dst);
        assertTrue(result);
    }

    @Test
    public void testOfQueenAsRookWhenWayClear() {
        Board board = new Board();
        Cell src = new Cell(5, 4);
        Cell dst = new Cell(0, 4);
        Figure queen = new Queen(src);
        board.add(queen);
        boolean result = board.move(src, dst);
        assertTrue(result);
    }

    @Test
    public void testOfQueenAsBishopWhenWayClear() {
        Board board = new Board();
        Cell src = new Cell(0, 0);
        Cell dst = new Cell(7, 7);
        Figure queen = new Queen(src);
        board.add(queen);
        boolean result = board.move(src, dst);
        assertTrue(result);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void testOfQueenImpossibleMove() {
        Board board = new Board();
        Cell src = new Cell(1, 5);
        Cell dst = new Cell(3, 6);
        Figure queen = new Queen(src);
        board.add(queen);
        boolean result = board.move(src, dst);
        assertTrue(result);
    }

    @Test(expected = OccupiedWayException.class)
    public void testOfQueenOccupiedWay() {
        Board board = new Board();
        Cell src = new Cell(1, 5);
        Cell dst = new Cell(4, 2);
        Figure queen = new Queen(src);
        board.add(queen);
        board.add(new Bishop(new Cell(3, 3)));
        boolean result = board.move(src, dst);
        assertTrue(result);
    }

    @Test
    public void testOfKnightWhenWayClear() {
        Board board = new Board();
        Cell src = new Cell(3, 3);
        Cell dst = new Cell(4, 1);
        Figure knight = new Knight(src);
        board.add(knight);
        boolean result = board.move(src, dst);
        assertTrue(result);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void testOfKnightImpossibleMove() {
        Board board = new Board();
        Cell src = new Cell(3, 3);
        Cell dst = new Cell(3, 5);
        Figure knight = new Knight(src);
        board.add(knight);
        board.move(src, dst);
    }

    @Test(expected = OccupiedWayException.class)
    public void testOfKnightOcuupiedWay() {
        Board board = new Board();
        Cell src = new Cell(3, 3);
        Cell dst = new Cell(4, 1);
        Figure knight = new Knight(src);
        board.add(knight);
        board.add(new Bishop(new Cell(4, 1)));
        board.move(src, dst);
    }

    @Test
    public void testOfPawnWhenWayClearOnOneCell() {
        Board board = new Board();
        Cell src = new Cell(2, 1);
        Cell dst = new Cell(2, 2);
        Figure pawn = new Pawn(src);
        board.add(pawn);
        boolean result = board.move(src, dst);
        assertTrue(result);
    }

    @Test
    public void testOfPawnWhenWayClearOnTwoCells() {
        Board board = new Board();
        Cell src = new Cell(3, 1);
        Cell dst = new Cell(3, 3);
        Figure pawn = new Pawn(src);
        board.add(pawn);
        boolean result = board.move(src, dst);
        assertTrue(result);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void testOfPawnImpossibleMoveOnOneCell() {
        Board board = new Board();
        Cell src = new Cell(4, 4);
        Cell dst = new Cell(4, 3);
        Figure pawn = new Pawn(src);
        board.add(pawn);
        board.move(src, dst);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void testOfPawnImpossibleMoveOnTwoCells() {
        Board board = new Board();
        Cell src = new Cell(2, 2);
        Cell dst = new Cell(2, 4);
        Figure pawn = new Pawn(src);
        board.add(pawn);
        board.move(src, dst);
    }

    @Test(expected = OccupiedWayException.class)
    public void testOfPawnOccupiedWayOnOneCell() {
        Board board = new Board();
        Cell src = new Cell(4, 4);
        Cell dst = new Cell(4, 5);
        Figure pawn = new Pawn(src);
        board.add(pawn);
        board.add(new Pawn(new Cell(4, 5)));
        board.move(src, dst);
    }

    @Test(expected = OccupiedWayException.class)
    public void testOfPawnOccupiedWayOnTwoCells() {
        Board board = new Board();
        Cell src = new Cell(4, 1);
        Cell dst = new Cell(4, 3);
        Figure pawn = new Pawn(src);
        board.add(pawn);
        board.add(new Pawn(new Cell(4, 2)));
        board.move(src, dst);
    }

    @Test(expected = FigureNotFoundException.class)
    public void testFigureNotFound() {
        Board board = new Board();
        Cell src = new Cell(4, 3);
        Cell dst = new Cell(6, 6);
        board.move(src, dst);
    }
}

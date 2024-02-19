package org.example;

public class GameEngine {

    public Board start(String board) {
        if ("tictactoe".equals(board)) {
            return new TicTacToeBoard();
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public void move(Cell cell, Player player, Board board, GameManager gameManager) {
        if (board instanceof TicTacToeBoard) {
            if (((TicTacToeBoard) board).getCell(cell) != null) {
                System.out.println("Invalid Move");
            }
            else {
                board.move(cell, player);
                ((TicTacToeBoard) board).print();
            }
            Player player2 = new Player();
            player2.setSymbol("0");
            gameManager.suggestMove((TicTacToeBoard) board, player2);
            ((TicTacToeBoard) board).print();
        }
    }
}

package org.example;

public class GameManager {

    public void suggestMove(TicTacToeBoard board, Player player) {
        int max = 3;
        int min = 0;
        int row = (int)(Math.random()*(max-min + min));
        int col = (int)(Math.random()*(max-min + min));
        Cell cell = new Cell(row, col);
        if (board.isValidMove(cell)) {
            board.move(cell, player);
        }
        else {
            suggestMove(board, player);
        }
    }

    public boolean isGameCompleted(TicTacToeBoard board) {
        //Check for win in row
        boolean rowResult = true;
        for (int i=0; i<3; i++) {
            String cell = board.getCell(new Cell(i,0));
            for (int j=0; j<3; j++) {
                if (cell == null) {
                    j++;
                    continue;
                }
                if (!cell.equals(board.getCell(new Cell(i,j)))) {
                    rowResult = false;
                    break;
                }
            }
        }

        //Check for win in column
        boolean colResult = true;
        for (int i=0; i<3; i++) {
            String cell = board.getCell(new Cell(0,i));
            for (int j=0; j<3; j++) {
                if (cell == null) {
                    i++;
                    continue;
                }
                if (!cell.equals(board.getCell(new Cell(j, i)))) {
                    colResult = false;
                    break;
                }
            }
        }

        //Check for diagonal win
        boolean diagonalResult = true;
        for (int i=0; i<3; i++) {
            String cell = board.getCell(new Cell(0,0));
            for (int j=0; j<3; j++) {
                if (cell == null) {
                    i++;
                    continue;
                }
                if ( (i+j)==2 && !cell.equals(board.getCell(new Cell(j,i)))) {
                    diagonalResult = false;
                    break;
                }
            }
        }

        //Check for reverse diagonal win
        boolean revdiagonalResult = true;
        for (int i=0; i<3; i++) {
            String cell = board.getCell(new Cell(0,2));
            for (int j=0; j<3; j++) {
                if (cell == null) {
                    i++;
                    continue;
                }
                if ( (i+j)==2 && !cell.equals(board.getCell(new Cell(j,i)))) {
                    revdiagonalResult = false;
                    break;
                }
            }
        }

        return rowResult || colResult || diagonalResult || revdiagonalResult;
    }
}

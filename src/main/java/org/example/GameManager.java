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
        boolean rowResult;
        String cell = null;
        for (int i=0; i<3; i++) {
            cell = board.getCell(new Cell(i,0));
            rowResult = cell!=null;
            for (int j=0; j<3; j++) {
                if (cell == null) {
                    break;
                }
                if (!cell.equals(board.getCell(new Cell(i,j)))) {
                    rowResult = false;
                    break;
                }
            }
            if (rowResult) {
                System.out.println("Game Over!! Winner is " + cell);
                return true;
            }
        }


        //Check for win in column
        boolean colResult;
        for (int i=0; i<3; i++) {
            cell = board.getCell(new Cell(0,i));
            colResult = cell!=null;
            for (int j=0; j<3; j++) {
                if (cell == null) {
                    break;
                }
                if (!cell.equals(board.getCell(new Cell(j, i)))) {
                    colResult = false;
                    break;
                }
            }
            if (colResult) {
                System.out.println("Game Over!! Winner is " + cell);
                return true;
            }
        }

        //Check for diagonal win
        boolean diagonalResult = false;
        for (int i=0; i<3; i++) {
            cell = board.getCell(new Cell(0,0));
            diagonalResult = cell!=null;
            for (int j=0; j<3; j++) {
                if (cell == null) {
                    break;
                }
                if ( (i==j) && !cell.equals(board.getCell(new Cell(i,j)))) {
                    diagonalResult = false;
                    break;
                }
            }
        }
        if (diagonalResult) {
            System.out.println("Game Over!! Winner is " + cell);
            return true;
        }

        //Check for reverse diagonal win
        boolean revdiagonalResult;
        for (int i=0; i<3; i++) {
            cell = board.getCell(new Cell(0,2));
            revdiagonalResult = cell!=null;
            for (int j=0; j<3; j++) {
                if (cell == null) {
                    break;
                }
                if ( (i+j)==2 && !cell.equals(board.getCell(new Cell(i,j)))) {
                    revdiagonalResult = false;
                    break;
                }
            }
            if(!revdiagonalResult) return false;
        }
        System.out.println("Game Over revdiag!! Winner is " + cell);
        return true;
    }
}

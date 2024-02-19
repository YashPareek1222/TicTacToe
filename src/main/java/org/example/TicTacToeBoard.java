package org.example;

public class TicTacToeBoard extends Board {

    private String[][] cells = new String[3][3];

    @Override
    public void move(Cell cell, Player player) {
        cells[cell.getRow()][cell.getCol()] = player.symbol;
    }

    public boolean isValidMove(Cell cell) {
        return cells[cell.getRow()][cell.getCol()] == null;
    }

    public String getCell (Cell cell) {
        return cells[cell.row][cell.col];
    }

    public void setCells(String[][] cells) {
        this.cells = cells;
    }

    public void print() {
        System.out.println("Board = ");
                for (int i=0; i<3; i++) {
                    for (int j=0; j<3; j++) {
                        if(cells[i][j] == null) {
                            System.out.print("_");
                        }
                        else {
                            System.out.print(cells[i][j]);
                        }
                    }
                    System.out.println();
                }
    }
}

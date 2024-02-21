package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        GameManager gameManager = new GameManager();
        Board tictactoe = gameEngine.start("tictactoe");
        Scanner sc = new Scanner(System.in);

        System.out.println("Game has started");
        while (!gameManager.isGameCompleted((TicTacToeBoard) tictactoe)) {
            System.out.print("Row = ");
            int row = sc.nextInt();
            System.out.print("Col = ");
            int col = sc.nextInt();
            Cell cell = new Cell(row,col);
            Player player1 = new Player();
            player1.setSymbol("X");
            gameEngine.move(cell, player1, tictactoe, gameManager);
        }
    }
}

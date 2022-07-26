package dev.bdon.game.tictactoe;

import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(String name, String symbol) {
        super(name, symbol);
    }

    @Override
    public void takeTurn(TicTacToe game) {
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(getName() + ", please enter a row and column: ");
                String line = in.nextLine();
                String[] split;
                if (line.contains(",")) {
                    split = line.split(",");
                }
                else {
                    split = line.split(" ");
                }
                game.placePiece(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                break;
            }
            catch (IndexOutOfBoundsException ex) {
                System.out.println("Row and/or column is out of range");
            }
            catch (IllegalArgumentException ex) {
                System.out.println("Space is already occupied");
            }
            catch (Exception ex) {
                System.out.println("Cannot read input");
            }
        }
    }
}

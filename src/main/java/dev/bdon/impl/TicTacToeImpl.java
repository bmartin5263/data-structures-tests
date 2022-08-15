package dev.bdon.impl;

import dev.bdon.game.tictactoe.Player;
import dev.bdon.game.tictactoe.TicTacToe;

import java.util.Arrays;

public class TicTacToeImpl implements TicTacToe {

    private final Player[] players = new Player[2];
    private final String[] board = new String[9];

    private int turn = 0;
    private Player winner = null;

    private static final int[][] TRIADS = new int[][] {
        {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows
        {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // cols
        {0, 4, 8}, {2, 4, 6} // diags
    };

    @Override
    public void newGame(Player[] players) {
        this.players[0] = players[0];
        this.players[1] = players[1];
        Arrays.fill(board, "");
    }

    @Override
    public void placePiece(int row, int col) {
        if (isGameOver()) {
            throw new IllegalStateException();
        }
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            throw new IllegalArgumentException();
        }

        int index = 3 * row + col;
        if (!board[index].equals("")) {
            throw new IllegalArgumentException();
        }
        board[index] = currentPlayer().getSymbol();

        checkWinner();
        turn = (turn + 1) % 2;
    }

    private void checkWinner() {
        for (int[] triad : TRIADS) {
            if (!board[triad[0]].equals("") && board[triad[0]].equals(board[triad[1]]) && board[triad[1]].equals(board[triad[2]])) {
                winner = currentPlayer();
                return;
            }
        }
    }

    @Override
    public String getPiece(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            throw new IllegalArgumentException();
        }
        int index = 3 * row + col;
        return board[index];
    }

    @Override
    public boolean isGameOver() {
        return winner != null;
    }

    @Override
    public Player currentPlayer() {
        return players[turn];
    }

    @Override
    public Player getWinner() {
        if (winner == null) {
            throw new IllegalStateException("No winner yet.");
        }
        return winner;
    }

    @Override
    public String toString() {
        return board[0] + " | " + board[1] + " | " + board[2] + "\n" +
                board[3] + " | " + board[4] + " | " + board[5] + "\n" +
                board[6] + " | " + board[7] + " | " + board[8];
    }
}

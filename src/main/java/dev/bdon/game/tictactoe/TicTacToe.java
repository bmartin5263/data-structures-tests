package dev.bdon.game.tictactoe;

public interface TicTacToe {

    /**
     * Initializes a new game with the given players.
     *
     * @param players - an array with exactly 2 non-null player objects
     */
    void newGame(Player[] players);

    /**
     * Place a piece at the given location on the board.
     *
     * @param row - the board's row, 0-indexed
     * @param col - the board's column, 0-indexed
     *
     * @throws IndexOutOfBoundsException if row < 0 || row >= 3 || col < 0 || col >= 3
     * @throws IllegalArgumentException if the spot at row & col is occupied
     * @throws IllegalStateException if the game is over
     */
    void placePiece(int row, int col);

    /**
     * Returns the piece at the given location, or an empty string if there isn't a piece there
     *
     * @param row - the board's row, 0-indexed
     * @param col - the board's column, 0-indexed
     *
     * @throws IndexOutOfBoundsException if row < 0 || row >= 3 || col < 0 || col >= 3
     */
    String getPiece(int row, int col);

    /**
     * Returns true if the game is finished, false if otherwise
     */
    boolean isGameOver();

    /**
     * Returns the player whose turn it currently is
     */
    Player currentPlayer();

    /**
     * Returns the player who won the game, or null if it was a draw
     *
     * @throws IllegalStateException if the game is not yet over
     */
    Player getWinner();
}

package dev.bdon.game.tictactoe;

public abstract class Player {
    private final String name;
    private final String symbol;

    Player(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    abstract void takeTurn(TicTacToe game);
}

package dev.bdon.game.tictactoe;

import dev.bdon.impl.TicTacToeImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    private static TicTacToe newGame(Player[] players) {
        TicTacToe game = new TicTacToeImpl();
        game.newGame(players);
        return game;
    }

    @Test
    void should_play_a_game_the_results_in_player_1_winning() {
        Player[] players = new Player[] {
                new HumanPlayer("Brandon", "X"),
                new HumanPlayer("Mark", "O"),
        };

        TicTacToe game = newGame(players);
        assert !game.isGameOver();
        assert boardEquals(game, new String[][]{
                {"", "", ""},
                {"", "", ""},
                {"", "", ""}
        });
        assertThrows(IllegalStateException.class, game::getWinner);

        game.placePiece(1, 1);
        assert !game.isGameOver();
        assert boardEquals(game, new String[][]{
                {"", "", ""},
                {"", "X", ""},
                {"", "", ""}
        });
        assertThrows(IllegalStateException.class, game::getWinner);

        game.placePiece(0, 1);
        assert !game.isGameOver();
        assert boardEquals(game, new String[][]{
                {"", "O", ""},
                {"", "X", ""},
                {"", "", ""}
        });
        assertThrows(IllegalStateException.class, game::getWinner);

        game.placePiece(2, 0);
        assert !game.isGameOver();
        assert boardEquals(game, new String[][]{
                {"", "O", ""},
                {"", "X", ""},
                {"X", "", ""}
        });
        assertThrows(IllegalStateException.class, game::getWinner);

        game.placePiece(0, 2);
        assert !game.isGameOver();
        assert boardEquals(game, new String[][]{
                {"", "O", "O"},
                {"", "X", ""},
                {"X", "", ""}
        });
        assertThrows(IllegalStateException.class, game::getWinner);

        game.placePiece(0, 0);
        assert !game.isGameOver();
        assert boardEquals(game, new String[][]{
                {"X", "O", "O"},
                {"", "X", ""},
                {"X", "", ""}
        });
        assertThrows(IllegalStateException.class, game::getWinner);

        game.placePiece(1, 0);
        assert !game.isGameOver();
        assert boardEquals(game, new String[][]{
                {"X", "O", "O"},
                {"O", "X", ""},
                {"X", "", ""}
        });
        assertThrows(IllegalStateException.class, game::getWinner);

        game.placePiece(2, 2);
        assert game.isGameOver();
        assert boardEquals(game, new String[][]{
                {"X", "O", "O"},
                {"O", "X", ""},
                {"X", "", "X"}
        });
        assert game.getWinner() == players[0];
    }

    @Test
    void should_play_a_game_the_results_in_player_2_winning() {

    }

    @Test
    void should_play_a_game_the_results_in_a_draw() {

    }

    public static void main(String[] args) {
        new TicTacToeTest().should_play_an_interactive_game_with_two_humans();
    }

    void should_play_an_interactive_game_with_two_humans() {
        Player[] players = new Player[] {
                new HumanPlayer("Brandon", "X"),
                new HumanPlayer("Mark", "O"),
        };
        TicTacToe game = newGame(players);

        while (!game.isGameOver()) {
            System.out.println(game);
            Player player = game.currentPlayer();
            player.takeTurn(game);
        }
    }

    void should_play_an_interactive_game_with_a_human_and_ai() {
        Player[] players = new Player[] {
                new HumanPlayer("Human", "X"),
                new AIPlayer("Skynet", "O"),
        };
        TicTacToe game = newGame(players);

        while (!game.isGameOver()) {
            Player player = game.currentPlayer();
            player.takeTurn(game);
        }
    }

    private static boolean boardEquals(TicTacToe game, String[][] arr) {
        return Objects.equals(game.getPiece(0, 0), arr[0][0])
                && Objects.equals(game.getPiece(1, 0), arr[1][0])
                && Objects.equals(game.getPiece(2, 0), arr[2][0])
                && Objects.equals(game.getPiece(0, 1), arr[0][1])
                && Objects.equals(game.getPiece(1, 1), arr[1][1])
                && Objects.equals(game.getPiece(2, 1), arr[2][1])
                && Objects.equals(game.getPiece(0, 2), arr[0][2])
                && Objects.equals(game.getPiece(1, 2), arr[1][2])
                && Objects.equals(game.getPiece(2, 2), arr[2][2]);
    }
}
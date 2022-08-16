package dev.bdon.game.tictactoe;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    private static TicTacToe newGame(Player[] players) {
        TicTacToe game = null;
        game.newGame(players);
        return game;
    }

    @Test
    void place_piece_should_validate_inputs() {
        Player[] players = new Player[] {
                new HumanPlayer("Brandon", "X"),
                new HumanPlayer("Mark", "O"),
        };

        TicTacToe game = newGame(players);
        assert !game.isGameOver();
        assertBoardEquals(game, new String[][]{
                {"", "", ""},
                {"", "", ""},
                {"", "", ""}
        });

        game.placePiece(1, 0);
        assertBoardEquals(game, new String[][]{
                {"", "", ""},
                {"X", "", ""},
                {"", "", ""}
        });

        assertThrows(IndexOutOfBoundsException.class, () -> game.placePiece(-1, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> game.placePiece(4, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> game.placePiece(0, -1));
        assertThrows(IndexOutOfBoundsException.class, () -> game.placePiece(0, 4));
        assertThrows(IllegalArgumentException.class, () -> game.placePiece(1, 0));

        game.placePiece(0, 0);
        game.placePiece(1, 1);
        game.placePiece(0, 1);
        game.placePiece(1, 2);
        assertBoardEquals(game, new String[][]{
                {"O", "O", ""},
                {"X", "X", "X"},
                {"", "", ""}
        });
        assert game.isGameOver();
        assert game.getWinner() == players[0];
        assertThrows(IllegalStateException.class, () -> game.placePiece(2, 0));
    }

    @Test
    void should_play_a_game_that_results_in_player_1_winning() {
        Player[] players = new Player[] {
                new HumanPlayer("Brandon", "X"),
                new HumanPlayer("Mark", "O"),
        };

        TicTacToe game = newGame(players);
        assert !game.isGameOver();
        assertBoardEquals(game, new String[][]{
                {"", "", ""},
                {"", "", ""},
                {"", "", ""}
        });
        assertThrows(IllegalStateException.class, game::getWinner);

        game.placePiece(1, 1);
        assert !game.isGameOver();
        assertBoardEquals(game, new String[][]{
                {"", "", ""},
                {"", "X", ""},
                {"", "", ""}
        });
        assertThrows(IllegalStateException.class, game::getWinner);

        game.placePiece(0, 1);
        assert !game.isGameOver();
        assertBoardEquals(game, new String[][]{
                {"", "O", ""},
                {"", "X", ""},
                {"", "", ""}
        });
        assertThrows(IllegalStateException.class, game::getWinner);

        game.placePiece(2, 0);
        assert !game.isGameOver();
        assertBoardEquals(game, new String[][]{
                {"", "O", ""},
                {"", "X", ""},
                {"X", "", ""}
        });
        assertThrows(IllegalStateException.class, game::getWinner);

        game.placePiece(0, 2);
        assert !game.isGameOver();
        assertBoardEquals(game, new String[][]{
                {"", "O", "O"},
                {"", "X", ""},
                {"X", "", ""}
        });
        assertThrows(IllegalStateException.class, game::getWinner);

        game.placePiece(0, 0);
        assert !game.isGameOver();
        assertBoardEquals(game, new String[][]{
                {"X", "O", "O"},
                {"", "X", ""},
                {"X", "", ""}
        });
        assertThrows(IllegalStateException.class, game::getWinner);

        game.placePiece(1, 0);
        assert !game.isGameOver();
        assertBoardEquals(game, new String[][]{
                {"X", "O", "O"},
                {"O", "X", ""},
                {"X", "", ""}
        });
        assertThrows(IllegalStateException.class, game::getWinner);

        game.placePiece(2, 2);
        assert game.isGameOver();
        assertBoardEquals(game, new String[][]{
                {"X", "O", "O"},
                {"O", "X", ""},
                {"X", "", "X"}
        });
        assert game.getWinner() == players[0];
    }

    @Test
    void should_play_a_game_that_results_in_a_draw() {
        Player[] players = new Player[] {
                new HumanPlayer("Brandon", "X"),
                new HumanPlayer("Mark", "O"),
        };

        TicTacToe game = newGame(players);
        assert !game.isGameOver();
        assertBoardEquals(game, new String[][]{
                {"", "", ""},
                {"", "", ""},
                {"", "", ""}
        });
        assertThrows(IllegalStateException.class, game::getWinner);

        game.placePiece(1, 0);
        assert !game.isGameOver();
        assertBoardEquals(game, new String[][]{
                {"", "", ""},
                {"X", "", ""},
                {"", "", ""}
        });
        assertThrows(IllegalStateException.class, game::getWinner);

        game.placePiece(1, 1);
        assert !game.isGameOver();
        assertBoardEquals(game, new String[][]{
                {"", "", ""},
                {"X", "O", ""},
                {"", "", ""}
        });
        assertThrows(IllegalStateException.class, game::getWinner);

        game.placePiece(0, 0);
        assert !game.isGameOver();
        assertBoardEquals(game, new String[][]{
                {"X", "", ""},
                {"X", "O", ""},
                {"", "", ""}
        });
        assertThrows(IllegalStateException.class, game::getWinner);

        game.placePiece(2, 0);
        assert !game.isGameOver();
        assertBoardEquals(game, new String[][]{
                {"X", "", ""},
                {"X", "O", ""},
                {"O", "", ""}
        });
        assertThrows(IllegalStateException.class, game::getWinner);

        game.placePiece(0, 2);
        assert !game.isGameOver();
        assertBoardEquals(game, new String[][]{
                {"X", "", "X"},
                {"X", "O", ""},
                {"O", "", ""}
        });
        assertThrows(IllegalStateException.class, game::getWinner);

        game.placePiece(0, 1);
        assert !game.isGameOver();
        assertBoardEquals(game, new String[][]{
                {"X", "O", "X"},
                {"X", "O", ""},
                {"O", "", ""}
        });
        assertThrows(IllegalStateException.class, game::getWinner);

        game.placePiece(2, 1);
        assert !game.isGameOver();
        assertBoardEquals(game, new String[][]{
                {"X", "O", "X"},
                {"X", "O", ""},
                {"O", "X", ""}
        });
        assertThrows(IllegalStateException.class, game::getWinner);

        game.placePiece(1, 2);
        assert !game.isGameOver();
        assertBoardEquals(game, new String[][]{
                {"X", "O", "X"},
                {"X", "O", "O"},
                {"O", "X", ""}
        });
        assertThrows(IllegalStateException.class, game::getWinner);

        game.placePiece(2, 2);
        assert game.isGameOver();
        assertBoardEquals(game, new String[][]{
                {"X", "O", "X"},
                {"X", "O", "O"},
                {"O", "X", "X"}
        });
        assert game.getWinner() == null;
    }

    @Test
    void should_play_a_game_that_results_in_player_2_winning() {
        Player[] players = new Player[] {
                new HumanPlayer("Brandon", "X"),
                new HumanPlayer("Mark", "O"),
        };

        TicTacToe game = newGame(players);
        assert !game.isGameOver();
        assertBoardEquals(game, new String[][]{
                {"", "", ""},
                {"", "", ""},
                {"", "", ""}
        });
        assertThrows(IllegalStateException.class, game::getWinner);

        game.placePiece(0, 0);
        assert !game.isGameOver();
        assertBoardEquals(game, new String[][]{
                {"X", "", ""},
                {"", "", ""},
                {"", "", ""}
        });
        assertThrows(IllegalStateException.class, game::getWinner);

        game.placePiece(1, 1);
        assert !game.isGameOver();
        assertBoardEquals(game, new String[][]{
                {"X", "", ""},
                {"", "O", ""},
                {"", "", ""}
        });
        assertThrows(IllegalStateException.class, game::getWinner);

        game.placePiece(0, 1);
        assert !game.isGameOver();
        assertBoardEquals(game, new String[][]{
                {"X", "X", ""},
                {"", "O", ""},
                {"", "", ""}
        });
        assertThrows(IllegalStateException.class, game::getWinner);

        game.placePiece(0, 2);
        assert !game.isGameOver();
        assertBoardEquals(game, new String[][]{
                {"X", "X", "O"},
                {"", "O", ""},
                {"", "", ""}
        });
        assertThrows(IllegalStateException.class, game::getWinner);

        game.placePiece(1, 0);
        assert !game.isGameOver();
        assertBoardEquals(game, new String[][]{
                {"X", "X", "O"},
                {"X", "O", ""},
                {"", "", ""}
        });
        assertThrows(IllegalStateException.class, game::getWinner);

        game.placePiece(2, 0);
        assert game.isGameOver();
        assertBoardEquals(game, new String[][]{
                {"X", "X", "O"},
                {"X", "O", ""},
                {"O", "", ""}
        });
        assert game.getWinner() == players[1];
    }

//    public static void main(String[] args) {
//        new TicTacToeTest().should_play_an_interactive_game_with_two_humans();
//    }

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

    private void assertBoardEquals(TicTacToe game, String[][] expected) {
        String[][] actual = new String[3][3];
        actual[0][0] = game.getPiece(0, 0);
        actual[0][1] = game.getPiece(0, 1);
        actual[0][2] = game.getPiece(0, 2);
        actual[1][0] = game.getPiece(1, 0);
        actual[1][1] = game.getPiece(1, 1);
        actual[1][2] = game.getPiece(1, 2);
        actual[2][0] = game.getPiece(2, 0);
        actual[2][1] = game.getPiece(2, 1);
        actual[2][2] = game.getPiece(2, 2);

        try {
            assertArrayEquals(actual, expected);
        }
        catch (AssertionError err) {
            System.err.println("Expected:");
            System.err.println(Arrays.toString(expected[0]));
            System.err.println(Arrays.toString(expected[1]));
            System.err.println(Arrays.toString(expected[2]));
            System.err.println("Actual:");
            System.err.println(Arrays.toString(actual[0]));
            System.err.println(Arrays.toString(actual[1]));
            System.err.println(Arrays.toString(actual[2]));
            throw err;
        }
    }
}
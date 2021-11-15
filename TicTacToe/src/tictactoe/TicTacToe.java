package tictactoe;

import java.util.Scanner;
import java.util.Arrays;

public class TicTacToe {
 
    public static void main(String[]  args) {
        Game game = new Game();

        Scanner scanner = new Scanner(System.in);

        System.out.println(game.getBoard());

        while (!game.isEnded()) {
            System.out.println(String.format("%s's turn:", game.getActualPlayerSymbol()));

            int x = scanner.nextInt();
            int y = scanner.nextInt();

            try {
                game.nextMove(x, y);
            } catch (NotEmptyError e) {
                System.out.println("Wrong move, cell not empty!");
            } catch (IllegalArgumentException e) {
                System.out.println("Incorrect move!");
            }

            System.out.println(game.getBoard());
        }
    }
}

class Game {
    private static final int BOARD_SIZE = 3;
    private static final String BOARD_TEMPLATE = "   1 2 3 \n" +
            "  ┌─┬─┬─┐\n" +
            "1 │%s│%s│%s│\n" +
            "  ├─┼─┼─┤\n" +
            "2 │%s│%s│%s│\n" +
            "  ├─┼─┼─┤\n" +
            "3 │%s│%s│%s│\n" +
            "  └─┴─┴─┘\n";

    private Symbol[] board = new Symbol[BOARD_SIZE * BOARD_SIZE];
    private boolean isXTurn = true;

    public Game() {
        Arrays.fill(board, Symbol.EMPTY);
    }

    public String getBoard() {
        return String.format(BOARD_TEMPLATE, (Object[]) board);
    }

    public void nextMove(int x, int y) {
        if(isXTurn) {
            putX(x, y);
        } else {
            putO(x, y);
        }

        isXTurn = !isXTurn;
    }

    public void putX(int x, int y) {
        putSymbol(x, y, Symbol.X);
    }

    public void putO(int x, int y) {
        putSymbol(x, y, Symbol.O);
    }

    private void putSymbol(int x, int y, Symbol symbol) {
        if(x < 1 || x > BOARD_SIZE || y < 1 || y > BOARD_SIZE) {
            throw new IllegalArgumentException();
        }

        int i = (y - 1) * BOARD_SIZE + (x - 1);

        if(board[i] != Symbol.EMPTY) {
            throw new NotEmptyError();
        }

        board[i] = symbol;
    }

    public boolean isEnded() {
        for (Symbol symbol : board) {
            if(symbol == Symbol.EMPTY) {
                return false;
            }
        }

        return true;
    }

    public Symbol getActualPlayerSymbol() {
        return isXTurn ? Symbol.X : Symbol.O;
    }
}

enum Symbol {
    X('X'),
    O('O'),
    EMPTY(' ');

    private Character c;

    Symbol(Character c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return String.valueOf(c);
    }
}

class NotEmptyError extends RuntimeException {
}
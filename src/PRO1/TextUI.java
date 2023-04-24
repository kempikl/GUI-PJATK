package PRO1;

import java.util.Scanner;

public class TextUI implements GameObserver {
    private final Game game;

    public TextUI(Game game) {
        this.game = game;
    }

    public void start() {
        System.out.println("\nGra w szachy rozpoczęta!");
        gameChanged(game.getCurrentPlayerName());
    }

    public int[] getMove() {
        System.out.println("Wprowadź swój ruch (np. e2 e4):");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] parts = input.split(" ");

        int[] move = new int[4];

        try {
            move[0] = 8 - Integer.parseInt(parts[0].substring(1));
            move[1] = parts[0].charAt(0) - 'a';
            move[2] = 8 - Integer.parseInt(parts[1].substring(1));
            move[3] = parts[1].charAt(0) - 'a';
        } catch (NumberFormatException | StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Błędny format ruchu. Spróbuj ponownie.");
            return getMove();
        }

        return move;
    }

    public void makeTie() {

    }

    @Override
    public void onCheck() {
        System.out.println("Szach!");
    }

    @Override
    public void onCheckmate(String winnerName) {
        System.out.println("Szach-mat! Gracz " + winnerName + " wygrywa!");
        System.exit(0);
    }

    @Override
    public void gameChanged(String currentPlayerName) {
        System.out.println(game.getBoard());
        System.out.println("Tura gracza " + currentPlayerName + ".");
        int[] move = getMove();
        game.play(move);
    }
}


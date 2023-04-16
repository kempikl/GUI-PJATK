package PRO1;

import java.util.Scanner;

public class TextUI implements IBoardObserver {
    private Game game;

    public TextUI(Game game) {
        this.game = game;
    }

    public void start() {
        System.out.println("Gra w szachy rozpoczęta!");
        while (true) {
            System.out.println(game.getBoard());
            System.out.println("Tura gracza " + game.getCurrentPlayerName() + ".");
            int[] move = getMove();
            game.play(move);
        }
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
        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            System.out.println("Błędny format ruchu. Spróbuj ponownie.");
            return getMove();
        }

        return move;
    }

    @Override
    public void onMove(int sourceRow, int sourceCol, int targetRow, int targetCol) {

    }

    @Override
    public void onCheck(int kingRow, int kingCol) {
        System.out.println("Szach!");
    }

    @Override
    public void onCheckmate(int kingRow, int kingCol) {

    }

    @Override
    public void onBoardChanged(Board board) {

    }
}


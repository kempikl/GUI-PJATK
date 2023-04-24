package PRO1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj nazwę gracza:\ngracz 1> ");
        String player1Name = scanner.next();
        System.out.print("Podaj nazwę gracza:\ngracz 2> ");
        String player2Name = scanner.next();

        Board board = new Board();
        Game game = new Game(board, player1Name, player2Name);
        TextUI textUI = new TextUI(game);

        game.setObserver(textUI);

        textUI.start();
    }
}

package PRO3;

import javax.swing.*;

public class UserNameDialog {
    private final int score;

    public UserNameDialog(int score) {
        this.score = score;
    }

    public String getUserName() {
        return JOptionPane.showInputDialog(
                null,
                "Zdobyłeś " + score + " pkt.\n"
                        + "Podaj swoją nazwę użytkownika:",
                "Koniec gry",
                JOptionPane.PLAIN_MESSAGE
        );
    }
}

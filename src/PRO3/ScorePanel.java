package PRO3;

import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel implements GameEventListener {
    private int score;

    public ScorePanel() {
        GameEvent.addListener(this);
        this.score = 0;
        setPreferredSize(new Dimension(getWidth(), 30));
        setBackground(new Color(230, 230, 234));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Default", Font.BOLD, 14));
        String message = "Punkty: " + score;

        FontMetrics metrics = g.getFontMetrics(g.getFont());
        int x = (this.getWidth() - metrics.stringWidth(message)) / 2;
        int y = ((this.getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();

        g.drawString(message, x, y);
    }


    @Override
    public void handleGameTickEvent(GameTickEvent event) {

    }

    @Override
    public void handleSnakeCollisionEvent(SnakeCollisionEvent event) {

    }

    @Override
    public void handleFoodEatenEvent(FoodEatenEvent event) {
    }

    @Override
    public void handleScoreChangeEvent(ScoreChangeEvent event) {
        this.score = event.getScore();
        this.repaint();
    }
}

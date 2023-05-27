package CW6.ZAD1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Main {
    static class MyPanel extends JPanel {
        private boolean fill = false;
        private boolean drawCircle = true;
        private Color color = Color.RED;
        private final Random random = new Random();

        public MyPanel() {
            setPreferredSize(new Dimension(500, 500));
            setFocusable(true);
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    fill = e.isShiftDown();
                    int diameter = random.nextInt(31) + 20;
                    Graphics2D g2d = (Graphics2D) getGraphics();
                    g2d.setColor(color);
                    if(drawCircle) {
                        if(fill)
                            g2d.fillOval(e.getX() - diameter / 2, e.getY() - diameter / 2, diameter, diameter);
                        else
                            g2d.drawOval(e.getX() - diameter / 2, e.getY() - diameter / 2, diameter, diameter);
                    } else {
                        if(fill)
                            g2d.fillRect(e.getX() - diameter / 2, e.getY() - diameter / 2, diameter, diameter);
                        else
                            g2d.drawRect(e.getX() - diameter / 2, e.getY() - diameter / 2, diameter, diameter);
                    }
                }
            });

            addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    switch (e.getKeyChar()) {
                        case ' ' -> drawCircle = !drawCircle;
                        case 'r' -> color = Color.RED;
                        case 'g' -> color = Color.GREEN;
                        case 'o' -> color = Color.ORANGE;
                    }
                }
            });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Koła i kwadraty");
            MyPanel panel = new MyPanel();
            frame.add(panel);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            panel.requestFocusInWindow();
        });
    }
}


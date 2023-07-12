package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MovingRectangle extends JPanel {

    private int x, y; // Coordinates of the top-left corner of the rectangle
    private final int rectangleWidth = 100;
    private final int rectangleHeight = 50;

    public MovingRectangle() {
        x = 0;
        y = 200;

        setFocusable(true); // Enable keyboard focus on the panel

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                int moveDistance = 10; // Distance to move the rectangle

                // Move the rectangle based on the arrow keys
                if (keyCode == KeyEvent.VK_LEFT) {
                    x -= moveDistance;
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    x += moveDistance;
                } else if (keyCode == KeyEvent.VK_UP) {
                    y -= moveDistance;
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    y += moveDistance;
                }

                repaint(); // Request a repaint to update the rectangle's position
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(x, y, rectangleWidth, rectangleHeight); // Draw the rectangle
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 400); // Set the preferred size of the panel
    }
}

package lesson1;

import java.awt.*;
import java.util.Random;

public class Ball extends Sprite{

    private float vx;
    private float vy;
    private static Random rnd = new Random();
    private final Color color;

    Ball() {
        halfHeight = 20 + (float)(Math.random()*50f);
        color = new Color(rnd.nextInt());
        halfWidth = halfHeight;
        vx = 150f + (float)(Math.random() * 200f);
        vy = 150f + (float)(Math.random() * 200f);
    }

    @Override
    void update(GameCanvas gameCanvas, float deltaTime) {
        x += vx * deltaTime;
        y += vy * deltaTime;
        if (getLeft() < gameCanvas.getLeft()) {
            setLeft((gameCanvas.getLeft()));
            vx = -vx;
        }

        if (getRight() > gameCanvas.getRight()) {
            setRight((gameCanvas.getRight()));
            vx = -vx;
        }

        if (getTop() < gameCanvas.getTop()) {
            setTop((gameCanvas.getTop()));
            vy = -vy;
        }

        if (getBottom() > gameCanvas.getBottom()) {
            setBottom((gameCanvas.getBottom()));
            vy = -vy;
        }

    }

    @Override
    void render(GameCanvas gameCanvas, Graphics g) {
        g.setColor(color);
        g.fillOval((int)(getLeft()), (int)(getTop()), (int)(getWidth()), (int)(getHeight()));
    }
}
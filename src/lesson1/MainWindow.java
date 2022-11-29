package lesson1;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public static final int POS_X = 600;
    public static final int POS_Y = 200;
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });
    }

    MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(POS_X, POS_Y);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        setTitle("Circles");
        GameCanvas gameCanvas = new GameCanvas(this);
        add(gameCanvas);
        initGame();
        setVisible(true);
    }

    Sprite[] sprites = new Sprite[10];

    private void initGame() {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }

    void onDrawFrame(GameCanvas gameCanvas, Graphics g, float deltaTime) {
        update(gameCanvas, deltaTime);
        render(gameCanvas, g);
    }

    private void update(GameCanvas gameCanvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(gameCanvas, deltaTime);
        }
    }

    private void render(GameCanvas gameCanvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(gameCanvas, g);
        }
    }

}

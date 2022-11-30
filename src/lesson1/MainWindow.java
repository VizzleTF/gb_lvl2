package lesson1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow extends JFrame {
    public static final int POS_X = 600;
    public static final int POS_Y = 200;
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;
    private static int countBalls = 10;

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
        {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        increaseBalls(new Ball());
                    } else if (e.getButton() == MouseEvent.BUTTON3) {
                        decreaseBalls();
                    }
                }
            });
        }
    }

    void increaseBalls(Ball ball) {
        countBalls += 1;
        if (countBalls > sprites.length) {
            Sprite[] temp = new Sprite[sprites.length * 2];
            System.arraycopy(sprites, 0, temp, 0, sprites.length);
            sprites = temp;
        }
        sprites[countBalls - 1] = ball;
    }

    void decreaseBalls() {
        countBalls -= 1;
        if (countBalls < sprites.length / 3 && countBalls > 0) {
            Sprite[] temp = new Sprite[sprites.length / 2];
            System.arraycopy(sprites, 0, temp, 0, sprites.length / 2);
            sprites = temp;
        }
        if (countBalls < 0) countBalls = 0;
    }

    Sprite[] sprites = new Sprite[countBalls];

    private void initGame() {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }

    void onDrawFrame(GameCanvas gameCanvas, Graphics g, float deltaTime) {
        update(gameCanvas, deltaTime);
        render(gameCanvas, g);
    }

    Background back = new Background();

    private void update(GameCanvas gameCanvas, float deltaTime) {
        for (int i = 0; i < countBalls; i++) {
            sprites[i].update(gameCanvas, deltaTime);
        }
        back.update(deltaTime);
    }

    private void render(GameCanvas gameCanvas, Graphics g) {
        back.render(gameCanvas, g);
        for (int i = 0; i < countBalls; i++) {
            sprites[i].render(gameCanvas, g);
        }

    }



}

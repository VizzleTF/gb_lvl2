package lesson1;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {

    private MainWindow mainWindow;
    public Color color;
    private int i = 0;
    private int x = 2;

    private long lastFrameTime;

    GameCanvas(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        lastFrameTime = System.nanoTime();
        setBackground(color);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (i < 256 && i >= 0){
            color = new Color(i, i, i);
            i += x;
        } else { x = -x; i += x; }

        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        lastFrameTime = currentTime;

        mainWindow.onDrawFrame(this, g, deltaTime);
        try {
            Thread.sleep(16);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        repaint();
    }

    public int getLeft() { return 0; }
    public int getRight() { return getWidth() - 1; }
    public int getTop() { return 0; }
    public int getBottom() { return getHeight() - 1; }

}

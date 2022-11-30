package lesson1;

import java.awt.*;
import java.util.Random;

public class Background extends Sprite{

    private static Random rnd = new Random();

    public Color color;
    private static final int freq = 60;
    private static int i = 0;

    private int x;
    private int y;
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;

    Background() {
        x = WINDOW_WIDTH ;
        y = WINDOW_HEIGHT;
    }

    void render(GameCanvas gameCanvas, Graphics g) {
        i++;
        if (i > freq) {
            color = new Color(rnd.nextInt());
            i = 0;
        }
        g.setColor(color);
        g.fillRect(0, 0, x, y);
    }
}

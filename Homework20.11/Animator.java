import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Animator {

    Graphics g;
    Graphics screenG;

    int CENTER_X = 600;
    int CENTER_Y = 400;
    int CELL_SIZE = 100;
    int serifSize = 10;

    int currentX;
    int currentY;
    BufferedImage img;


    public Animator(Graphics g) { //создаем конструктор, в котором инициализируется изображение
        screenG = g;
        img = new BufferedImage(1200, 800, BufferedImage.TYPE_3BYTE_BGR);
        this.g = img.getGraphics();
    }

    public void changeCellSize(int a, int windowX, int windowY) { //метод, который изменяет размер ячейки
        resetImg();
        double plotX = coorTransX(windowX);
        double plotY = coorTransY(windowY);
        if (a > 0) {
            CELL_SIZE += 5;
        } else {
            if (CELL_SIZE > 7) {
                CELL_SIZE -= 5;
            }
        }
        CENTER_X = windowX - (int) (plotX * CELL_SIZE);
        CENTER_Y = windowY + (int) (plotY * CELL_SIZE);
        drawAxis();
        drawToScreen();
    }

    public void drawSquare(int x, int y) {
        Random r = new Random();
        Color c = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
        g.setColor(c);
        g.fillRect(x, y, 50, 50);
    }

    public void setXandY(int x, int y) {
        resetImg();
        currentX = x;
        currentY = y;
        double newX = coorTransX(x);
        double newY = coorTransY(y);
        g.fillOval(x - 5, y - 5, 10, 10);
        g.drawString("x = " + newX +
                "   y = " + newY, 800, 600);
        drawAxis();
        drawToScreen();
    }

    public void resetImg() {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, img.getWidth(), img.getHeight());
        g.setColor(Color.BLACK);
    }

    public double coorTransX(int x) {
        double newX = (x - CENTER_X) * 1.0 / CELL_SIZE;
        return newX;
    }

    public double coorTransY(int y) {
        double newY = (CENTER_Y - y) * 1.0 / CELL_SIZE;
        return newY;
    }

    public void drawAxis() {
        drawX();
        drawY();
    }

    public void drawX() {
        g.drawLine(50, CENTER_Y, 2 * CENTER_X - 50, CENTER_Y);
        g.drawLine(2 * CENTER_X - 80, CENTER_Y - 15, 2 * CENTER_X - 50, CENTER_Y);
        g.drawLine(2 * CENTER_X - 80, CENTER_Y + 15, 2 * CENTER_X - 50, CENTER_Y);
        int countOfSerifs = (CENTER_X - 35) / CELL_SIZE;
        for (int i = 0; i < countOfSerifs; i++) {
            g.drawLine(CENTER_X + i * CELL_SIZE, CENTER_Y - serifSize, CENTER_X + i * CELL_SIZE, CENTER_Y + serifSize);
            g.drawLine(CENTER_X - i * CELL_SIZE, CENTER_Y - serifSize, CENTER_X - i * CELL_SIZE, CENTER_Y + serifSize);
        }
    }

    public void drawY() {
        g.drawLine(CENTER_X, 50, CENTER_X, 750);
        g.drawLine(CENTER_X - 15, 80, CENTER_X, 50);
        g.drawLine(CENTER_X + 15, 80, CENTER_X, 50);
        int countOfSerifs = (CENTER_Y - 35) / CELL_SIZE;
        for (int i = 0; i < countOfSerifs; i++) {
            g.drawLine(CENTER_X - serifSize, CENTER_Y + i * CELL_SIZE, CENTER_X + serifSize, CENTER_Y + i * CELL_SIZE);
            g.drawLine(CENTER_X - serifSize, CENTER_Y - i * CELL_SIZE, CENTER_X + serifSize, CENTER_Y - i * CELL_SIZE);
        }
    }

    public void drawToScreen() {
        screenG.drawImage(img, 0, 0,
                img.getWidth(), img.getHeight(), null);
    }
}
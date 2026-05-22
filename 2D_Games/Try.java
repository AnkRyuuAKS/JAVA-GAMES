import javax.swing.*;
import java.awt.*;

public class Try extends JPanel {
    private int xc, yc, r;

    public Try(int xc, int yc, int r) {
        this.xc = xc;
        this.yc = yc;
        this.r = r;
    }

    // Plot all 8 symmetric points
    private void drawCirclePoints(Graphics g, int x, int y) {
        g.drawLine(xc + x, yc + y, xc + x, yc + y);
        g.drawLine(xc - x, yc + y, xc - x, yc + y);
        g.drawLine(xc + x, yc - y, xc + x, yc - y);
        g.drawLine(xc - x, yc - y, xc - x, yc - y);
        g.drawLine(xc + y, yc + x, xc + y, yc + x);
        g.drawLine(xc - y, yc + x, xc - y, yc + x);
        g.drawLine(xc + y, yc - x, xc + y, yc - x);
        g.drawLine(xc - y, yc - x, xc - y, yc - x);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = 0, y = r;
        int d = 3 - (2 * r);

        while (x <= y) {
            drawCirclePoints(g, x, y);

            if (d < 0) {
                d = d + (4 * x) + 6;
            } else {
                d = d + 4 * (x - y) + 10;
                y--;
            }
            x++;
        }
    }

    public static void main(String[] args) {
        int xc = 250, yc = 250, r = 100; // Center and radius

        JFrame frame = new JFrame("Bresenham Circle Drawing");
        Try panel = new Try(xc, yc, r); // ✅ Use Try instead of BresenhamCircle

        frame.add(panel);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

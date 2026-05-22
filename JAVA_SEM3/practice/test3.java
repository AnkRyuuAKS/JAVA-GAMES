import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class test3 extends JPanel {

    private int w = 600, h = 600; // panel width and height
    private List<Point> originalLinePixels = new ArrayList<>();

    // Plot pixel with center origin
    private void plotPixel(Graphics g, int x, int y) {
        g.fillRect(x + w / 2, h / 2 - y, 2, 2); // 2x2 pixel for visibility
    }

    // DDA Line drawing method
    private void drawDDA(int x1, int y1, int x2, int y2, Graphics g, List<Point> storePixels) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        int steps = Math.max(Math.abs(dx), Math.abs(dy));
        float xInc = dx / (float) steps;
        float yInc = dy / (float) steps;
        float x = x1, y = y1;

        for (int i = 0; i <= steps; i++) {
            int px = Math.round(x);
            int py = Math.round(y);
            plotPixel(g, px, py);
            if (storePixels != null) storePixels.add(new Point(px, py));
            x += xInc;
            y += yInc;
        }
    }

    // Draw original, translated, and rotated lines
    private void drawLineTranslateRotate(Graphics g) {
        originalLinePixels.clear();

        // 1️⃣ Original Line
        drawDDA(0, 0, 100, 50, g, originalLinePixels);

        // 2️⃣ Translate 50 right, 50 up
        List<Point> translated = new ArrayList<>();
        for (Point p : originalLinePixels) {
            Point t = new Point(p.x + 50, p.y + 50);
            plotPixel(g, t.x, t.y);
            translated.add(t);
        }

        // 3️⃣ Rotate translated line 30° clockwise around leftmost point
        Point pivot = translated.get(0); // leftmost point
        double angle = Math.toRadians(30);
        for (Point p : translated) {
            int tx = p.x - pivot.x;
            int ty = p.y - pivot.y;

            int rx = (int) Math.round(tx * Math.cos(angle) + ty * Math.sin(angle));
            int ry = (int) Math.round(-tx * Math.sin(angle) + ty * Math.cos(angle));

            plotPixel(g, pivot.x + rx, pivot.y + ry);
        }
    }

    // paintComponent
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        drawLineTranslateRotate(g);
    }

    // Constructor for panel
    public test3() {
        setPreferredSize(new Dimension(w, h));
        setBackground(Color.WHITE);
    }

    // Main method to run JFrame
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Line Translation and Rotation Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new test3());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

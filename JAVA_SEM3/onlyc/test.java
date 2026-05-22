import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;

public class test {

    private class Canvas extends JPanel {
        int w, h;

        Canvas(int w, int h) {
            this.w = w;
            this.h = h;
        }

        // Function to plot pixel at transformed coordinates
        private void plotPixel(Graphics g, int x, int y) {
            g.fillRect(x + (w / 2), (h / 2) - y, 1, 1);
        }

        // Your drawing algorithms will be called here
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // ===== CALL ANY GRAPHICS ALGO HERE =====
            // Example: DDA Line
            // drawDDALine(0, 0, 65, 189, g);
            // drawBresenhamLine(0, 0, 65, 189, g);
            // drawBresenhamCircle(122,g);
            drawLineTranslateRotate(0, 0, 100, 100, g);
            // Example: Bresenham Line
            // drawBresenhamLine(0, 0, 100, 100, g);

            // Example: Circle
            // drawBresenhamCircle(50, g);
        }

        // ===============================
        // YOUR ALGORITHMS GO BELOW THIS
        // ===============================

        void drawDDALine(int x1, int y1, int x2, int y2, Graphics g) {
            int dx = x2 - x1;
            int dy = y2 - y1;

            int steps = Math.max(Math.abs(dx), Math.abs(dy));

            float xInc = dx / (float) steps;
            float yInc = dy / (float) steps;

            float x = x1;
            float y = y1;

            for (int i = 0; i <= steps; i++) {
                plotPixel(g, Math.round(x), Math.round(y));
                x += xInc;
                y += yInc;
            }
        }

        public void drawBresenhamLine(int x1, int y1, int x2, int y2, Graphics g) {
    int dx = x2 - x1;
    int dy = y2 - y1;

    int x = x1;
    int y = y1;

    int sx = dx >= 0 ? 1 : -1;
    int sy = dy >= 0 ? 1 : -1;

    dx = Math.abs(dx);
    dy = Math.abs(dy);

    // Decision parameter
    if (dx >= dy) {
        int p = 2 * dy - dx;  // initial decision parameter
        for (int i = 0; i <= dx; i++) {
            plotPixel(g, x, y);  // draw pixel
            x += sx;
            if (p < 0) {
                p += 2 * dy;
            } else {
                y += sy;
                p += 2 * (dy - dx);
            }
        }
    } else {
        int p = 2 * dx - dy;  // initial decision parameter
        for (int i = 0; i <= dy; i++) {
            plotPixel(g, x, y);
            y += sy;
            if (p < 0) {
                p += 2 * dx;
            } else {
                x += sx;
                p += 2 * (dx - dy);
            }
        }
    }
}

public void drawBresenhamCircle(int r, Graphics g) {
    int x = 0;
    int y = r;
    int d = 3 - 2 * r;

    while (x <= y) {
        // plot all eight octants
        plotPixel(g, x, y);
        plotPixel(g, y, x);
        plotPixel(g, -x, y);
        plotPixel(g, -y, x);
        plotPixel(g, -x, -y);
        plotPixel(g, -y, -x);
        plotPixel(g, x, -y);
        plotPixel(g, y, -x);

        if (d <= 0) {
            d = d + 4 * x + 6;
        } else {
            d = d + 4 * (x - y) + 10;
            y--;
        }
        x++;
    }
}

List<Point> originalLinePixels = new ArrayList<>();

public void drawLineTranslateRotate(int x1, int y1, int x2, int y2, Graphics g) {
    originalLinePixels.clear();

    // ===== 1️⃣ Draw Original Line (DDA) =====
    int dx = x2 - x1;
    int dy = y2 - y1;
    int steps = Math.max(Math.abs(dx), Math.abs(dy));
    float xInc = dx / (float) steps;
    float yInc = dy / (float) steps;
    float x = x1;
    float y = y1;

    for (int i = 0; i <= steps; i++) {
        int px = Math.round(x);
        int py = Math.round(y);
        plotPixel(g, px, py);         // Draw original
        originalLinePixels.add(new Point(px, py));  // Store for transformation
        x += xInc;
        y += yInc;
    }

    // ===== 2️⃣ Translate Line (50 right, 50 up) =====
    List<Point> translated = new ArrayList<>();
    for (Point p : originalLinePixels) {
        Point t = new Point(p.x + 50, p.y + 50); // right = +50, up = +50
        plotPixel(g, t.x, t.y);                 // Draw translated line
        translated.add(t);
    }

    // ===== 3️⃣ Rotate Translated Line 30° Clockwise =====
    Point pivot = translated.get(0); // Leftmost point
    double angle = Math.toRadians(30); // 30° clockwise

    for (Point p : translated) {
        int tx = p.x - pivot.x;
        int ty = p.y - pivot.y;

        int rx = (int) Math.round(tx * Math.cos(angle) + ty * Math.sin(angle));
        int ry = (int) Math.round(-tx * Math.sin(angle) + ty * Math.cos(angle));

        plotPixel(g, pivot.x + rx, pivot.y + ry); // Draw rotated line
    }
}
public void drawBezier(int x1, int y1, int x2, int y2, int x3, int y3, Graphics g) {
    // Use parametric formula B(t) = (1-t)^2*P0 + 2*(1-t)*t*P1 + t^2*P2
    for (float t = 0; t <= 1; t += 0.001) {
        float x = (1 - t) * (1 - t) * x1 + 2 * (1 - t) * t * x2 + t * t * x3;
        float y = (1 - t) * (1 - t) * y1 + 2 * (1 - t) * t * y2 + t * t * y3;
        plotPixel(g, Math.round(x), Math.round(y));
    }
}

    } // Canvas class ends


    // Main Frame
    test(int h, int w) {
        JFrame frm = new JFrame("Graphics Template");
        frm.setSize(w, h);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Canvas canvas = new Canvas(w, h);
        frm.add(canvas);

        frm.setVisible(true);
    }

    // Main Function
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new test(500, 500));
    }

}
 
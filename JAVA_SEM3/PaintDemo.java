import java.awt.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PaintDemo {
    private class MyCanvas extends JPanel {
        private final int w, h;

        MyCanvas(int w, int h) {
            this.w = w;
            this.h = h;
            setPreferredSize(new Dimension(w, h));
            setBackground(Color.WHITE);
        }

        private void plotPixel(Graphics g, int x, int y) {
            // map your logical origin (0,0) to the center of the panel
            g.fillRect(x + (w / 2), (h / 2) - y, 1, 1);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // sample drawings
            drawDDALine(-100, -50, 100, 50, g);
            drawBresenhamLine(-120, 80, 120, -80, g);
            drawBresenhamCircle(80, g);
            drawMidpointCircle(50, g);

            int x1 = -140, y1 = -90, x2 = -20, y2 = -30;
            ArrayList<int[]> pixels = drawBresenhamLineStore(x1, y1, x2, y2, g);
            translateAndRotate(pixels, 50, 50, Math.toRadians(-30), g);

            drawBezier(-100, -120, 0, 120, 100, -120, g);
        }

        private void drawDDALine(int x1, int y1, int x2, int y2, Graphics g) {
            int dx = x2 - x1;
            int dy = y2 - y1;
            int steps = Math.max(Math.abs(dx), Math.abs(dy));
            double x = x1;
            double y = y1;
            double xinc = dx / (double) steps;
            double yinc = dy / (double) steps;
            for (int i = 0; i <= steps; i++) {
                plotPixel(g, (int) Math.round(x), (int) Math.round(y));
                x += xinc;
                y += yinc;
            }
        }

        private ArrayList<int[]> drawBresenhamLineStore(int x0, int y0, int x1, int y1, Graphics g) {
            ArrayList<int[]> pts = new ArrayList<>();
            int dx = Math.abs(x1 - x0);
            int dy = Math.abs(y1 - y0);
            int sx = x0 < x1 ? 1 : -1;
            int sy = y0 < y1 ? 1 : -1;
            boolean steep = dy > dx;
            if (steep) {
                int t;
                t = x0; x0 = y0; y0 = t;
                t = x1; x1 = y1; y1 = t;
                t = dx; dx = dy; dy = t;
                t = sx; sx = sy; sy = t;
            }
            int err = 2 * dy - dx;
            int y = y0;
            for (int x = x0; ; x += sx) {
                int px = steep ? y : x;
                int py = steep ? x : y;
                pts.add(new int[]{px, py});
                plotPixel(g, px, py);
                if (x == x1) break;
                if (err > 0) {
                    y += sy;
                    err -= 2 * dx;
                }
                err += 2 * dy;
            }
            return pts;
        }

        private void drawBresenhamLine(int x0, int y0, int x1, int y1, Graphics g) {
            int dx = Math.abs(x1 - x0);
            int dy = Math.abs(y1 - y0);
            int sx = x0 < x1 ? 1 : -1;
            int sy = y0 < y1 ? 1 : -1;
            boolean steep = dy > dx;
            if (steep) {
                int t;
                t = x0; x0 = y0; y0 = t;
                t = x1; x1 = y1; y1 = t;
                t = dx; dx = dy; dy = t;
                t = sx; sx = sy; sy = t;
            }
            int err = 2 * dy - dx;
            int y = y0;
            for (int x = x0; ; x += sx) {
                int px = steep ? y : x;
                int py = steep ? x : y;
                plotPixel(g, px, py);
                if (x == x1) break;
                if (err > 0) {
                    y += sy;
                    err -= 2 * dx;
                }
                err += 2 * dy;
            }
        }

        private void plotCircle8(Graphics g, int xc, int yc, int x, int y) {
            plotPixel(g, xc + x, yc + y);
            plotPixel(g, xc - x, yc + y);
            plotPixel(g, xc + x, yc - y);
            plotPixel(g, xc - x, yc - y);
            plotPixel(g, xc + y, yc + x);
            plotPixel(g, xc - y, yc + x);
            plotPixel(g, xc + y, yc - x);
            plotPixel(g, xc - y, yc - x);
        }

        private void drawBresenhamCircle(int r, Graphics g) {
            int x = 0;
            int y = r;
            int d = 3 - 2 * r;
            while (x <= y) {
                plotCircle8(g, 0, 0, x, y);
                if (d < 0) {
                    d = d + 4 * x + 6;
                } else {
                    d = d + 4 * (x - y) + 10;
                    y--;
                }
                x++;
            }
        }

        private void drawMidpointCircle(int r, Graphics g) {
            int x = 0;
            int y = r;
            int p = 1 - r;
            while (x <= y) {
                plotCircle8(g, 0, 0, x, y);
                x++;
                if (p < 0) {
                    p = p + 2 * x + 1;
                } else {
                    y--;
                    p = p + 2 * (x - y) + 1;
                }
            }
        }

        private void translateAndRotate(ArrayList<int[]> pts, int tx, int ty, double theta, Graphics g) {
            // first draw translated points
            for (int[] p : pts) {
                int nx = p[0] + tx;
                int ny = p[1] + ty;
                plotPixel(g, nx, ny);
            }

            // find left-most point (used as center in your original code)
            int minx = Integer.MAX_VALUE;
            int[] center = null;
            for (int[] p : pts) {
                if (p[0] < minx) {
                    minx = p[0];
                    center = p;
                }
            }
            if (center == null) return;

            double cx = center[0] + tx;
            double cy = center[1] + ty;
            for (int[] p : pts) {
                double x = p[0] + tx;
                double y = p[1] + ty;
                double xr = Math.cos(theta) * (x - cx) - Math.sin(theta) * (y - cy) + cx;
                double yr = Math.sin(theta) * (x - cx) + Math.cos(theta) * (y - cy) + cy;
                plotPixel(g, (int) Math.round(xr), (int) Math.round(yr));
            }
        }

        private void drawBezier(int x1, int y1, int x2, int y2, int x3, int y3, Graphics g) {
            int steps = 500;
            for (int i = 0; i <= steps; i++) {
                double t = i / (double) steps;
                double u = 1 - t;
                double x = u * u * x1 + 2 * u * t * x2 + t * t * x3;
                double y = u * u * y1 + 2 * u * t * y2 + t * t * y3;
                plotPixel(g, (int) Math.round(x), (int) Math.round(y));
            }
        }
    }

    public PaintDemo(int width, int height) {
        JFrame frm = new JFrame("Paint Demo");
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyCanvas canvas = new MyCanvas(width, height);
        frm.add(canvas);
        frm.pack();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // width, height
                new PaintDemo(800, 600);
            }
        });
    }
}

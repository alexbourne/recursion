import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

/**
 * Created with IntelliJ IDEA.
 * User: alexbourne
 * Date: 11/11/2013
 * Time: 22:30
 */
public class KochFractal2 extends JFrame {

    public KochFractal2() {

        initUi();

    }

    public static Path2D drawFractal(int size, int order, int width, int height) {
        double x0 = width / 2 - size / 2;
        double y0 = height / 2 - Math.sqrt(3.0) * size / 6;

        Path2D path = new Path2D.Double();
        path.moveTo(x0, y0);

        drawFractalLine(size, 0, order, path);
        drawFractalLine(size, 120, order, path);
        drawFractalLine(size, 240, order, path);

        return path;
    }

    private static void drawFractalLine(double len, double theta, int order, Path2D path) {
        if (order == 0) {
            drawPolarLine(len, theta, path);
        } else {
            drawFractalLine(len / 3, theta, order - 1, path);
            drawFractalLine(len / 3, theta - 60, order - 1, path);
            drawFractalLine(len / 3, theta + 60, order - 1, path);
            drawFractalLine(len / 3, theta, order - 1, path);
        }
    }

    private static void drawPolarLine(double r, double theta, Path2D path) {
        double radians = theta / 180 * Math.PI;
        Point2D current = path.getCurrentPoint();
        path.lineTo(current.getX() + r * Math.cos(radians), current.getY() + r * Math.sin(radians));
    }

    private void initUi() {

        setTitle("Simple Java 2D example");

        add(new Canvas());

        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                KochFractal2 m = new KochFractal2();
                m.setVisible(true);

            }
        });

    }

    class Canvas extends JPanel {

        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            Graphics2D g2 = (Graphics2D) graphics;
            Path2D path = drawFractal(300, 5, this.getWidth(), this.getHeight());
            g2.draw(path);
        }

    }

}

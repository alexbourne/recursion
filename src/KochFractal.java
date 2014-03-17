import acm.util.RandomGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

/**
 * Created with IntelliJ IDEA.
 * User: alexbourne
 * Date: 11/11/2013
 * Time: 22:30
 */
public class KochFractal extends JFrame {

    private Path2D path;

    public KochFractal() {

        initUi();

    }

    void drawFractal(int size, int order, Graphics2D g2) {
        double x0 = getWidth() / 2 - size / 2;
        double y0 = getHeight() / 2 - Math.sqrt(3.0) * size / 6;

        path = new Path2D.Double();
        path.moveTo(x0, y0);

        drawFractalLine(size, 0, order);
        drawFractalLine(size, 120, order);
        drawFractalLine(size, 240   , order);
        g2.draw(path);

    }

    void drawFractalLine(double len, double theta, int order) {
        if (order == 0) {
            drawPolarLine(len, theta);
        } else {
            drawFractalLine(len / 3, theta, order - 1);
            drawFractalLine(len / 3, theta - 60, order - 1);
            drawFractalLine(len / 3, theta + 60, order - 1);
            drawFractalLine(len / 3, theta, order - 1);
        }
    }

    void drawPolarLine(double r, double theta) {
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

                KochFractal m = new KochFractal();
                m.setVisible(true);

            }
        });

    }

    class Canvas extends JPanel {

        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            Graphics2D g2 = (Graphics2D) graphics;
            drawFractal(300, 5, g2);
        }

    }

}

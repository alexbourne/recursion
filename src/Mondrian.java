import acm.util.RandomGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

/**
 * Created with IntelliJ IDEA.
 * User: alexbourne
 * Date: 11/11/2013
 * Time: 22:30
 */
public class Mondrian extends JFrame {

    private static final double MIN_AREA = 500.0;
    private static final double MIN_EDGE = 0.10;

    private final RandomGenerator rg = RandomGenerator.getInstance();

    public Mondrian() {

        initUi();

    }

    /**
     * Using recursion, divide a canvas into a mondrian style
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param g2
     */
    void subdivideCanvas(double x, double y, double width, double height, Graphics2D g2) {
        if (width * height >= MIN_AREA) {
            if (width > height) {
                double mid = width * rg.nextDouble(MIN_EDGE, 1 - MIN_EDGE);

                Line2D.Double line = new Line2D.Double(x + mid, y, x + mid, y + height);
                g2.draw(line);

                subdivideCanvas(x, y, mid, height, g2);
                subdivideCanvas(x + mid, y, width - mid, height, g2);
            } else {
                double mid = height * rg.nextDouble(MIN_EDGE, 1 - MIN_EDGE);

                Line2D.Double line = new Line2D.Double(x, y + mid, x + width, y + mid);
                g2.draw(line);

                subdivideCanvas(x, y, width, mid, g2);
                subdivideCanvas(x, y + mid, width, height - mid, g2);
            }
        }
    }

    private void initUi() {

        setTitle("Simple Java 2D example");

        add(new Canvas());

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater( new Runnable() {
            @Override
            public void run() {

                Mondrian m = new Mondrian();
                m.setVisible(true);

            }
        });

    }

    class Canvas extends JPanel {

        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            Graphics2D g2 = (Graphics2D) graphics;

            subdivideCanvas(0, 0, getWidth(), getHeight(), g2);
        }

    }

}

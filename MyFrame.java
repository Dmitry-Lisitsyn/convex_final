import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class MyFrame extends JFrame {

    public static int width = 700;
    public static int height = 500;
    private ConvexTest f1;
    private Convex to_win;

    public MyFrame(Convex to_win) {
        JFrame frame = new JFrame("Convex hull");
        this.setSize(width, height);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.to_win = to_win;
    }

    public void paint(Graphics g) {
        g.clearRect(0,0,700,500);
        g.translate(getWidth() / 2, getHeight() / 2);
        g.drawLine(0, -getHeight(), 0, getHeight());
        g.drawLine(-getWidth(), 0, getWidth(), 0);
        if (f1.answ == 'y') {
            g.drawLine(f1.x1, f1.y1*(-1), f1.x2, f1.y2*(-1));
            g.drawLine(f1.x2, f1.y2*(-1), f1.x3, f1.y3*(-1));
            g.drawLine(f1.x1, f1.y1*(-1), f1.x3, f1.y3*(-1));

        }
        to_win.draw(g);
    }
}
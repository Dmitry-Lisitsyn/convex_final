import java.util.Scanner;
import java.awt.*;
class ConvexTest {
    static Graphics g;
    public static int x1, x2, x3, y1, y2, y3;
    public static int x1_v,x2_v,x3_v, y1_v,y2_v,y3_v;
    public static char answ;

    public static void main(String[] args) throws Exception {
        Convex convex = new Convex();
        int endline;
        Scanner first = new Scanner(System.in);
        MyFrame fr = new MyFrame(convex);
        System.out.println("Запустить программу 'rebra'? y/n");
        answ = first.next().charAt(0);
        if (answ == 'y') {
            System.out.println("Задайте треугольник");
            System.out.println("Введите первую точку(x y)");
            x1 = first.nextInt();
            y1 = first.nextInt();

            System.out.println("Введите вторую точку(x y)");
            x2 = first.nextInt();
            y2 = first.nextInt();

            System.out.println("Введите третью точку(x y)");
            x3 = first.nextInt();
            y3 = first.nextInt();
            x1_v = x2-x1;
            x2_v = x3-x2;
            x3_v = x1-x3;
            y1_v = y2-y1;
            y2_v = y3-y2;
            y3_v = y1-y3;
            fr.repaint();
        }
        while (true) {

            convex.add(new R2Point());
            System.out.println("S = " + convex.area() + " , P = "
                    + convex.perimeter() + " , rebra = " + convex.rebra());
            fr.repaint();
        }

    }

}



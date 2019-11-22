import java.awt.*;

class Void implements Figure {
    public double perimeter() {
        return 0.0;
    }
    public double area() {
        return 0.0;
    }
    public double rebra(){
        return 0;
    }
    public Figure add(R2Point p) {
        return new Point(p);
    }
    public void draw(Graphics g) {
        /*g.setColor(Color.BLACK);
        g.fillOval(100,200,20,20);*/
    }
}
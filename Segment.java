import java.awt.*;
import java.util.Random;


class Segment implements Figure {
    protected Color color=Color.magenta;
    private double kol_reber=0;
    ConvexTest V;
    public double vx,vy;
    private R2Point p, q;
    public Segment(R2Point p, R2Point q) {
        this.p = p; this.q = q;
    }
    public double perimeter() {
        return 2.0 * R2Point.dist(p, q);
    }
    public double area() {
        return 0.0;
    }
    public double rebra(){
        if(V.answ=='y') {
            vx = q.x - p.x;
            vy = q.y - p.y;
            if (V.x1_v * vy - V.y1_v * vx == 0) {
                kol_reber += 1;
            }
            if (V.x2_v * vy - V.y2_v * vx == 0) {
                kol_reber += 1;
            }
            if (V.x3_v * vy - V.y3_v * vx == 0) {
                kol_reber += 1;
            }
        }
        return kol_reber;
    }
    public Figure add(R2Point r) {
        if (R2Point.isTriangle(p, q, r))
            return new Polygon(p, q, r);
        if (q.inside(p, r)) q = r;
        if (p.inside(r, q)) p = r;
        return this;
    }
    public void draw(Graphics g) {
        //////////////////////
        g.setColor(Color.GREEN);
        g.fillOval((int)p.x-5, (int)(p.y*(-1)-5), 10, 10);
        g.fillOval((int)q.x-5, (int)(q.y*(-1)-5), 10, 10);
        g.setColor(Color.RED);
        g.drawLine((int)p.x, (int)p.y*(-1),(int)q.x, (int)q.y*(-1));
    }
}
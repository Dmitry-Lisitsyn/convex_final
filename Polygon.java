import java.awt.*;
class Polygon extends Deq implements Figure {
    private double s, p;
    private double kol_reber=0;
    ConvexTest V2;
    public double vx,vy;
    private void grow(R2Point a, R2Point b, R2Point t) {
        p -= R2Point.dist(a, b);
        s += Math.abs(R2Point.area(a, b, t));

    }

    public Polygon(R2Point a, R2Point b, R2Point c) {
        pushFront(b);
        if (b.light(a, c)) {
            pushFront(a); pushBack(c);
        } else {
            pushFront(c); pushBack(a);
        }
        p = R2Point.dist(a, b) + R2Point.dist(b, c)
                + R2Point.dist(c, a);
        s = Math.abs(R2Point.area(a, b, c));


    }
    public double perimeter() {
        return p;
    }
    public double area() {
        return s;
    }
    public double rebra(){
        if(V2.answ=='y'){
        kol_reber=0;
        for(int i = length();i>0;i-=1) {
            vx = (front().x) - (back().y);
            vy = (front().y) - (back().y);
            if (V2.x1_v * vy - V2.y1_v * vx == 0) {
                kol_reber += 1;
            }
            if (V2.x2_v * vy - V2.y2_v * vx == 0) {
                kol_reber += 1;
            }
            if (V2.x3_v * vy - V2.y3_v * vx == 0) {
                kol_reber += 1;
            }
            pushFront(popBack());
        }
        }
        return kol_reber;
    }
    public Figure add(R2Point t) {
        int i;
// Ищем освещенные ребра, просматривая их одно за другим.
        for (i=length(); i>0 && !t.light(back(),front()); i--)
            pushBack(popFront());
// УТВЕРЖДЕНИЕ: либо ребро [back(),front()] освещено из t,
// либо освещенных ребер нет совсем.
        if (i>0) {
            R2Point x;
            grow(back(), front(), t);
// Удаляем все освещенные ребра из начала дека.
            for (x = popFront(); t.light(x, front()); x = popFront())
                grow(x, front(), t );
            pushFront(x);
// Удаляем все освещенные ребра из конца дека.
            for (x = popBack(); t.light(back(), x); x = popBack())
                grow(back(), x, t);
            pushBack(x);
// Завершаем обработку добавляемой точки.
            p += R2Point.dist(back(), t) + R2Point.dist(t, front());
            pushFront(t);
        }
        return this;
    }

    public void draw(Graphics g) {
       // g.setColor(Color.RED);
       // g.fillOval(0-5,0-5,10,10);
        for(int i = length();i>0;i-=1){
            g.setColor(Color.GREEN);
            g.fillOval((int)(front().x-5), (int)(front().y*(-1)-5), 10, 10);
            g.setColor(Color.RED);
            g.drawLine((int)(front().x), (int)(front().y)*(-1),(int)(back().x), (int)(back().y)*(-1));
            pushFront(popBack());

        }

    }
}
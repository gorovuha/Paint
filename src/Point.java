import java.awt.*;
import java.util.ArrayList;

public class Point {
    private int x;
    private int y;
    public static ArrayList<Point> dots = new ArrayList<>();

    Point(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public static void add(Point point){
        dots.add(point);
    }

    public void draw(Graphics g){
        g.fillOval(x,y,2,2);
    }
}
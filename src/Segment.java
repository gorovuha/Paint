import java.awt.*;

public class Segment {
    int x1,x2,y1,y2;
    public void startSegment (int x, int y){
        x1=x;
        y1=y;
    }

    public void endSegment(int x, int y){
        x2=x;
        y2=y;
    }

    public void draw(Graphics g){
        if (x1 > x2){
            int t = x1;
            x1 = x2;
            x2 = t;
        }
        if (y1 > y2){
            int t = y1;
            y1 = y2;
            y2 = t;
        }
        g.drawLine(x1,y1,x2,y2);
    }
}

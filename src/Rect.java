import java.awt.*;

class Rect {
    int x1,y1;
    int width, height;

    Rect(int x1,int y1,int x2,int y2){
        this.x1=x1;
        this.y1=y1;
        width = -x1+x2 ;
        height = -x1+x2;
    }

    public void draw(Graphics graphics){
        graphics.clearRect(x1,y1,width,height);
        graphics.drawRect(x1,y1,width,height);
    }

    public void endDraw(Graphics g){
        g.drawRect(x1,y1,width,height);
    }

    public void redo(int x,int y){
        width = -x1+x ;
        height = -y1+y;
    }
}
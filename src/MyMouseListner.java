import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MyMouseListner implements MouseMotionListener,MouseListener {
    int x, y;
    JFrame frame;

    public MyMouseListner(JFrame frame){
        this.frame = frame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (Main.drawingMode == 0) {
            Main.points.add(new Point(e.getX(), e.getY()));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (Main.drawingMode == 2) {
            x=e.getX();
            y=e.getY();
            Main.rectangles.add(new Rect(x,y,x,y));
            Main.drawingRect = true;
        }
        frame.repaint();

        if (Main.drawingMode == 1) {
            Main.lines.add(new Line());
            x=e.getX();
            y=e.getY();
        }
        frame.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Main.drawingRect = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (Main.drawingMode == 1) {
            Segment segment = new Segment();
            segment.endSegment(e.getX(), e.getY());
            segment.startSegment(x, y);
            x = e.getX();
            y = e.getY();
            Main.lines.get(Main.lines.size()-1).add(segment);
        }
        if (Main.drawingMode == 2) {
            Main.rectangles.get(Main.rectangles.size()-1).redo(e.getX(),e.getY());
        }

        if (Main.drawingMode == 0){
            int xx = e.getX();
            int yy = e.getY();
            Point dot = new Point(xx, yy);
            Main.points.add(dot);
        }
        frame.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
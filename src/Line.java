import java.awt.*;
import java.util.ArrayList;

public class Line {
    ArrayList<Segment> segments= new ArrayList<>();


    public void add(Segment segment){
        segments.add(segment);
    }

    public void draw(Graphics g){
        for (int i =0 ; i<segments.size(); i++){
            segments.get(i).draw(g);
        }
    }
}
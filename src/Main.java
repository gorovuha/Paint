import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {
    static int drawingMode =0;
    static boolean drawingRect = false;
    static ArrayList <Point> points= new ArrayList<>();
    static ArrayList <Line> lines= new ArrayList<>();
    static ArrayList <Rect> rectangles= new ArrayList<>();
    static  MyPanel panel = new MyPanel();
    static JFrame frame;
    public static void main(String[] args) throws InterruptedException {

        JFrame frame = new JFrame();
        frame.setSize(1130, 710);
        frame.setLayout(new BorderLayout());

        JPanel buttons = new JPanel();
        JButton Points = new JButton("Dots");
        Points.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingMode =0;
            }
        });

        JButton Line = new JButton("Line");
        Line.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingMode =1;
            }
        });

        JButton Rectangle = new JButton("Rectangle");
        Rectangle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingMode =2;
            }
        });

        buttons.setLayout(new GridLayout(3,1));
        buttons.add(Points);
        buttons.add(Line);
        buttons.add(Rectangle);

        frame.add(panel,BorderLayout.CENTER);
        frame.add(buttons,BorderLayout.EAST);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);

        MyMouseListner mouseListener = new MyMouseListner(frame);
        panel.addMouseListener(mouseListener);
        panel.addMouseMotionListener(mouseListener);

        while (true) {
            if (drawingRect==false){
                for (int i =0 ; i<rectangles.size(); i++){
                    rectangles.get(i).endDraw(panel.getGraphics());
                }
            } else {
                for (int i =0 ; i<rectangles.size()-1; i++){
                    rectangles.get(i).draw(panel.getGraphics());
                }
                rectangles.get(rectangles.size()-1).draw(panel.getGraphics());
            }

            for (int i =0 ; i<points.size(); i++){
                points.get(i).draw(panel.getGraphics());
            }
            for (int i =0 ; i<lines.size(); i++){
                lines.get(i).draw(panel.getGraphics());
            }
            //frame.repaint();
            Thread.sleep(1);
        }

    }
}
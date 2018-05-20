import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.image.BufferedImage;
public class Init {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Game Window");
        frame.setVisible(true);
        frame.setSize(800,800);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //ZObject one = new ZObject(new OtherPoint(-30,4,5),new OtherPoint(-30,4,80), new OtherPoint(30,4,5));
        //ZObject two = new ZObject(new OtherPoint(-30,4,80), new OtherPoint(30,4,5), new OtherPoint(30,4,80));
        //ZObject one = new ZObject(new OtherPoint(-3,2,5),new OtherPoint(-3,2,10), new OtherPoint(3,2,5), new OtherPoint(3,2,10));
        ZObject one = new ZObject(new OtherPoint(-30,2,500),new OtherPoint(30,2,500),new OtherPoint(30,2,100) , new OtherPoint(-30,2,100));
        ArrayList<ZObject> samplein = new ArrayList<ZObject>();
        samplein.add(one);
        //samplein.add(two);
        Display d = new Display(samplein);
        frame.add(d);
        d.setVisible(true);
        d.draw();
        GravityThread gt = new GravityThread(d);
        (new Thread(gt)).start();
        frame.addKeyListener(new KeyboardThread(d,gt));
        (new Thread(new FrameThread(d))).start();
    }
}
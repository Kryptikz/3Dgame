import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class KeyboardThread extends KeyAdapter { 
    Display dis;
    GravityThread gt;
    boolean jumping;
    boolean a;
    boolean d;
    boolean w;
    boolean s;
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        //System.out.println("GOT KEY PRESS:" + key);
        if (!dis.getPaused()) {
            if (key == KeyEvent.VK_SPACE) {
                if (!jumping&&dis.getGround()>10&&dis.getGround()<24) {
                    (new Thread(new JumpingThread(dis,gt,this))).start();
                }
            }            
            if (key == KeyEvent.VK_A) {
                dis.aPress();
            }
            if (key == KeyEvent.VK_D) {
                dis.dPress();
            }
            if (key == KeyEvent.VK_W) {
                dis.wPress();
            }
            if (key == KeyEvent.VK_S) {
                dis.sPress();
            }
            if (key == KeyEvent.VK_CONTROL) {
                dis.shiftPress();
            }    
            if (key == KeyEvent.VK_R) {
                dis.reset();
            }
        }
        //dis.draw();
    }
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_A) {
            dis.aRelease();
        }
        if (key == KeyEvent.VK_D) {
            dis.dRelease();
        }
        if (key == KeyEvent.VK_W) {
            dis.wRelease();
        }
        if (key == KeyEvent.VK_S) {
            dis.sRelease();
        }    
        if (key == KeyEvent.VK_CONTROL) {
            dis.shiftRelease();
        }
        //dis.draw();
    }
    public void setDrawingPlane(Display d) {
        dis=d;
    }
    public KeyboardThread(Display d, GravityThread g) {
        dis=d;
        gt=g;
        jumping=false;
    }
    public void jump() {
        jumping=true;
    }
    public void unjump() {
        jumping=false;
    }  
    public void changeGravityThread(GravityThread g) {
        gt=g;
    }
}       
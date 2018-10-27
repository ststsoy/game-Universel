package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import static java.awt.Window.getWindows;
import static main.Enamy.*;
import static main.Enamy.x_e;
import static main.Enamy.x_e_b;
import static main.Enamy.y_e;
import static main.Enamy.y_e_b;
import static main.Enamy_2.*;
import static main.Universe.*;

public class Playr {
    private static Image playr;
    public static Image bullet_p;
    public static Image boom;
    public static boolean up;
    public static boolean down;
    public static boolean right;
    public static boolean left;
    public static int px;
    public static int py;
    public static float bx=0;
    public static float by=0;
    public static float bx2;
    public static float by2;

    public Playr () throws IOException {
        this.playr = ImageIO.read (Playr.class.getResourceAsStream ("корабль02.png"));
        this.bullet_p = ImageIO.read (Playr.class.getResourceAsStream ("261-iconimg.png"));
        this.boom = ImageIO.read(Playr.class.getResourceAsStream ("boom.png"));
        up=false;
        down =false;
        right=false;
        left=false;
        px=vip.getWidth ()/2;
        py=vip.getHeight ()/2;
        bx=(px-7);
        by=(py-5);
        bx2=px+67;
        by2=py-5;
        Listner listner = new Listner ();
        addKeyListener(new Listner ());
    }
    public static void draw (Graphics g) {

        if (up && py >= 0) {
            py-=5;
        }
        if (right && px <= vip.getWidth () - 99) {
            px+=5;
        }
        if (left && px >= 0) {
            px-=5;
        }
        if (down && py <= vip.getHeight () - 99) {
            py+=5;
        }
        g.drawImage (playr, px, py, null);
        by -= 6;
        g.drawImage (bullet_p,(int) bx,(int) by, null);
        if (by <= 0) {
            bx = px - 7;
            by = py - 5;
        }



        by2 -= 6;
        g.drawImage (bullet_p,(int) bx2,(int) by2, null);
        if (by2 <= 0) {
            bx2 = px + 67;
            by2 = py - 5;
        }
        g.drawLine (px, py, px + 99, py + 99);
        g.drawLine (px, py + 99, px + 99, py);

        float x_p_0 = px;
        float y_p_0 = py + playr.getHeight (null);
        float x_p_1 = px + playr.getWidth (null);
        float y_p_1 = py + playr.getHeight (null);
        float x_p_2 = px + playr.getWidth (null);
        float y_p_2 = py;
        float x_e_b_c = x_e_b + (bullet_e.getWidth (null) / 2);
        float y_e_b_c = y_e_b + (bullet_e.getHeight (null) / 2);
        boolean is_bullet = px <= x_e_b_c && py <= y_e_b_c && x_p_1 >= x_e_b_c && y_p_1 >= y_e_b_c;
        if (is_bullet) {
            g.drawImage (boom,(int) px, (int) py,null);
            px = 700;
            py = 500;
            score_e++;
            if (score_e == 3) {
                //System.exit (0);
                fit.setVisible (false);
                label.setText ("You lose!!!");
                score_e = 0;
                x_e_b = x_e;
                y_e_b = y_e;
            }
        }
        float x_e_b_c2 = x_e2_b + (bullet_enamy_2.getWidth (null) / 2);
        float y_e_b_c2 = y_e2_b + (bullet_enamy_2.getHeight (null) / 2);
        boolean is_bullet2 = px <= x_e_b_c2 && py <= y_e_b_c2 && x_p_1 >= x_e_b_c2 && y_p_1 >= y_e_b_c2;
        if (is_bullet2) {
            g.drawImage (boom,(int) px, (int) py,null);
            px = 700;
            py = 500;
            score_e++;
            if (score_e == 3) {
                //System.exit (0);
                fit.setVisible (false);
                label.setText ("You lose!!!");
                score_e = 0;
                x_e_b = x_e;
                y_e_b = y_e;
            }
        }




    }

}

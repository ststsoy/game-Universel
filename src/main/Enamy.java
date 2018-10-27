package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.IOException;

import static main.Playr.*;
import static main.Universe.fit;
import static main.Universe.label;
import static main.Universe.vip;

public class Enamy {
    public static float x_e;
    public static float y_e;
    public static float x_e_b;
    public static float y_e_b;
    public static Image enamy;
    public static Image bullet_e;
    public static int score_p;
    public Enamy () throws IOException {
        this.enamy=ImageIO.read (Enamy.class.getResourceAsStream ("вражеский корабль03.png"));
        this.bullet_e =ImageIO.read (Enamy.class.getResourceAsStream ("enamy_bullet.png"));
        x_e = 100;
        y_e = 100;
        x_e_b = x_e+enamy.getWidth (null)/2;
        y_e_b = y_e+enamy.getHeight (null)/2;
    }

    public static void draw (Graphics g) {
        y_e++;
        g.drawImage (enamy,(int)x_e,(int)y_e,null);
        if(y_e>=vip.getHeight ()){
            y_e =-100;
            x_e = (int) (Math.random () * (vip.getWidth () - enamy.getWidth (null)));
        }
        y_e_b+=6;
        g.drawImage (bullet_e,(int)x_e_b-20,(int)y_e_b,null);
        if(y_e_b>=vip.getHeight ()){
            x_e_b=x_e+enamy.getWidth (null)/2;
            y_e_b=y_e+enamy.getHeight (null)/2;
        }

        float x_e_0 = x_e;
        float y_e_0 = y_e + enamy.getHeight (null);
        float x_e_1 = x_e + enamy.getWidth (null);
        float y_e_1 = y_e + enamy.getHeight (null);
        float x_e_2 = x_e + enamy.getWidth (null);
        float y_e_2 = y_e;
        float x_p_b_c = bx+(bullet_p.getWidth (null) / 2);
        float y_p_b_c = by+ (bullet_p.getHeight (null) / 2);
        boolean is_bullet = x_e<=x_p_b_c &&y_e<=y_p_b_c&&x_e_1>=x_p_b_c&&y_e_1>=y_p_b_c;
        if(is_bullet){
            g.drawImage (boom,(int) x_e, (int) y_e,null);
            y_e = (int) -50;
            x_e = (int) Math.random () * (vip.getWidth () - enamy.getWidth (null));
            score_p++;
            if(score_p==8){
                System.exit (0);
                fit.setVisible (false);
                label.setText ("You Win!!!");
                score_p = 0;
            }
        }
        float x_p_b_c2 = bx2+(bullet_p.getWidth (null) / 2);
        float y_p_b_c2 = by2+ (bullet_p.getHeight (null) / 2);
        boolean is_bullet2 = x_e<=x_p_b_c2&&y_e<=y_p_b_c2&&x_e_1>=x_p_b_c2&&y_e_1>=y_p_b_c2;
        if(is_bullet2){
            g.drawImage (boom,(int) x_e, (int) y_e,null);

            y_e = (int) -50;
            x_e = (int) Math.random () * (vip.getWidth () - enamy.getWidth (null));
            score_p++;
            if(score_p==8){
                System.exit (0);
                fit.setVisible (false);
                label.setText ("You Win!!!");
                score_p = 0;

            }

        }

    }




}

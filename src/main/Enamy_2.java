package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

import static main.Playr.*;
import static main.Universe.fit;
import static main.Universe.label;
import static main.Universe.vip;

public class Enamy_2 extends Enamy {
    private static float x_e_2;
    private static float y_e_2;
    public static Image enamy_2;
    public static Image bullet_enamy_2;
    public static float x_e2_b;
    public static float y_e2_b;


    public Enamy_2 () throws IOException {
        this.enamy_2= ImageIO.read (Enamy_2.class.getResourceAsStream ("вражеский корабль04.png"));
        this.bullet_enamy_2=ImageIO.read (Enamy_2.class.getResourceAsStream ("enamy_bullet.png"));

        x_e_2 = 1000;
        y_e_2 = 0;
        x_e2_b=x_e_2 +enamy_2.getWidth (null)/2;
        y_e2_b=y_e_2+enamy_2.getHeight (null)/2;
    }
public static void draw (Graphics g) {
         y_e_2++;
        g.drawImage (enamy_2,(int)x_e_2,(int)y_e_2,null);
        if(y_e_2>=vip.getHeight ()){
            y_e_2 =-50;
            x_e_2 = (int) (Math.random () * (vip.getWidth () - enamy_2.getWidth (null)));
        }
        y_e2_b+=6;
        g.drawImage (bullet_enamy_2,(int)x_e2_b-20,(int)y_e2_b,null);
        if(y_e2_b>=vip.getHeight ()){
            x_e2_b=x_e_2 +enamy_2.getWidth (null)/2;
            y_e2_b=y_e_2+enamy_2.getHeight (null)/2;
        }
    float x_e_0 = x_e_2;
    float y_e_0 = y_e_2 + enamy_2.getHeight (null);
    float x_e_1 = x_e_2 + enamy_2.getWidth (null);
    float y_e_1 = y_e_2 + enamy_2.getHeight (null);
    // float x_e_2 = x_e_2 + enamy_2.getWidth (null);
    //float y_e_2 = y_e_2;
    float x_p_b_c = bx+(bullet_p.getWidth (null) / 2);
    float y_p_b_c = by+ (bullet_p.getHeight (null) / 2);
    boolean is_bullet = x_e_2<=x_p_b_c&&y_e_2<=y_p_b_c&&x_e_1>=x_p_b_c&&y_e_1>=y_p_b_c;
    g.drawLine ((int)x_e_2,(int)y_e_2,(int)x_e_1,(int)y_e_1);
    if(is_bullet){
        g.drawImage (boom,(int) x_e_2, (int) y_e_2,null);
        y_e_2 = (int) -50;
        x_e_2 = (int) Math.random () * (vip.getWidth () - enamy_2.getWidth (null));
        score_p++;
        if(score_p==8){
            fit.setVisible (false);
            label.setText ("You Win!!!");
            score_p = 0;

        }
    }

    float x_p_b_c2 = bx2+(bullet_p.getWidth (null) / 2);
    float y_p_b_c2 = by2+ (bullet_p.getHeight (null) / 2);
    boolean is_bullet2 = x_e_2<=x_p_b_c2&&y_e_2<=y_p_b_c2&&x_e_1>=x_p_b_c2&&y_e_1>=y_p_b_c2;

    if(is_bullet2){
        y_e_2 = (int) -50;
        x_e_2 = (int) Math.random () * (vip.getWidth () - enamy_2.getWidth (null));
        score_p++;
        if(score_p==8){
            fit.setVisible (false);
            label.setText ("You Win!!!");
            score_p = 0;

        }
    }
    }
}

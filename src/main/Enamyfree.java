package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

import static main.Playr.*;
import static main.Universe.fit;
import static main.Universe.label;
import static main.Universe.vip;

public class Enamyfree {
    private static Image enamy;
    private static Image bullet;
    private static float x;
    private static float y;
    private static float xb;
    private static float yb;
    private static float a;
    private static float b;

    public Enamyfree (String name_eanamy,String name_bullet) throws IOException {
        this.enamy = ImageIO.read (Enamyfree.class.getResourceAsStream (name_eanamy));
        this.bullet = ImageIO.read(Enamyfree.class.getResourceAsStream (name_bullet));
        this.x=0;
        this.y=0;

    }
    public Enamyfree () throws IOException {
        this.enamy = ImageIO.read (Enamyfree.class.getResourceAsStream ("вражеский корабль01.png"));
        this.bullet = ImageIO.read(Enamyfree.class.getResourceAsStream ("enamy_bullet.png"));
        this.x=0;
        this.y=0;
    }


    public  static void draw(Graphics g,float a,float b,float c){


        y++;
        g.drawImage (enamy, (int) ((int)x+a), (int)((int)y+b), null);
        if(y>=vip.getHeight()){
            y =(int) -c;
            x = (int) (Math.random () * (vip.getWidth () - enamy.getWidth (null)));
        }
        yb+=6;
        g.drawImage (bullet,(int)xb-20,(int)yb,null);
        if (yb>=vip.getHeight ()){
            xb=(x+a)+(enamy.getWidth (null)/2);
            yb=(y+b)+(enamy.getHeight(null)/2);
        }


        float x_e_0 =x+a;
        float y_e_0 = (y + b) + enamy.getHeight (null);
        float x_e_1 =(x + a) + enamy.getWidth (null);
        float y_e_1 = (y + b) + enamy.getHeight (null);
        float x_e_2 = (x + a) + enamy.getWidth (null);
        float y_e_2 = y+b;
        float x_p_b_c = bx+(bullet_p.getWidth (null) / 2);
        float y_p_b_c = by+ (bullet_p.getHeight (null) / 2);
        g.drawLine((int)(x+a),(int)(y+b),(int)x_e_1,(int)y_e_1);
        boolean is_bullet = (x+a)<=x_p_b_c &&(y+b)<=y_p_b_c&&x_e_1>=x_p_b_c&&y_e_1>=y_p_b_c;
        if(is_bullet){
            g.drawImage (boom,(int) a, (int) b,null);
            y = (int) -b;
            x = (int) Math.random () * (vip.getWidth () - enamy.getWidth (null));
            //score_p++;
            //if(score_p==8){
            //    System.exit (0);
            //    fit.setVisible (false);
            //    label.setText ("You Win!!!");
            //    score_p = 0;
            }
    }
}
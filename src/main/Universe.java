package main;

import jdk.nashorn.internal.scripts.JO;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.security.Key;

public class Universe extends JFrame implements KeyListener {
    private static Universe fit;
    private static Image karable;
    private static Image bacground;
    private static Image bullet;
    private static Image enamy;
    private static Image enamy_bullet;
    private static long  last_frame_time = System.nanoTime();
    private static Pole vip;
    private static float x=200;
    private static float y=500;
    private static float v=200;
    private static float top=200;
    private static float botom=700;
    private static float enamy_top=-100;
    private static float enamy_botom=200;
    private static float enamy_bullet_top=-100;
    private static float enamy_bullet_botom=200;

    public Universe(){
        addKeyListener(this);
    }
    public static void main(String[] args) throws IOException {
        fit = new Universe();
        fit.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fit.setTitle("Uneverse");
        fit.setSize(800, 700);

        vip = new Pole();
        last_frame_time = System.nanoTime();
        vip.setSize(800, 700);;
        vip.setVisible(true);
        bacground = ImageIO.read(Universe.class.getResourceAsStream("oboik.ru_60754.jpg"));
        karable = ImageIO.read(Universe.class.getResourceAsStream("player_2_straight_idle.gif"));
        bullet=ImageIO.read(Universe.class.getResourceAsStream("261-iconimg.png"));
        enamy_bullet=ImageIO.read(Universe.class.getResourceAsStream("enamy_bullet.png"));
        enamy=ImageIO.read(Universe.class.getResourceAsStream("ename.png"));
        fit.add(vip, BorderLayout.CENTER);
        fit.setVisible(true);

        }





    @Override
    public void keyTyped(KeyEvent e) {
        //JOptionPane.showMessageDialog(null,e.getKeyText(e.getKeyChar()));


    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 39 && x<700) {
            x+=30;
            getGraphics().drawImage(karable, (int) x,(int) y, null);
        }else if(e.getKeyCode() == 37&& x>0)
            x-=30;
            getGraphics().drawImage(karable,(int) x,(int) y, null);
        if(e.getKeyCode()==40 && y<530) {
            y+=30;
            getGraphics().drawImage(karable,(int) x,(int) y, null);
        }else if(e.getKeyCode()==38 && y>0){
            y-=30;
            getGraphics().drawImage(karable,(int) x,(int) y,null);
        }
        if (e.getKeyCode() == 68) {
             int i=0;
            while (i<100){
                botom--;
                getGraphics().drawImage(bullet,(int)top+((int) karable.getWidth(null)/2), (int) botom,null);
                if(botom == 0){
                    botom=y;
                    top=x;
                }
                i++;
                repaint();
                }

        }}


    @Override
    public void keyReleased(KeyEvent e) {
        //JOptionPane.showMessageDialog(null,e.getKeyCode());

    }
    private static void render(Graphics g){

    }
    private static void onRepaint(Graphics g) {


        long current_time = System.nanoTime();
        float delta_time = (current_time - last_frame_time) * 0.000000001f;
        last_frame_time = current_time;
        enamy_botom = enamy_botom + v * delta_time;
        g.drawImage(bacground, 0, 0, null);
        g.drawImage(karable, (int) x, (int) y, null);
        g.drawImage(enamy, (int) enamy_top, (int) enamy_botom, null);

            if (enamy_botom >700) {

                enamy_botom = -100;
                enamy_top = (int) (Math.random() * (vip.getWidth() - enamy.getWidth(null)));
            }

            enamy_bullet_botom +=2;
            g.drawImage(enamy_bullet,(int)enamy_bullet_top+((int) enamy.getHeight(null)/2), (int)enamy_bullet_botom ,null);
            if(enamy_bullet_botom >700){
                enamy_bullet_botom=enamy_botom;
                enamy_bullet_top=enamy_top;

        }






        //long current_time = System.nanoTime();
        //float delta_time = (current_time - last_frame_time) * 0.000000001f;
        //last_frame_time = current_time;
        //botom = botom + v * delta_time;
//
        //g.drawImage(bullet, (int) top, (int) botom ,null);
    }
    private static class Pole extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            onRepaint(g);
            repaint();

            }
        }
}

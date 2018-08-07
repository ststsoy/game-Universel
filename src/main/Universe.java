package main;

import jdk.nashorn.internal.scripts.JO;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.security.Key;

public class Universe extends JFrame implements KeyListener {
    private static Image karable;
    private static Image bacground;
    private static long last_frame_time;
    private static Pole vip;
    private static float x=200;
    private static float y=200;
    private static float v=0.120f;

    public Universe() throws IOException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Uneverse");
        setSize(800, 700);
        vip = new Pole();
        setSize(800, 700);;
        setVisible(true);
        bacground = ImageIO.read(Universe.class.getResourceAsStream("oboik.ru_60754.jpg"));
        karable = ImageIO.read(Universe.class.getResourceAsStream("images.png"));
        add(vip, BorderLayout.CENTER);
        setVisible(true);
        addKeyListener(this);
    }



    @Override
    public void keyTyped(KeyEvent e) {
        //JOptionPane.showMessageDialog(null,e.getKeyText(e.getKeyChar()));

    }

    @Override
    public void keyPressed(KeyEvent e) {
        long current_time =System.nanoTime();
        float delta_time = (current_time - last_frame_time)*0.000000001f;
        last_frame_time=current_time;
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
    }

    

    @Override
    public void keyReleased(KeyEvent e) {
        //JOptionPane.showMessageDialog(null,e.getKeyCode());

    }
    private static void onRepaint(Graphics g) {
        g.drawImage(bacground,0,0,null);
        g.drawImage(karable,(int) x,(int) y,null);

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

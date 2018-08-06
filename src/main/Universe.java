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
    private static Pole vip;
    private static int x;
    private static int y;

    public Universe() throws IOException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Uneverse");
        setSize(800, 700);
        vip = new Pole();
        setSize(800, 700);
        vip.setBackground(Color.BLACK);
        setVisible(true);
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
        if (e.getKeyCode() == 39 && x<550) {
            vip.getGraphics().drawImage(karable, x++, y, null);
            repaint();
            }else if(e.getKeyCode() == 37&& x>0)
            getGraphics().drawImage(karable, x--, y, null);
        if(e.getKeyCode()==40 && y<430) {
            getGraphics().drawImage(karable, x, y++, null);
        }else if(e.getKeyCode()==38 && y>0){
            getGraphics().drawImage(karable,x,y--,null);
        }

    }

    

    @Override
    public void keyReleased(KeyEvent e) {
        //JOptionPane.showMessageDialog(null,e.getKeyCode());

    }
    private static void onRepaint(Graphics g) {

        g.drawImage(karable,x,y,null);
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

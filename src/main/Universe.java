package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Universe extends JFrame{
    public static Universe fit;
    private static Image bacground;
    public static Pole vip;
    private static Settings settings;
    public static JLabel label;
    private static int score_k;
    public static int score_e;
    private static GraphicsDevice gd;
    public static int width;
    public static int hieght;
    private static int baground_y=0;
    private static int baground_x=0;
    private static int baground_y1=-900;
    private static int baground_x1=0;
    private static Playr playr;
    private static Enamy enamy11;
    private static Enamy_2 enamy_2;

    public static BufferedImage enamy;
    public Universe () {
        addKeyListener (new Listner ());
    }

    public static void main (String[] args) throws IOException {
        gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        width = gd.getDisplayMode().getWidth();
        hieght = gd.getDisplayMode().getHeight();
        settings = new Settings ();
        settings.setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
        settings.setTitle ("Settings");
        settings.setSize (700,500);
        settings.setLocation ((width/2)-350,hieght/2-250);
        Settings.Panel panel = new Settings.Panel ();
        panel.setLocation (100,200);

        JButton button = new JButton ();
        JButton button2=new JButton ();
        button.setSize (100,50);
        button.setLabel ("Start");
        button2.setLabel ("exit");
        button2.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed (ActionEvent e) {
                settings.setVisible (false);
            }
        });

        button.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed (ActionEvent e) {
                push();
            }
        });
        JTextField textField = new JTextField ();
        textField.setSize (400,200);
        panel.setSize (200,400);
        label =new JLabel ("Hello!!!",10);
        label.setSize(200,400);
        panel.add(button,BorderLayout.NORTH);
        panel.add(button2,BorderLayout.SOUTH);
        panel.add(textField);
        settings.add (label,BorderLayout.CENTER);
        settings.add(panel,BorderLayout.CENTER);
        settings.add (textField,BorderLayout.SOUTH);
        settings.setVisible (true);
        fit = new Universe ();
        fit.setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
        fit.setTitle ("Uneverse");
        fit.setSize (width, hieght);
        vip = new Pole ();
        vip.setSize (fit.getWidth (), fit.getHeight ());

        bacground = ImageIO.read (Universe.class.getResourceAsStream ("fon.jpg"));
        fit.add (vip, BorderLayout.CENTER);
        fit.setVisible (false);
        Playr playr = new Playr ();
        Enamy enamy11 = new Enamy ();
        Enamy_2 enamy_2=new Enamy_2 ();
        Listner listner = new Listner ();
    }
    public static void push(){
        fit.setVisible (true);
        fit.setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
    }


    public void moveBacground(){

    }
    private static void onRepaint (Graphics g)  {
        baground_y+=2;
        if(baground_y==900) baground_y=0;
        g.drawImage (bacground, baground_x, baground_y, null);
        baground_y1+=2;
        if(baground_y1==0) baground_y1=-900;
        g.drawImage (bacground, baground_x1, baground_y1, null);

        playr.draw (g);
        enamy11.draw (g);
        enamy_2.draw (g);
    }
    public static class Pole extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            onRepaint(g);
            repaint();
        }
    }
}
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
import java.util.jar.JarEntry;

public class Universe extends JFrame implements KeyListener {
    private static Universe fit;
    private static Image bacground;
    private static Image karable; //Корабль игрока
    private static Image bullet;// Пуля игрока
    private static Image enamy;   // Корабль врага
    private static Image enamy_bullet;  // Пуля враг а
    private static long last_frame_time = System.nanoTime ();
    private static Pole vip;
    private static float v = 200;// Скорость игрока
    private static float v_e = 400; // Скорость врага
    private static float x_k=200; // Кордината X игрока корабля
    private static float y_k=500; // Кордината Y игрока корабля
    private static float x_k_b = 200;// Кордината X игрока пули
    private static float y_k_b = 500; // Кордината Y игрока пули
    private static float x_e = -100; // Кордината X врага корабля
    private static float y_e = 200; // Кордината Y врага корабля
    private static float x_e_b = -100;// Кордината X врага пули
    private static float y_e_b = 200;// Кордината X врага пули
    private static Settings settings;
    private static JTextArea textArea;
    private static JLabel label;
    private static int score_k;
    private static int score_e;
    public Universe () {
        addKeyListener (this);
    }

    public static void main (String[] args) throws IOException {
        settings = new Settings ();
        settings.setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
        settings.setTitle ("Settings");
        settings.setSize (200,400);
        Settings.Panel panel = new Settings.Panel ();
        panel.setLocation (100,200);

        JButton button = new JButton ();
        JButton button2=new JButton ();
        button.setSize (100,50);
        button.setLabel ("Start");
        button2.setLabel ("exit");

        button.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed (ActionEvent e) {
                push();

            }
        });
        JTextField textField = new JTextField ();
        textField.setSize (400,200);
        panel.setSize (200,400);
        label =new JLabel ("Hello!!!");
        panel.add(button,BorderLayout.NORTH);
        panel.add(button2,BorderLayout.SOUTH);
        panel.add(textField);
        panel.add (label);

        settings.add(panel,BorderLayout.CENTER);
        settings.add (textField,BorderLayout.SOUTH);
        settings.setVisible (true);
        fit = new Universe ();
        fit.setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
        fit.setTitle ("Uneverse");
        fit.setSize (800, 700);
        //GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        //d.setFullScreenWindow(fit);
        //fit.setExtendedState(JFrame.MAXIMIZED_BOTH);

        vip = new Pole ();
        last_frame_time = System.nanoTime ();
        vip.setSize (fit.getWidth (), fit.getHeight ());

        vip.setVisible (true);
        bacground = ImageIO.read (Universe.class.getResourceAsStream ("oboik.ru_60754.jpg"));
        karable = ImageIO.read (Universe.class.getResourceAsStream ("karable.png"));
        bullet = ImageIO.read (Universe.class.getResourceAsStream ("261-iconimg.png"));
        enamy = ImageIO.read (Universe.class.getResourceAsStream ("ename.png"));
        enamy_bullet = ImageIO.read (Universe.class.getResourceAsStream ("enamy_bullet.png"));
        fit.add (vip, BorderLayout.CENTER);
        fit.setVisible (false);
        System.out.println (fit.getHeight ()+" "+fit.getWidth ());
    }
    private static void push(){
        fit.setVisible (true);
    }

    @Override
    public void keyTyped (KeyEvent e) {
        //JOptionPane.showMessageDialog(null,e.getKeyText(e.getKeyChar()));
    }

    @Override
    public void keyPressed (KeyEvent e) {
        if (e.getKeyCode () == 39 && x_k < 700) {
            x_k += 30;
            getGraphics ().drawImage (karable, (int) x_k, (int) y_k, null);
        } else if (e.getKeyCode () == 37 && x_k > 0)
            x_k -= 30;
        getGraphics ().drawImage (karable, (int) x_k, (int) y_k, null);
        if (e.getKeyCode () == 40 && y_k < 530) {
            y_k += 30;
            getGraphics ().drawImage (karable, (int) x_k, (int) y_k, null);
        } else if (e.getKeyCode () == 38 && y_k > 0) {
            y_k -= 30;
            getGraphics ().drawImage (karable, (int) x_k, (int) y_k, null);
        }

        if (e.getKeyCode () == 68) {

            //g.drawImage(enamy, (int) enamy_top, (int) enamy_botom, null);


        }
}


    @Override
    public void keyReleased (KeyEvent e) {
        //JOptionPane.showMessageDialog(null,e.getKeyCode());
    }


    private static void onRepaint (Graphics g) {
        long current_time = System.nanoTime ();
        float delta_time = (current_time - last_frame_time) * 0.000000001f;
        last_frame_time = current_time;
        g.drawImage (bacground, 0, 0, null);
        g.drawImage (karable, (int) x_k, (int)y_k, null);
        y_e = y_e + v * delta_time;
        g.drawImage (enamy, (int) x_e, (int) y_e, null);
        y_e_b = y_e_b + v_e * delta_time;
        g.drawImage (enamy_bullet, (int) x_e_b + ((int) enamy.getHeight (null) / 2 - 30), (int) y_e_b, null);
        if (y_e > vip.getHeight ()) {
            y_e =-100;
            x_e = (int) (Math.random () * (vip.getWidth () - enamy.getWidth (null)));
        }
        if(y_e_b >vip.getHeight()){
             x_e_b=x_e;
             y_e_b=y_e;
        }
        float x_k_0=x_k;
        float y_k_0=y_k+karable.getWidth(null);
        float x_k_1=x_k+karable.getHeight(null);
        float y_k_1=y_k+karable.getWidth(null);
        float x_k_2=x_k+karable.getHeight(null);
        float y_k_2=y_k;
        float x_e_b_c = x_e_b+(enamy_bullet.getWidth (null)/2);
        float y_e_b_c = y_e_b+(enamy_bullet.getHeight (null)/2);
        boolean is_bullet2= x_k<=x_e_b_c&&y_k<=y_e_b_c&&x_k_1>=x_e_b_c&&y_k_1>=y_e_b_c;
        if(is_bullet2){
           x_k=700;
           y_k=500;
           score_e++;
           if(score_e==3){
               fit.setVisible (false);
               label.setText ("You lose!!!");
               score_e=0;
               x_e_b=x_e;
               y_e_b=y_e;
           }
        }
        y_k_b--;
        g.drawImage (bullet, (int) x_k_b + (karable.getWidth (null) / 2)-20, (int) y_k_b, null);
        if (y_k_b == 0) {
            x_k_b = x_k;
            y_k_b = y_k;
        }
        float x_e_0 = x_e;
        float y_e_0 = y_e + enamy.getWidth (null);
        float x_e_1 = x_e + enamy.getHeight (null);
        float y_e_1 = y_e + enamy.getWidth (null);
        float x_e_2 = x_e + enamy.getHeight (null);
        float y_e_2 = y_e;
        float x_k_b_c = x_k_b +(bullet.getHeight (null) / 2);
        float y_k_b_c = y_k_b + (bullet.getWidth (null) / 2);
        boolean is_bullet = x_e<=x_k_b_c&&y_e<=y_k_b_c&&x_e_1>=x_k_b_c&&y_e_1>=y_k_b_c;

        if (is_bullet) {
            y_e = (int) -100;
            x_e = (int) Math.random () * (fit.getWidth () - enamy.getWidth (null));

            x_k_b = x_k;
            y_k_b = y_k;
            score_k++;

            if(score_k==3){
                fit.setVisible (false);
               settings.setTitle ("You win");
               label.setText ("You win!!!!");
               score_k=0;
            }
        }
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

package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listner implements KeyListener {


    @Override
    public void keyTyped (KeyEvent e) {

    }

    @Override
    public void keyPressed (KeyEvent e) {
        int key =e.getKeyCode ();
        if(key==KeyEvent.VK_W){
           Playr.up =true;
        }
        if (key==KeyEvent.VK_S){
            Playr.down=true;
        }
        if(key==KeyEvent.VK_D){
            Playr.right=true;
        }
        if(key==KeyEvent.VK_A){
            Playr.left=true;
        }

    }

    @Override
    public void keyReleased (KeyEvent e) {
        int key =e.getKeyCode ();
        if(key==KeyEvent.VK_W){
            Playr.up =false;
        }
        if (key==KeyEvent.VK_S){
            Playr.down=false;
        }
        if(key==KeyEvent.VK_D){
            Playr.right=false;
        }
        if(key==KeyEvent.VK_A){
            Playr.left=false;
        }

    }
}

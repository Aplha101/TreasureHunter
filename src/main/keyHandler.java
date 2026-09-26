package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyHandler implements KeyListener{
    public boolean U,D,L,R,E;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W){
            U = true;
        }
        if(code == KeyEvent.VK_A){
            L = true;
        }
        if(code == KeyEvent.VK_S){
            D = true;
        }
        if(code == KeyEvent.VK_D){
            R = true;
        }
        if(code == KeyEvent.VK_E){
            E = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W){
            U = false;
        }
        if(code == KeyEvent.VK_A){
            L = false;
        }
        if(code == KeyEvent.VK_S){
            D = false;
        }
        if(code == KeyEvent.VK_D){
            R = false;
        }
    }
    
}
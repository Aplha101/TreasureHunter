package main;

import javax.swing.JPanel;

import entity.player;
import entity.treasure;
import tile.TileManager;
import entity.bar;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class GamePanel extends JPanel implements  Runnable{ 
    //screen settting

    final int original = 16; // 32x32
    final int scale = 3;
    public final int tileSize = original * scale;

    public final int maxCol = 32;
    public final int maxRow = 16;

    public final int screenWidth =  tileSize * maxCol;
    public final int screenHeight = tileSize * maxRow;

    int FPS = 60;
    TileManager tileM = new TileManager(this);
    keyHandler keyH = new keyHandler();
    Thread gameThread;

    player player = new player(this , keyH); 
    treasure treasure = new treasure(this  , keyH , player); 
    bar bar = new bar(this);
    

        public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth , screenHeight));
        this.setBackground(Color.green);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();//calls run()
    }

    @Override
    public void run() {
        //gameThread auto calls run() basically like an int main() but a game loop
        //game loop
    double drawInterval = 1000000000/FPS; // 1/60 seconds
       double delta = 0;
       long lastTime = System.nanoTime();
       long currentTime ;
       

       while(gameThread != null){
        currentTime = System.nanoTime();
        delta += (currentTime - lastTime) / drawInterval;
        lastTime = currentTime;

        if(delta >= 1){
            update();
            repaint();
            delta--;
        }
       }
    }
    public void update(){
        player.update();
        player.limits();
        treasure.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);    
        Graphics2D g2 = (Graphics2D)g;

        tileM.draw(g2);
        player.draw(g2);
        treasure.draw(g2);
        double closeness = treasure.current_distance_from_user();
        bar.draw(g2 ,  closeness);
        g2.dispose();

    }
}
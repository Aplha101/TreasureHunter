package entity;

import main.GamePanel;
import main.keyHandler;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
public class treasure extends entity{
    GamePanel gp;
    keyHandler keyH;
    player p;
    public boolean isFound = false;
    public treasure(GamePanel gp , keyHandler keyH , player p){
        this.gp = gp;
        this.keyH = keyH;
        this.p = p;
        setDefaultValues();
        getTreasureImage();
    }
    public void setDefaultValues(){
         // 3072 x 3072
        Random rand = new Random();
        x = rand.nextInt(1536);
        y = rand.nextInt(728);
    }
    public void getTreasureImage(){
       try{
            image = ImageIO.read(getClass().getResourceAsStream("/treasure/treasure.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void update() {
        if (!isFound && keyH.E && current_distance_from_user() >= 0.98) {
            isFound = true;
            System.out.println("found");
        }
    }
    public void draw(Graphics2D g2){
        if (isFound) {
            g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
        }

    }
    public double current_distance_from_user(){
       
    double currentDistance = Math.sqrt(
        Math.pow(p.x - x, 2) +
        Math.pow(p.y - y, 2)
    );

    double closeness = 1.0 - (currentDistance / 364.0);

    // Keep between 0 and 1
    closeness = Math.max(0.0, Math.min(1.0, closeness));

    System.out.println(
        "close = " + (closeness * 100) + "%\n" +
        "current = " + currentDistance
    );

    return closeness;
    }
}
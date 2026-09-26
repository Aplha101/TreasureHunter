package entity;
import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.keyHandler;


public class player extends entity {
    GamePanel gp;
    keyHandler keyH;
    public player(GamePanel gp, keyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
         getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 3;
    }
    public void getPlayerImage(){
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/player/player.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void update() {
        if (keyH.U) {
            y -= speed;
        } else if (keyH.D) {
            y += speed;
        } else if (keyH.L) {
            x -= speed;
        } else if (keyH.R) {
            x += speed;
        }
        limits();
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
    public void limits() {
    if (x < 0)
    x = 0;
    if (x > gp.screenWidth - gp.tileSize)
        x = gp.screenWidth - gp.tileSize;
    if (y < 40)
        y = 40;
    if (y > gp.screenHeight - gp.tileSize)
        y = gp.screenHeight - gp.tileSize;
    }
}
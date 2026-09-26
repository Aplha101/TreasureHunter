package entity;

import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

public class bar extends entity {
    GamePanel gp;
    public bar(GamePanel gp){
        this.gp = gp;
        setDefaultValues();
        getBarImage();
    }
    public void setDefaultValues(){
        x = 0;
        y =  10;
    }
    public void getBarImage(){
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/bar/bar.png"));
        }catch(IOException e){
            e.getStackTrace();
        }
    }
   public void draw(Graphics2D g2, double width) {
 int barWidth = gp.screenWidth / 2;
    int barHeight = 60;
    width = Math.max(0, Math.min(1, width));
    int sourceWidth = (int)(image.getWidth() * width);

    int destinationWidth = (int)(barWidth * width);

    g2.drawImage(
        image,
        x, y, x + destinationWidth, y + barHeight,
        0, 0, sourceWidth, image.getHeight(),
        null
    );
 }
}
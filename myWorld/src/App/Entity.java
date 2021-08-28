package App;

import javax.swing.*;
import java.awt.*;

import static App.GamePanel.SPRITE_HEIGTH;
import static App.GamePanel.SPRITE_WIDTH;

public class Entity {
    private Image grass_spite = new ImageIcon("assets/GrassCenter.png").getImage();

    public void draw(Graphics g,int x , int y){
        g.drawImage(grass_spite,x,y, SPRITE_WIDTH,SPRITE_HEIGTH,null);
    }
}

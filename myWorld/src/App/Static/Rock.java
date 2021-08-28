package App.Static;

import App.Entity;

import javax.swing.*;
import java.awt.*;

import static App.GamePanel.SPRITE_HEIGTH;
import static App.GamePanel.SPRITE_WIDTH;

public class Rock extends Entity {
    int sprite_rock_num;
    public static final Image[] rock_sprites = new Image[] {new ImageIcon("assets/rock_tr_1.png").getImage(),
                                                      new ImageIcon("assets/rock_tr_2.png").getImage()};
    public Rock(int sprite_rock_num) {
        this.sprite_rock_num = sprite_rock_num;
    }
    @Override
    public void draw(Graphics g,int x , int y) {
        super.draw(g,x,y);
        g.drawImage(rock_sprites[sprite_rock_num],x,y, SPRITE_WIDTH,SPRITE_HEIGTH,null);
    }
}

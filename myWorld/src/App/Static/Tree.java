package App.Static;

import App.Entity;

import javax.swing.*;
import java.awt.*;

import static App.GamePanel.SPRITE_HEIGTH;
import static App.GamePanel.SPRITE_WIDTH;

public class Tree extends Entity {

    private final Image tree_sprite = new ImageIcon("assets/tree_tr.png").getImage();

    public Tree() { }

    @Override
    public void draw(Graphics g,int x , int y) {
        super.draw(g,x,y);
        g.drawImage(tree_sprite,x,y, SPRITE_WIDTH,SPRITE_HEIGTH,null);
    }
}

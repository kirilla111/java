package App;

import java.awt.*;
import java.util.ArrayList;

public class Entity {
    private int x;
    private int y;
    private ArrayList<Image> sprites;
    private int sprite_divider;
    private int tick_count;
    private static final int FRAMES_TO_SWITCH_SPRITE = 6;
    public Entity(int x, int y, ArrayList<Image> sprites){
        this.x = x;
        this.y = y;
        this.sprites = sprites;
    }
    public Entity(ArrayList<Image> sprites){
        this.sprites = sprites;
        sprite_divider = 0;
        tick_count = 0;
    }
    public void draw(Graphics g){
        g.drawImage(sprites.get(sprite_divider),100,100, 100,100,null);
        g.drawString("tick_c->"+tick_count+" sprite_d->"+ sprite_divider,50,50);

        if (FRAMES_TO_SWITCH_SPRITE - tick_count > 0) tick_count++;
        else {tick_count = 0; sprite_divider++;}

        if (sprite_divider>sprites.size() - 1) sprite_divider = 0;
    }
//    public void draw(Graphics g){
//        //g.drawImage(sprite,x,y, GamePanel.SPRITE_WIDTH,GamePanel.SPRITE_HEIGTH,null);
//        g.fillRect(x,y,10,10);
//    }
}

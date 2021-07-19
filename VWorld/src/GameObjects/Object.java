package GameObjects;

import GameState.GameState;
import Main.GamePanel;

import java.awt.*;

public class Object {
    public static final int d = GamePanel.WIDTH/GameState.COL_COUNT;

    protected Rectangle pos;
    protected Color background;

    public Object(int x, int y, Color background) {
        this.pos = new Rectangle(x, y, d, d);
        this.background = background;
    }
    public void draw(Graphics g){
        g.setColor(this.background);
        g.fillRect(pos.x,pos.y, pos.width, pos.height);
    }
    public boolean moveFree(){
        return true;
    }
}

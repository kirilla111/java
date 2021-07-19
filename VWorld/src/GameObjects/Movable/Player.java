package GameObjects.Movable;

import GameObjects.MovableObjects;
import GameObjects.Object;

import java.awt.*;

public class Player extends MovableObjects {
    private static final Color pBackground = new Color(241, 18, 18);
    private static final int WIDTH1 = Object.d/2 + Object.d/5;
    public Player(int x, int y) {
        super(x, y, pBackground);
    }

    @Override
    public void draw(Graphics g){
        super.draw(g);
        g.setColor(new Color(160, 13, 13));
        g.fillRect(super.pos.x + super.pos.width/4,super.pos.y + super.pos.height/4, super.pos.width/2,super.pos.height/2);

        switch (super.dimension){
            case left -> {
                g.fillRect(super.pos.x + super.pos.width/2- WIDTH1 ,super.pos.y + super.pos.height/2 - 5 , WIDTH1,10);
                //g.fillRect(super.pos.x + super.pos.width/2 - 5,super.pos.y + super.pos.height/2 - WIDTH1, 10,WIDTH1);
            }
            case right -> {
                g.fillRect(super.pos.x + super.pos.width/2 ,super.pos.y + super.pos.height/2 - 5, WIDTH1,10);
            }
            case top -> {
                g.fillRect(super.pos.x + super.pos.width/2 - 5,super.pos.y + super.pos.height/2 - WIDTH1, 10,WIDTH1);
            }
            case bot -> {
                g.fillRect(super.pos.x + super.pos.width/2 - 5,super.pos.y + super.pos.height/2, 10,WIDTH1);
            }
        }
    }

    public void shot() {
    }
}

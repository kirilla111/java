package GameObjects.Movable;

import GameObjects.*;
import Main.GamePanel;

import java.awt.*;

public class Bullet extends MovableObjects {
    private static final int BULLET_WIDTH = MovableObjects.d / 10;
    private static final int BULLET_HEIGHT = MovableObjects.d / 5;

    public Bullet(int x, int y, GamePanel.movements dimension) {
        super(x, y, new Color(212, 181, 27));
        super.dimension = dimension;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(background);
        switch (super.dimension) {
            case left -> {
                g.fillRect(super.pos.x - super.pos.width/5*2, super.pos.y + super.pos.width / 2 , BULLET_HEIGHT, BULLET_WIDTH);
                break;
            }
            case right -> {
                g.fillRect(super.pos.x + super.pos.width + super.pos.width/5, super.pos.y + super.pos.width / 2, BULLET_HEIGHT,BULLET_WIDTH);
                break;
            }
            case top -> {
                g.fillRect(super.pos.x + super.pos.width / 2 , super.pos.y - super.pos.width/5*2, BULLET_WIDTH, BULLET_HEIGHT);
                break;
            }
            case bot -> {
                g.fillRect(super.pos.x + super.pos.width / 2, super.pos.y + super.pos.width + super.pos.width/5, BULLET_WIDTH, BULLET_HEIGHT);
                break;
            }
        }

        super.move(dimension);
    }
}

package GameObjects;

import Main.GamePanel;

import java.awt.*;

public class MovableObjects extends Object {
    protected GamePanel.movements dimension = GamePanel.movements.top;
    public MovableObjects(int x, int y, Color background) {
        super(x, y, background);
    }

    public static final int speed = 5;

    public Rectangle getPos() {
        return pos;
    }

    public GamePanel.movements getDimension() {
        return dimension;
    }

    public void move(GamePanel.movements m) {
        switch (dimension) {
            case left -> {
                super.pos.x -= speed;
                break;
            }
            case right -> {
                super.pos.x += speed;
                break;
            }
            case top -> {
                super.pos.y -= speed;
                break;
            }
            case bot -> {
                super.pos.y += speed;
                break;
            }
        }
    }

    public void setDim(GamePanel.movements m) {
        dimension = m;
    }
}

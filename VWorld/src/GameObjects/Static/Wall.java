package GameObjects.Static;

import GameObjects.Object;

import java.awt.*;

public class Wall extends Object {
    public Wall(int x, int y) {
        super(x, y, new Color(141, 141, 141));
    }

    @Override
    public boolean moveFree() {return false;}
}

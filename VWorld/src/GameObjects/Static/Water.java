package GameObjects.Static;

import GameObjects.Object;

import java.awt.*;

public class Water extends Object {

    public Water(int x, int y) {
        super(x, y, new Color(0, 0, 0));
    }

    @Override
    public boolean moveFree() {return false;}
}

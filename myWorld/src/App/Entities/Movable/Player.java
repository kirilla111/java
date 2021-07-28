package App.Entities.Movable;

import App.Entities.Entity;

import java.awt.*;
import java.util.ArrayList;

public class Player extends MovableEntity {
    private int pos_x;
    private int pos_y;

    public Player(ArrayList<Image> sprites){
        super(sprites);
    }
}

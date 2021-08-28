package App.Entities.Movable;

import App.Entity;

import java.awt.*;
import java.util.ArrayList;

public class MovableEntity extends Entity {
    protected ArrayList<Image> sprites;

    private int sprite_divider;
    private int tick_count;
    private static final int FRAMES_TO_SWITCH_SPRITE = 10;
    public Point pos;

    public MovableEntity(ArrayList<Image> sprites, Point pos) {
        super();
        this.sprites = sprites;
        sprite_divider = 0;
        tick_count = 0;
        this.pos = pos;
    }

    @Override
    public void draw(Graphics g, int x, int y) {

        g.drawImage(sprites.get(sprite_divider), x, y, 50, 100, null);

        if (FRAMES_TO_SWITCH_SPRITE - tick_count > 0) tick_count++;
        else {
            tick_count = 0;
            sprite_divider++;
        }

        if (sprite_divider > sprites.size() - 1) sprite_divider = 0;
    }

    private static final int MOVE_DELTA = 1;

    public void MoveLeft() {
        this.pos.y -= MOVE_DELTA;
    }

    public void MoveRight() {
        this.pos.y += MOVE_DELTA;
    }

    public void MoveDown() {
        this.pos.x += MOVE_DELTA;
    }

    public void MoveUp() {
        this.pos.x -= MOVE_DELTA;
    }
}

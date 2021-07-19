package GameState;

import GameObjects.Movable.Bullet;
import GameObjects.Movable.*;
import GameObjects.MovableObjects;
import GameObjects.Object;
import GameObjects.Static.*;

import Main.GamePanel;

import java.awt.*;
import java.util.ArrayList;

public class GameState {
    private final ArrayList<Bullet> bullets = new ArrayList<>();
    private enum mapObj {
        wall,
        water,
        ground
    }

    public static final int COL_COUNT = 6;

    private mapObj[][] map = map = new mapObj[][]{
            {mapObj.wall, mapObj.wall, mapObj.ground, mapObj.ground, mapObj.wall, mapObj.wall},
            {mapObj.wall, mapObj.ground, mapObj.ground, mapObj.ground, mapObj.ground, mapObj.wall},
            {mapObj.ground, mapObj.ground, mapObj.ground, mapObj.ground, mapObj.ground, mapObj.ground},
            {mapObj.ground, mapObj.ground, mapObj.ground, mapObj.ground, mapObj.ground, mapObj.ground},
            {mapObj.wall, mapObj.ground, mapObj.ground, mapObj.ground, mapObj.ground, mapObj.wall},
            {mapObj.wall, mapObj.wall, mapObj.ground, mapObj.ground, mapObj.wall, mapObj.wall}
    };

    private Object[][] field;
    private final Player player;

    public GameState() {
        player = new Player(GamePanel.WIDTH / 2 - Object.d / 2, GamePanel.HEIGHT / 2 - Object.d / 2);

        init();
    }
    public void update(){
        for (Bullet bullet: bullets) {
            Rectangle pos = bullet.getPos();

            try {
                if (pos.x < 100 || pos.y<0 || pos.y > GamePanel.HEIGHT || pos.x>GamePanel.WIDTH) bullets.remove(bullet);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println(bullets.size());
    }
    private void init() {
        field = new Object[map.length][map.length];
        int d = Object.d;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                switch (map[i][j]) {
                    case ground -> {
                        field[i][j] = new Ground(i * d, j * d);
                        break;
                    }
                    case wall -> {
                        field[i][j] = new Wall(i * d, j * d);
                        break;
                    }
                    case water -> {
                        field[i][j] = new Water(i * d, j * d);
                        break;
                    }

                }

            }
        }
    }

    public void draw(Graphics g) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j].draw(g);
            }
        }
        player.draw(g);
        for (Bullet bullet:
             bullets) {
            bullet.draw(g);
        }

    }

    public void movePlayer(GamePanel.movements m) {
        Rectangle pos = player.getPos();
        player.setDim(m);
        int speed = MovableObjects.speed;
        Point p1 = new Point();
        Point p2 = new Point();

        switch (m) {
            case left -> {
                p1.x = pos.x - 2*speed;
                p1.y = pos.y;
                p2.x = pos.x - 2*speed;
                p2.y = pos.y + pos.height;

                if (pos.x <= speed) return;
            }
            case right -> {
                p1.x = pos.x + pos.width + speed;
                p1.y = pos.y;
                p2.x = pos.x + pos.width + speed;
                p2.y = pos.y + pos.height;

                if (pos.x + speed + pos.width >= GamePanel.WIDTH) return;
            }
            case top -> {
                p1.x = pos.x;
                p1.y = pos.y - 2*speed;
                p2.x = pos.x + pos.width;
                p2.y = pos.y - 2*speed;

                if (pos.y <= speed) return;
            }
            case bot -> {
                p1.x = pos.x;
                p1.y = pos.y + pos.height + speed;
                p2.x = pos.x + pos.width;
                p2.y = pos.y + pos.height + speed;

                if (pos.y + pos.height + speed >= GamePanel.HEIGHT) return;
            }
        }
        int i1 = p1.y / Object.d;
        int i2 = p2.y / Object.d;

        int j1 = p1.x / Object.d;
        int j2 = p2.x / Object.d;

        if (field[i1][j1].moveFree() && field[i2][j2].moveFree()) player.move(m);


    }
    public void shot() {
        Rectangle pos = player.getPos();
        bullets.add(new Bullet(pos.x,pos.y,player.getDimension()));
    }
}

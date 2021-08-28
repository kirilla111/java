package App;

import App.Entities.Movable.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable, KeyListener {
    public static final int PANEL_WIDTH = 990;
    public static final int PANEL_HEIGHT = 990;
    public static final int GRID_ROW_COUNT = 15;
    public static final int GRID_COL_COUNT = 15;
    public static final int MAP_GRID_COLS_COUNT = 1000;
    public static final int MAP_GRID_ROWS_COUNT = 1000;
    public static final int SPRITE_WIDTH = PANEL_WIDTH/GRID_COL_COUNT;
    public static final int SPRITE_HEIGTH = PANEL_HEIGHT/GRID_ROW_COUNT;

    private Thread thread;
    private boolean running;
    private int FPS = 30;
    private long targetTime = 1000 / FPS;
    private Entity field[][];
    private Player player;

    public GamePanel(){
        setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        setFocusable(true);
        requestFocus();

        running = true;
        if(thread == null) {
            thread = new Thread(this);
            addKeyListener(this);
            thread.start();
        }
    }

    private void init() {
        MapGenerator mg = new MapGenerator(MAP_GRID_ROWS_COUNT, MAP_GRID_COLS_COUNT);
        field = mg.GenerateField();

        Point player_pos = new Point(MAP_GRID_COLS_COUNT /2, MAP_GRID_ROWS_COUNT /2);
        ArrayList<Image> player_sprites = new ArrayList<Image>();
        player_sprites.add(new ImageIcon("assets/hero_imgs/hero_move_stop.png").getImage());
        player = new Player(player_sprites,player_pos);
    }

    public void update() {

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (int i = 0; i < GRID_ROW_COUNT; i++) {
            for (int j = 0; j < GRID_COL_COUNT; j++) {
                //System.out.println("drawn");
                field[i + player.pos.x - GRID_ROW_COUNT/2][j + player.pos.y - GRID_COL_COUNT/2].draw(
                        g,
                        j*SPRITE_WIDTH,
                        i*SPRITE_HEIGTH);
            }
        }

        player.draw(g,SPRITE_WIDTH*GRID_ROW_COUNT/2,SPRITE_HEIGTH*GRID_COL_COUNT/2);


    }

    @Override
    public void run() {
        init();

        long start;
        long elapsed;
        long wait;

        // game loop
        while(running) {

            start = System.nanoTime();

            elapsed = System.nanoTime() - start;

            repaint();
            //System.out.println("repaint ->");
            update();
            //System.out.println("repaint");

            wait = targetTime - elapsed / 1000000;
            if(wait < 0) wait = 5;

            try {
                Thread.sleep(wait);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
        //System.out.println(e.getKeyCode());

//        switch (e.getKeyChar()){
//            case ('q') -> init();
//            case ('a') -> player.MoveLeft();
//            case ('d') -> player.MoveRight();
//            case ('w') -> player.MoveUp();
//            case ('s') -> player.MoveDown();
//            case ('a') -> player_pos
            //default -> throw new IllegalStateException("Unexpected value: " + e.getKeyChar());
        //}
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode() + " " + e.getKeyChar());

        switch (e.getKeyChar()) {
            case ('q') -> {
                init();
            }
            case ('a') -> player.MoveLeft();
            case ('d') -> player.MoveRight();
            case ('w') -> player.MoveUp();
            case ('s') -> player.MoveDown();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.println(e.getKeyCode());
    }

}

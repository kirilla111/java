package App;

import App.Entities.Entity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements Runnable, KeyListener {
    public static final int PANEL_WIDTH = 1000;
    public static final int PANEL_HEIGHT = 1000;
    public static final int GRID_ROW_COUNT = 10;
    public static final int GRID_COL_COUNT = 10;
    public static final int SPRITE_WIDTH = PANEL_WIDTH/GRID_COL_COUNT;
    public static final int SPRITE_HEIGTH = PANEL_HEIGHT/GRID_ROW_COUNT;

    private Thread thread;
    private boolean running;
    private int FPS = 30;
    private long targetTime = 1000 / FPS;
    private Entity field[][];

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
        MapGenerator mg = new MapGenerator(100,300);
        field = mg.GenerateField();

    }

    public void update() {

    }

    Entity test = new Entity(new ImageFactory().GrassSprites);
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        test.draw(g);
        System.out.println("drawn");
        //field[0][0].draw(g);
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

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}

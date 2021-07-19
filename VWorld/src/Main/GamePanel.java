package Main;

import GameState.GameState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements Runnable, KeyListener {
    // dimensions
    public static final int WIDTH = 420*2;
    public static final int HEIGHT = 420*2;
    public static final int SCALE = 1;
    private Thread thread;
    private boolean running;
    private int FPS = 30;
    private long targetTime = 1000 / FPS;
    private Graphics2D g;
    private GameState gs;
    public enum movements{
        left,
        right,
        top,
        bot
    }
    public GamePanel() {
        super();
        setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        setFocusable(true);
        requestFocus();
    }
    public void addNotify() {
        super.addNotify();
        if(thread == null) {
            thread = new Thread(this);
            addKeyListener(this);
            thread.start();
        }
    }
    private void init() {
        running = true;
        gs = new GameState();
    }

    long mills = System.currentTimeMillis();
    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()){
            case ('a'):{
                gs.movePlayer(movements.left);
                break;
            }
            case 'd':{
                gs.movePlayer(movements.right);
                break;
            }
            case 'w':{
                gs.movePlayer(movements.top);
                break;
            }
            case 's':{
                gs.movePlayer(movements.bot);
                break;
            }
            case ' ':{
                if (System.currentTimeMillis() - mills >1000){
                    gs.shot();
                    mills = System.currentTimeMillis();
                }

                break;
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    int i = 0;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        gs.draw(g);
        //g.drawString(""+(i++),10,10);
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
            gs.update();
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

}

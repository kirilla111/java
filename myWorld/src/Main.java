import App.GamePanel;

import javax.swing.*;

public class Main extends JFrame {
    static JFrame window;
    static GamePanel gp;
    public static void main(String[] args) {
        window = new JFrame("MyWorld");
        gp = new GamePanel();
        window.add(gp);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}

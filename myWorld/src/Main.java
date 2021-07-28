import App.GamePanel;

import javax.swing.*;

public class Main extends JFrame {
    public static void main(String[] args) {
        JFrame window = new JFrame("VWorld");
        window.add(new GamePanel());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}

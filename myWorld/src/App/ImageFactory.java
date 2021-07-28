package App;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ImageFactory {
    public ArrayList<Image> GrassSprites;

    public ImageFactory(){
        GrassSprites = new ArrayList<>();
        GrassSprites.add(new ImageIcon("App/flaged_bomb.png").getImage());
        GrassSprites.add(new ImageIcon("App/opened_bomb.png").getImage());
//        GrassSprites.add(new ImageIcon().getImage());
//        GrassSprites.add(new ImageIcon().getImage());
    }
}

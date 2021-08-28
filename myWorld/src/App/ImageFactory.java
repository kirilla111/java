package App;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ImageFactory {
    public ArrayList<Image> GrassSprites;
    public ArrayList<Image> TreeSprites;
    public ArrayList<Image> RockSprites;

    public ImageFactory(){
        GrassSprites = new ArrayList<>();
        TreeSprites = new ArrayList<>();
        RockSprites = new ArrayList<>();

        GrassSprites.add(new ImageIcon("assets/GrassCenter.png").getImage());
        TreeSprites.add(new ImageIcon("assets/GrassCenter.png").getImage());
        TreeSprites.add(new ImageIcon("assets/tree_tr.png").getImage());
        RockSprites.add(new ImageIcon("assets/GrassCenter.png").getImage());
        RockSprites.add(new ImageIcon("assets/rock_tr_1.png").getImage());
        RockSprites.add(new ImageIcon("assets/rock_tr_2.png").getImage());
        //GrassSprites.add(new ImageIcon("assets/opened_bomb.png").getImage());
//        GrassSprites.add(new ImageIcon().getImage());
//        GrassSprites.add(new ImageIcon().getImage());
    }
}

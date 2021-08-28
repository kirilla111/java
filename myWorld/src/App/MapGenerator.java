package App;

import App.Static.Rock;
import App.Static.Tree;

import java.util.Random;

public class MapGenerator {
    private int count_col;
    private int count_row;

    public MapGenerator(int count_col, int count_row){
        this.count_col = count_col;
        this.count_row = count_row;
    }
    public Entity[][] GenerateField(){
        Entity[][] field = new Entity[count_row][count_col];

        ImageFactory imageFactory = new ImageFactory();
        Random rnd = new Random();

        // generating grass
        for (int i = 0; i < count_row; i++) {
            for (int j = 0; j < count_col; j++) {
                field[i][j] = new Entity();
            }
        }

        // generating trees
        for (int i = 0; i < count_row/10; i++) {
            for (int j = 0; j < count_col/10; j++) {
                field[rnd.nextInt(count_row)][rnd.nextInt(count_col)] = new Tree();
            }
        }

        // genereting rocks
        for (int i = 0; i < count_row/8; i++) {
            for (int j = 0; j < count_col/8; j++) {
                field[rnd.nextInt(count_row)][rnd.nextInt(count_col)] = new Rock(rnd.nextInt(Rock.rock_sprites.length));
            }
        }

        return field;
    }
}

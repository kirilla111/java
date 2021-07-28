package App;

import App.Entities.Entity;

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
        for (int i = 0; i < count_row; i++) {
            for (int j = 0; j < count_row; j++) {

            }
        }

        //
        field = new Entity[1][1];
        field[0][0] = new Entity(imageFactory.GrassSprites);
        //

        return field;
    }
}

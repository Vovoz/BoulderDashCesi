package model;

public class Plateau {
    public  Block blocks[][] = new Block[15][32];

    public Plateau() {

        for (int i = 1; i < 14; i++) {
            blocks[i][1] = new Wall();
            blocks[i][31] = new Wall();
        }

        for (int n = 1; n < 14; n++) {
            blocks[n][1] = new Wall();
            blocks[n][31] = new Wall();
        }


        for (int n = 1; n < 14; n++) {
            for (int i = 1; i < 31; i++) {
                blocks[n][i] = new Dirt();
            }
        }
    }
}

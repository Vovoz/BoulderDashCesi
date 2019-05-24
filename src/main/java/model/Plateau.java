package model;

public class Plateau {
    public  Block blocks[][] = new Block[15][32];

    public Plateau() {



        for (int n = 0; n < 15; n++) {
            blocks[n][0] = new Wall();
            blocks[n][31] = new Wall();
        }

        for (int i = 0; i < 32; i++) {
            blocks[0][i] = new Wall();
            blocks[14][i] = new Wall();
        }


        for (int n = 1; n < 14; n++) {
            for (int i = 1; i < 31; i++) {
                blocks[n][i] = new Dirt();
            }
        }
    }
}

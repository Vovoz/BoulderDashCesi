package model;

public class Plateau {
    public  Block blocks[][] = new Block[15][32];

    public Plateau() {

        for (int n = 1; n < 14; n++) {
            for (int i = 1; i < 34; i++) {
                blocks[n][i] = new Dirt();
            }
        }
    }
}

package model;

public class Plateau {
    public  Block blocks[][] = new Block[15][32];

    public Plateau() {

        for (int n = 0+1; n < 15-1; n++) {
            for (int i = 0+1; i < 32-1; i++) {
                blocks[n][i] = new Dirt();
            }
        }
    }
}

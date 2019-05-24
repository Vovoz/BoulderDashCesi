package model;

import java.util.Observable;

public class Plateau extends Observable {
    public  Block blocks[][] = new Block[15][32];

    public int xplayer;
    public int yplayer;

    public Plateau() {


        for (int n = 0; n < 15; n++) {
            this.blocks[n][0] = new Wall();
            this.blocks[n][31] = new Wall();
        }

        for (int i = 0; i < 32; i++) {
            this.blocks[0][i] = new Wall();
            this.blocks[14][i] = new Wall();
        }


        for (int n = 1; n < 14; n++) {
            for (int i = 1; i < 31; i++) {
                this.blocks[n][i] = new Dirt();
            }
        }

        this.blocks[7][15] = new Player();
        this.xplayer = 15;
        this.yplayer = 7;
    }

    public void move(String Direction){
        switch (Direction) {
            case "UP":
        if(yplayer > 1) {
            blocks[yplayer - 1][xplayer] = blocks[yplayer][xplayer];
            blocks[yplayer][xplayer] = new Wall();
            this.yplayer--;
            System.out.println(yplayer);
        }
        break;
        case "DOWN":
            if(yplayer < 15) {
                blocks[yplayer + 1][xplayer] = blocks[yplayer][xplayer];
                blocks[yplayer][xplayer] = new Wall();
                this.yplayer++;
                System.out.println(yplayer);
            }
            break;
            case "LEFT":
                if(xplayer > 1) {
                    blocks[xplayer - 1][yplayer] = blocks[xplayer][yplayer];
                    blocks[xplayer][yplayer] = new Wall();
                    this.xplayer--;
                    System.out.println(xplayer);
                }
                break;
            case "RIGHT":
                if(xplayer < 32) {
                    blocks[xplayer - 1][yplayer] = blocks[xplayer][yplayer];
                    blocks[xplayer][yplayer] = new Wall();
                    this.xplayer--;
                    System.out.println(xplayer);
                }
                break;

    }
        }
}

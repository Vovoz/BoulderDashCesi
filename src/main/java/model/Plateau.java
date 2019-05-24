package model;

import java.util.Observable;

public class Plateau extends Observable {
    public  Block blocks[][] = new Block[15][32];

    public int xplayer;
    public int yplayer;

    private int ndiamond;

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
        this.blocks[5][13] = new Wall();
        this.blocks[5][14] = new Wall();
        this.blocks[5][15] = new Wall();
        this.blocks[5][16] = new Wall();

        this.blocks[4][16] = new Diamond();
        this.blocks[3][16] = new Diamond();
        this.blocks[4][17] = new Diamond();
        this.blocks[3][17] = new Diamond();

        this.blocks[4][18] = new Rock();
        this.blocks[3][19] = new Rock();
        this.blocks[2][17] = new Rock();
        this.blocks[3][18] = new Rock();

        this.blocks[7][15] = new Player();

        this.xplayer = 15;
        this.yplayer = 7;
        this.ndiamond = 0;
    }

    public void move(String direction){
        switch (direction) {
            case "UP":
                this.blocks[yplayer][xplayer].setDirection(direction);
        if(this.blocks[yplayer - 1][xplayer].breakable == true) {
            if(this.blocks[yplayer - 1][xplayer].lootable == true)
                ndiamond++;
            this.blocks[yplayer - 1][xplayer] =  this.blocks[yplayer][xplayer];
            this.blocks[yplayer][xplayer] = new Vide();
            this.yplayer--;
            updateVide(xplayer,yplayer + 1);
        }
        break;
        case "DOWN":
            this.blocks[yplayer][xplayer].setDirection(direction);
            if(this.blocks[this.yplayer + 1][this.xplayer].breakable == true ) {
                if(this.blocks[this.yplayer + 1][this.xplayer].lootable == true)
                    this.ndiamond++;
                this.blocks[this.yplayer + 1][this.xplayer] =  this.blocks[yplayer][xplayer];
                this.blocks[this.yplayer][this.xplayer] = new Vide();
                this.yplayer++;
                updateVide(this.xplayer,this.yplayer - 1);
            }
            break;
            case "LEFT":
                this.blocks[yplayer][xplayer].setDirection(direction);
                if(this.blocks[this.yplayer][this.xplayer - 1].breakable == true ) {
                    if(this.blocks[this.yplayer][this.xplayer - 1].lootable == true)
                        this.ndiamond++;
                    this.blocks[this.yplayer][this.xplayer - 1] =  this.blocks[yplayer][xplayer];
                    this.blocks[this.yplayer][this.xplayer] = new Vide();
                    this.xplayer--;
                    updateVide(this.xplayer + 1,this.yplayer );
                }
                break;
            case "RIGHT":
                this.blocks[yplayer][xplayer].setDirection(direction);
                if(this.blocks[this.yplayer][this.xplayer + 1].breakable == true ) {
                    if(this.blocks[this.yplayer][this.xplayer + 1].lootable == true)
                        this.ndiamond++;
                    this.blocks[this.yplayer][this.xplayer + 1] =  this.blocks[this.yplayer][this.xplayer];
                    this.blocks[this.yplayer][this.xplayer] = new Vide();
                    this.xplayer++;
                    updateVide(this.xplayer - 1,this.yplayer);
                }
                break;
        }
        System.out.println("x " + this.xplayer);
        System.out.println("y " + this.yplayer);

        System.out.println("ndiamond " + this.ndiamond);
    }

    private void updateVide(int x,int y){
        if(this.blocks[y - 1][x].fall == true){
            this.updatefall(x , y - 1);
        }
        if( this.blocks[y - 1][x - 1].fall == true ){
            this.updatefall(x -1, y - 1);
        }
        if(this.blocks[y - 1][x + 1].fall == true ){
            this.updatefall(x  + 1, y - 1);
        }

    }
    private void updatefall(int x,int y) {

        if(this.blocks[y + 1][x] instanceof Vide ){
            this.blocks[y + 1][x] =  this.blocks[y][x];
            this.blocks[y][x] = new Vide();
            this.blocks[y + 1][x].falling = true;
            this.updateVide(x,y);
            this.updatefall(x,y + 1);
        }
        else if( (this.blocks[y + 1][x].fall == true ) ||  this.blocks[y + 1][x] instanceof Wall) {

            if (this.blocks[y][x - 1] instanceof Vide)
                if (this.blocks[y + 1][x - 1] instanceof Vide) {
                    this.blocks[y + 1][x - 1] = this.blocks[y][x];
                    this.blocks[y][x] = new Vide();
                    this.blocks[y + 1][x - 1].falling = true;
                    this.updateVide(x, y);
                    this.updatefall(x - 1,y + 1);
                }
            if (this.blocks[y][x + 1] instanceof Vide)
                if (this.blocks[y + 1][x + 1] instanceof Vide) {
                    this.blocks[y + 1][x + 1] = this.blocks[y][x];
                    this.blocks[y][x] = new Vide();
                    this.blocks[y + 1][x + 1].falling = true;
                    this.updateVide(x, y);
                    this.updatefall(x + 1,y + 1);
                }
        }
        if( (this.blocks[y + 1][x] instanceof Player) && (this.blocks[y][x].falling))
            System.exit(0);
    else
        this.blocks[y][x].falling = false;

    }

}

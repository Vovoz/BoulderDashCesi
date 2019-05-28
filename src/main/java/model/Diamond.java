package model;

public class Diamond extends Fall{

    public Diamond(final int level){
        super(level);
        for(int n=0;n<4;n++)
        this.ximg[n] = 64;

        this.lootable = true;
    }
}

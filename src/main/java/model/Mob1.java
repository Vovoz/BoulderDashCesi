package model;

public class Mob1 extends Mob{

    public Mob1(final int level){
        super(level);
        for(int n=0;n<4;n++)
            this.ximg[n] = 144;
    }

}

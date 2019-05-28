package model;

public class Mob2  extends Mob{

    public Mob2(final int level){
        super(level);
        for(int n=0;n<4;n++)
            this.ximg[n] = 160;
    }
}

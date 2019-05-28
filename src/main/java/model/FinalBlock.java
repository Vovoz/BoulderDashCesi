package model;

public class FinalBlock extends Block{

    public FinalBlock(final int level){
        super(level);
        for(int n=0;n<4;n++)
            this.ximg[n] = 96;


        this.breakable = false;
    }

}

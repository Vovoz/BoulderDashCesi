package model;

public class Dirt extends Block{

    public Dirt(final int level){
        super(level);
        for(int n=0;n<4;n++)
            this.ximg[n] = 16;

    }

    @Override
    public void setLevel(int level) {
        if(level < 3 || level == 4) {
            for(int n=0;n<4;n++)
                this.yimg[n] = (level - 1) * 64;
        }
        else
            for(int n=0;n<4;n++)
                this.yimg[n] = (level - 1 ) * 64 + 16 * n;
    }
}

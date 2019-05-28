package model;

public class Wall extends Block{

    public Wall(final int level){
        super(level);
        for(int n=0;n<4;n++)
            this.ximg[n] = 0;


        this.breakable = false;
    }

    @Override
    public void setLevel(int level) {
        for(int n=0;n<4;n++)
            this.yimg[n] =( level - 1) * 64;

    }
}

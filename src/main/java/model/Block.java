package model;

import java.awt.Image;

public abstract class Block{
    private Image image;
    public int ximg[];
    public int yimg[];

    protected boolean breakable;
    protected boolean lootable;
    protected boolean fall;
    protected boolean falling;
    protected boolean fixed;

    public Block() {
        ximg = new int[4];
        yimg = new int[4];
        setImage();
        setLevel(3);
        breakable = true;
        lootable = false;
        fall = false;
        falling = false;
        fixed = true;
    }

    public Image getImage() {
        return this.image;
    }
     abstract void setImage();

    public void setLevel(int level){
        for(int n=0;n<4;n++)
            this.yimg[n] = (level - 1 ) * 64 + 16 * n;
    }
    public void setDirection(String direction){}

}


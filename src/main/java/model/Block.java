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

    abstract void setDirection(String direction);

}


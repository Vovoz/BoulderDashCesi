package model;

import java.awt.Image;

public abstract class Block{
    private Image image;
    public int ximg;
    public int yimg;

    public boolean breakable;
    public boolean lootable;
    public boolean fall;
    public boolean falling;
    public boolean fixed;

    public Block() {
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


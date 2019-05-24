package model;

import java.awt.Image;

public abstract class Block{
    private Image image;
    public int ximg;
    public int yimg;

    public boolean breakable;
    public boolean lootable;
    public boolean fall;
    public boolean fixed;

    public Block() {
        setImage();
    }

    public Image getImage() {
        return this.image;
    }
    public abstract void setImage();

}


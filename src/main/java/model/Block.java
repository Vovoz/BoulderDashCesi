package model;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

public abstract class Block{
    private Image image;
    public int ximg[];
    public int yimg[];
    public String direction;

    protected boolean breakable;
    protected boolean lootable;
    protected boolean fall;
    protected boolean falling;
    protected boolean fixed;
    protected boolean update;

    public Block(final int level) {
        ximg = new int[4];
        yimg = new int[4];
        setImage();
        setLevel(level);
        breakable = true;
        lootable = false;
        fall = false;
        falling = false;
        fixed = true;
        update = false;
        direction = "DOWN";
    }

    public Image getImage() {
        return this.image;
    }
    public void setImage() {
        try {
            this.image = ImageIO.read(new File( "block.png" ));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setLevel(int level){
        for(int n=0;n<4;n++)
            this.yimg[n] = (level - 1 ) * 64 + 16 * n;
    }
    public void setDirection(String direction){
        this.direction = direction;
    }

}


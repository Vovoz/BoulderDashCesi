package model;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

/**
 * The Class DAOHelloWorld.
 *
 * @author Alexis
 */

public abstract class Block {
    private Image image;
    public int ximg[];
    public int yimg[];
    public String direction;



    private boolean breakable;
    private boolean lootable;
    private boolean fall;
    private boolean falling;
    private boolean fixed;
    private boolean update;


    /**
     * Instantiates a new Plateau.
     *
     * @param level the level
     */

    Block(final int level) {
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
            this.image = ImageIO.read(new File("block.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setLevel(int level) {
        for (int n = 0; n < 4; n++)
            this.yimg[n] = (level - 1) * 64 + 16 * n;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public boolean getBreakable() {
        return breakable;
    }

    public void setBreakable(boolean breakable) {
        this.breakable = breakable;
    }

    public boolean getLootable() {
        return this.lootable;
    }

    public void setLootable(boolean lootable) {
        this.lootable = lootable;
    }

    public boolean getFall() {
        return fall;
    }

    public void setFall(boolean fall) {
        this.fall = fall;
    }

    public boolean getFalling() {
        return falling;
    }

    public void setFalling(boolean falling) {
        this.falling = falling;
    }

    public boolean getFixed() {
        return fixed;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }

    public boolean getUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

}


package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * The Class DAOHelloWorld.
 *
 * @author Alexis
 */

public class Player extends Block{

    private Image image;

    /**
     * Instantiates a new Player.
     *
     * @param level the level
     */

    public Player(final int level){
        super(level);
        for(int n=0;n<2;n++)
            this.ximg[n] = 0;
        for(int n=2;n<4;n++)
            this.ximg[n] = 16;
        for(int n=0;n<4;n++)
            this.yimg[n] = 0;

    }

    public Image getImage() {
        return this.image;
    }
    @Override
    public void setImage() {
        try {
            this.image = ImageIO.read(new File("player.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

     @Override
    public void setDirection(String direction) {
        int y = 0;
        switch (direction) {
            case "UP":
                y=32;
                break;
            case "DOWN":
                y=64;
                break;
            case "LEFT":
                y=16;
                break;
            case "RIGHT":
                y=48;
                break;
            case "DEATH":
                y=80;

                this.ximg[0] = 64;
                this.ximg[1] = 80;
                this.ximg[2] = 64;
                this.ximg[3] = 80;
                break;

            case "WIN":
                y=176;

                this.ximg[0] = 0;
                this.ximg[1] = 16;
                this.ximg[2] = 0;
                this.ximg[3] = 16;
                break;

        }
        for(int n=0;n<4;n++)
            this.yimg[n] = y;
    }
}

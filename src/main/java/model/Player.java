package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Player extends Block{

    private Image image;


    public Player(){
        super();
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
    public void setImage() {
        try {
            this.image = ImageIO.read(new File("player.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

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

        }
        for(int n=0;n<4;n++)
            this.yimg[n] = y;
    }
}

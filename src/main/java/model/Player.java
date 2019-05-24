package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Player extends Block{

    private Image image;


    public Player(){
        super();
        this.ximg = 0;
        this.yimg = 0;
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
        switch (direction) {
            case "UP":
                this.yimg = 32;
                break;
            case "DOWN":
                this.yimg = 64;
                break;
            case "LEFT":
                this.yimg = 16;
                break;
            case "RIGHT":
                this.yimg = 48;
                break;
        }
    }
}

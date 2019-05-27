package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Player extends Block{

    private Image image;


    public Player(){
        super();
        this.ximg[0] = 0;
        this.yimg[0] = 0;
        this.ximg[1] =  16;
        this.yimg[1] = 0;
        this.ximg[2] =  0;
        this.yimg[2] = 0;
        this.ximg[3] =  16;
        this.yimg[3] = 0;
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
                this.yimg[0] = 32;
                this.yimg[1] = 32;
                this.yimg[2] = 32;
                this.yimg[3] = 32;
                break;
            case "DOWN":
                this.yimg[0] = 64;
                this.yimg[1] = 64;
                this.yimg[2] = 64;
                this.yimg[3] = 64;
                break;
            case "LEFT":
                this.yimg[0] = 16;
                this.yimg[1] = 16;
                this.yimg[2] = 16;
                this.yimg[3] = 16;
                break;
            case "RIGHT":
                this.yimg[0] = 48;
                this.yimg[1] = 48;
                this.yimg[2] = 48;
                this.yimg[3] = 48;
                break;

                default:
                    this.yimg[0] = 0;
                    this.yimg[1] = 0;
                    this.yimg[2] = 0;
                    this.yimg[3] = 0;
        }
    }
}

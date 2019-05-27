package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Wall extends Block{

    private Image image;


    public Wall(){
        super();
        this.ximg[0] = 0;
        this.yimg[0] = 0;
        this.ximg[1] =  0;
        this.yimg[1] = 0;
        this.ximg[2] =  0;
        this.yimg[2] = 0;
        this.ximg[3] =  0;
        this.yimg[3] = 0;

        this.breakable = false;
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

    @Override
    void setDirection(String direction) {
    }
}

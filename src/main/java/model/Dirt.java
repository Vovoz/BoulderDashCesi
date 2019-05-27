package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Dirt extends Block{

    private Image image;


    public Dirt(){
        super();
        this.ximg[0] = 16;
        this.yimg[0] = 0;
        this.ximg[1] =  this.ximg[0];
        this.yimg[1] = this.yimg[0];
        this.ximg[2] =  this.ximg[0];
        this.yimg[2] = this.yimg[0];
        this.ximg[3] =  this.ximg[0];
        this.yimg[3] = this.yimg[0];
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

    @Override
    void setDirection(String direction) {
    }
}

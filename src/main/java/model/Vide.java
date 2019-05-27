package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Vide extends  Block{

    private Image image;


    public Vide(){
        super();
        this.ximg[0] = 32;
        this.yimg[0] = 0;
        this.ximg[1] =  32;
        this.yimg[1] = 0;
        this.ximg[2] =  32;
        this.yimg[2] = 0;
        this.ximg[3] =  32;
        this.yimg[3] = 0;
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

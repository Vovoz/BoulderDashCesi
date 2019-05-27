package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Diamond extends Block{
    private Image image;


    public Diamond(){
        super();
        this.ximg[0] = 64;
        this.yimg[0] = 0;
        this.ximg[1] = 64;
        this.yimg[1] = 16;
        this.ximg[2] = 64;
        this.yimg[2] = 32;
        this.ximg[3] = 64;
        this.yimg[3] = 48;



        this.lootable = true;
        this.fall = true;
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

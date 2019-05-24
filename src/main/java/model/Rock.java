package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Rock extends Block {
    private Image image;
    public Rock(){
        super();
        this.ximg = 48;
        this.yimg = 0;
        this.breakable = false;
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

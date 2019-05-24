package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Dirt extends Block{

    private Image image;


    public Dirt(){
        super();
        this.ximg = 16;
        this.yimg = 0;
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
}

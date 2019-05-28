package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FinalBlock extends Block{

    private Image image;


    public FinalBlock(){
        super();
        for(int n=0;n<4;n++)
            this.ximg[n] = 96;


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
}

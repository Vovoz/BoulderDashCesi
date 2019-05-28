package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Mob1 extends Mob{

    private Image image;

    public Mob1(final int level){
        super(level);
        for(int n=0;n<4;n++)
            this.ximg[n] = 144;
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

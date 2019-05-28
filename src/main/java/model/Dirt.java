package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Dirt extends Block{

    private Image image;


    public Dirt(final int level){
        super(level);
        for(int n=0;n<4;n++)
            this.ximg[n] = 16;
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
    public void setLevel(int level) {
        if(level < 3 || level == 4) {
            for(int n=0;n<4;n++)
                this.yimg[n] = (level - 1) * 64;
        }
        else
            for(int n=0;n<4;n++)
                this.yimg[n] = (level - 1 ) * 64 + 16 * n;
    }
}

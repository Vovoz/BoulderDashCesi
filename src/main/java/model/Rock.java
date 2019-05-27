package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Rock extends Block {
    private Image image;

    public Rock(){
        super();
        for(int n=0;n<4;n++)
            this.ximg[n] = 48;


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
    public void setLevel(int level){
        if(level == 5)
            for (int n=0;n<4;n++)
                this.yimg[n] = (level - 1 )* 64;

        else
            for(int n=0;n<4;n++)
                this.yimg[n] = (level - 1 ) * 64 + 16 * n;
    }
}

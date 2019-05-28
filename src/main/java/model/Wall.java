package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Wall extends Block{

    private Image image;


    public Wall(final int level){
        super(level);
        for(int n=0;n<4;n++)
            this.ximg[n] = 0;


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
    public void setLevel(int level) {
        for(int n=0;n<4;n++)
            this.yimg[n] =( level - 1) * 64;

    }
}

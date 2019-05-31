package model;

/**
 * The Class DAOHelloWorld.
 *
 * @author Alexis
 */

public class Vide extends  Block{

    /**
     * Instantiates a new Vide.
     *
     * @param level the level
     */
    public Vide(final int level){
        super(level);
        for(int n=0;n<4;n++)
            this.ximg[n] = 32;

    }

    @Override
    public void setLevel(int level) {
        if (level < 3)
            for(int n=0;n<4;n++)
                this.yimg[n] = (level - 1 ) * 64;

        else
            for(int n=0;n<4;n++)
                this.yimg[n] = (level - 1 ) * 64 + 16 * n;
    }
}

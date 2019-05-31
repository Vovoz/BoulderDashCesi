package model;

/**
 * The Class DAOHelloWorld.
 *
 * @author Alexis
 */

public class Rock extends Fall {

    /**
     * Instantiates a new Rock.
     *
     * @param level the level
     */
    public Rock(final int level){
        super(level);
        for(int n=0;n<4;n++)
            this.ximg[n] = 48;

        this.breakable = false;
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

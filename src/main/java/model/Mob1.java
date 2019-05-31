package model;

/**
 * The Class DAOHelloWorld.
 *
 * @author Alexis
 */

public class Mob1 extends Mob{

    /**
     * Instantiates a new Plateau.
     *
     * @param level the level
     */

    public Mob1(final int level){
        super(level);
        for(int n=0;n<4;n++)
            this.ximg[n] = 144;
    }

}

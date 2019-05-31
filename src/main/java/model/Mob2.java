package model;

/**
 * The Class DAOHelloWorld.
 *
 * @author Alexis
 */

public class Mob2  extends Mob{
    /**
     * Instantiates a new Mob2.
     *
     * @param level the level
     */
    public Mob2(final int level){
        super(level);
        for(int n=0;n<4;n++)
            this.ximg[n] = 160;
    }
}

package model;

/**
 * The Class DAOHelloWorld.
 *
 * @author Alexis
 */

public class Diamond extends Fall{
    /**
     * Instantiates a new Diamond.
     *
     * @param level the level
     */


    public Diamond(final int level){
        super(level);
        for(int n=0;n<4;n++)
        this.ximg[n] = 64;

        this.lootable = true;
    }
}

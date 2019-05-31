package model;

/**
 * The Class DAOHelloWorld.
 *
 * @author Alexis
 */

public class FinalBlock extends Block{
    /**
     * Instantiates a new FinalBlock.
     *
     * @param level the level
     */


    public FinalBlock(final int level){
        super(level);
        for(int n=0;n<4;n++)
            this.ximg[n] = 96;


        this.breakable = false;
    }

}

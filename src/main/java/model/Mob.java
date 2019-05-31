package model;

/**
 * The Class DAOHelloWorld.
 *
 * @author Alexis
 */

abstract class Mob  extends Block{
    /**
 * Instantiates a new Mob.
 *
 * @param level the level
 */

    public Mob(final int level){
        super(level);
        this.breakable = false;
    }
}

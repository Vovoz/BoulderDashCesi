package model;

/**
 * The Class DAOHelloWorld.
 *
 * @author Alexis
 */

abstract public class Fall extends  Block{
    /**
     * Instantiates a new Fall.
     *
     * @param level the level
     */

    public Fall(int level) {
        super(level);
        this.fall = true;
    }
}

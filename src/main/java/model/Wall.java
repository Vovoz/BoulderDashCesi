package model;

/**
 * The Class DAOHelloWorld.
 *
 * @author Alexis
 */

public class Wall extends Block{
    /**
     * Instantiates a new Wall.
     *
     * @param level the level
     */

    public Wall(final int level){
        super(level);
        for(int n=0;n<4;n++)
            this.ximg[n] = 0;


        this.breakable = false;
    }

    @Override
    public void setLevel(int level) {
        for(int n=0;n<4;n++)
            this.yimg[n] =( level - 1) * 64;

    }
}

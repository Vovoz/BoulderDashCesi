package entity;

/**
 * The Class HelloWorld.
 *
 * @author L
 */
public class HelloWorld extends Entity {

    /**
     * The id.
     */
    private int id;

    /**
     * The nom.
     */
    private String nom;

    /**
     * The diamond.
     */
    private int diamond;
    /**
     * The time.
     */
    private int time;

    /**
     * The map.
     */
    private String map;

    /**
     * Instantiates a new hello world.
     *
     * @param id
     *          the id
     * @param nom
     *          the nom
     * @param diamond
     *           the time
     * @param time
     *           the time
     * @param map
     *          the map
     */
    public HelloWorld(final int id, final String nom, final int diamond, final int time, final String map) {
        this.setId(id);
        this.setNom(nom);
        this.setDiamond(diamond);
        this.setTime(time);
        this.setMap(map);

    }

    /**
     * Instantiates a new hello world.
     */
    public HelloWorld() {
        this(0, "", 0, 0, "");
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(final int id) {
        this.id = id;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDiamond() {
        return diamond;
    }

    public void setDiamond(int diamond) {
        this.diamond = diamond;
    }


    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

}

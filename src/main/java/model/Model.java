package model;

import java.sql.SQLException;
import java.util.Observable;

import contract.IModel;
import entity.HelloWorld;

/**
 * The Class Model.
 *
 * @author L
 */
public final class Model extends Observable implements IModel{

    /** The helloWorld. */
    private HelloWorld helloWorld;

    /**
     * Instantiates a new model.
     */
    public Model() {
        this.helloWorld = new HelloWorld();
    }

    /**
     * Gets the hello world.
     *
     * @return the hello world
     */
    /*
     * (non-Javadoc)
     *
     * @see contract.IModel#getMessage()
     */
    public HelloWorld getHelloWorld() {
        return this.helloWorld;
    }

    /**
     * Sets the hello world.
     *
     * @param helloWorld
     *            the new hello world
     */
    private void setHelloWorld(final HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
        this.setChanged();
        this.notifyObservers();
    }

    /**
     * Load hello world.
     *
     * @param code
     *            the code
     */

    @Override
    public void loadHelloWorld(final String code) {
        try {
            final DAOHelloWorld daoHelloWorld = new DAOHelloWorld(DBConnection.getInstance().getConnection());
            this.setHelloWorld(daoHelloWorld.find(code));
        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadHelloWorld(final int map) {
        try {
            final DAOHelloWorld daoHelloWorld = new DAOHelloWorld(DBConnection.getInstance().getConnection());
            this.setHelloWorld(daoHelloWorld.find(map));
        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }




    public void update() {
        this.setChanged();
        this.notifyObservers();
    }

    /**
     * Gets the observable.
     *
     * @return the observable
     */
    /*
     * (non-Javadoc)
     *
     * @see contract.IModel#getObservable()
     */
    public Observable getObservable() {
        return this;
    }
}

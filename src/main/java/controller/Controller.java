package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
import model.Plateau;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Class Controller.
 *
 * @author Alexis Lionel
 */
public final class Controller implements IController {

    /**
     * The view.
     */
    private IView view;

    /**
     * The model.
     */
    public IModel model;

    /**
     * The plateau.
     */

    public Plateau plateau;
    /**
     * The seconde.
     */

    public int seconde;

    /**
     * Instantiates a new controller.
     *
     * @param view  the view
     * @param model the model
     */
    public Controller(final IView view, final IModel model) {
        this.setView(view);
        this.model = model;
    }


    public void buildPlateau(final int map, final int level) {

        this.model.loadHelloWorld(map);

        this.plateau = new Plateau(this.model.getHelloWorld().getMap(), this.model.getHelloWorld().getDiamond(), level);
        this.seconde = this.model.getHelloWorld().getTime();

        Timer t = new Timer(0, new Ticker(this));
        t.start();
    }

    /**
     * Control.
     */
    /*
     * (non-Javadoc)
     *
     * @see contract.IController#control()
     */
    public void control() {
        this.view.printMessage("Choose a level 1-6", "Choose a map 1-5");
    }

    private void setView(final IView pview) {
        this.view = pview;
    }

    public void time() {
        this.seconde--;
        if (this.seconde == 0)
            System.exit(0);
    }

    public void orderPerform(final ControllerOrder controllerOrder) {
        if(!this.plateau.exit)
        switch (controllerOrder) {
            case UP:
                System.out.println("UP");
                this.plateau.movePlayer("UP");
                break;
            case DOWN:
                System.out.println("DOWN");
                this.plateau.movePlayer("DOWN");
                break;
            case LEFT:
                System.out.println("LEFT");
                this.plateau.movePlayer("LEFT");
                break;
            case RIGHT:
                System.out.println("RIGHT");
                this.plateau.movePlayer("RIGHT");
                break;
        }
    }
}
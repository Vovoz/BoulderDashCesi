package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
import model.Plateau;
import dao.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * The Class Controller.
 */
public final class Controller implements IController{

	/**
	 * The view.
	 */
	private IView view;

	/**
	 * The model.
	 */
	public IModel model;

	public Plateau plateau;

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


	public void buildPlateau(final int map,final int level){

		Dao bb = new Dao();
		System.out.println();

		this.plateau = new Plateau(32,15,level);
		this.seconde = 30;
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
		this.view.printMessage("Choose a level 1-6","Choose a map 1-5");
	}
	private void setView(final IView pview) {
		this.view = pview;
	}

	public void time(){
		this.seconde--;
		if(this.seconde == 0)
			System.exit(0);
	}

	public void orderPerform(final ControllerOrder controllerOrder) {
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


class Ticker implements ActionListener {
	private Controller controller;
	private  int n;

	public Ticker(Controller controller){
		this.controller = controller;
		n = 0;
	}

	public void actionPerformed(ActionEvent event) {
		if(n%20 == 0)
			this.controller.plateau.update();

			this.controller.model.update();

		if(n%100 == 0)
			this.controller.time();

		n++;

		if(n == 1000)
			n = 0;
	}
}

package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
import model.Model;
import model.Plateau;

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

	/**
	 * Instantiates a new controller.
	 *
	 * @param view  the view
	 * @param model the model
	 */
	public Controller(final IView view, final IModel model) {
		this.model = model;
		this.plateau = new Plateau(32,15);

		Timer t = new Timer(10, new Ticker(this));
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


		if(n%3 == 0)
			this.controller.model.update();

		n++;

		if(n == 1000)
			n = 0;
	}
}

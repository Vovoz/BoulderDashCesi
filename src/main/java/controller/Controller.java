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
	private IModel model;

	public Plateau plateau;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view  the view
	 * @param model the model
	 */
	public Controller(final IView view, final IModel model) {
		this.model = model;
		this.plateau = new Plateau();

		Timer t = new Timer(1000, new Ticker());
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
				this.plateau.move("UP");
				break;
			case DOWN:
				System.out.println("DOWN");
				this.plateau.move("DOWN");
				break;
			case LEFT:
				System.out.println("LEFT");
				this.plateau.move("LEFT");
				break;
			case RIGHT:
				System.out.println("RIGHT");
				this.plateau.move("RIGHT");
				break;
		}
		this.model.update();
	}
}

class Ticker implements ActionListener {
	private boolean tick = true;

	public void actionPerformed(ActionEvent event) {
		if (tick) {
			System.out.println("Tick...");
		} else {
			System.out.println("Tock...");
		}
		tick = !tick;
		Model model = new Model();
		model.update();
	}
}

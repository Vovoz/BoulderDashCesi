package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
import model.Plateau;


/**
 * The Class Controller.
 */
public final class Controller implements IController {

	/** The view. */
	private IView		view;

	/** The model. */
	private IModel	model;

	public Plateau	plateau;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model) {
		this.model = model;
		this.plateau = new Plateau();
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

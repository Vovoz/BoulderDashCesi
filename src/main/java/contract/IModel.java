package contract;

import java.util.Observable;

import entity.HelloWorld;

/**
 * The Interface IModel.
 *
 * @author L
 */
public interface IModel {

	/**
	 * Gets the hello world.
	 *
	 * @return the helloworld entity
	 */
	HelloWorld getHelloWorld();

	/**
	 * Load the message.
	 *
	 * @param code
	 *          the code
	 */
	void loadHelloWorld(String code);
	void loadHelloWorld(int map);

	void update();
	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
}

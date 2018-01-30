package appCore;

import strategy.AlgoStrategies;

// TODO: Auto-generated Javadoc
/**
 * The Interface Capteur.
 */
public interface Capteur extends Subject {

	/**
	 * Attach.
	 *
	 * @param o the o
	 */
	public void attach(Observer o);

	/**
	 * Detach.
	 *
	 * @param o the o
	 */
	public void detach(Observer o);

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public int getValue();

	/**
	 * Tick.
	 */
	public void tick();


	/**
	 * Gets the algo.
	 *
	 * @return the algo
	 */
	public AlgoStrategies getAlgo();
}

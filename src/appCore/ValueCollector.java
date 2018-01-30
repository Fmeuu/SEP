package appCore;

import java.util.concurrent.Callable;


// TODO: Auto-generated Javadoc
/**
 * The Class ValueCollector.
 */
public class ValueCollector implements Callable<Integer> {

	/** The capteur. */
	private CapteurImpl capteur;
	
	/**
	 * Instantiates a new value collector.
	 *
	 * @param capteur the capteur
	 */
	public ValueCollector (CapteurImpl capteur){
		this.capteur = capteur;
	}
	
	/* (non-Javadoc)
	 * @see java.util.concurrent.Callable#call()
	 */
	@Override
	public Integer call() throws Exception {
		return this.capteur.getValue();	
		}

}

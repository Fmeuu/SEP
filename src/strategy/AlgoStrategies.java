package strategy;

import appCore.Canal;
import appCore.CapteurImpl;

// TODO: Auto-generated Javadoc
/**
 * The Interface AlgoStrategies.
 */
public interface AlgoStrategies {

	/**
	 * Configure.
	 */
	public void configure(int nbCanal);
	
	/**
	 * Execute.
	 */
	public void execute();
	
	/**
	 * Sets the capteur.
	 *
	 * @param capteurImplEntry the new capteur
	 */
	public void setCapteur(CapteurImpl capteurImplEntry);
	
	/**
	 * Adds the canal.
	 *
	 * @param canalEntry the canal entry
	 */
	public void addCanal(Canal canalEntry);
	
	public void checkWaiting();
}

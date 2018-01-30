package appCore;

import strategy.AlgoStrategies;

// TODO: Auto-generated Javadoc
/**
 * The Class CapteurImpl.
 */
public class CapteurImpl implements Capteur {
	
	/** The strategies. */
	private AlgoStrategies strategies;
	
	/** The compteur. */
	private int compteur = 0;
	
	/* (non-Javadoc)
	 * @see appCore.Capteur#attach(appCore.Observer)
	 */
	@Override
	public void attach(Observer o) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see appCore.Capteur#detach(appCore.Observer)
	 */
	@Override
	public void detach(Observer o) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see appCore.Capteur#getValue()
	 */
	@Override
	public int getValue() {
		return compteur;
		}

	/* (non-Javadoc)
	 * @see appCore.Capteur#tick()
	 */
	@Override
	public void tick() {
		compteur++;
		this.strategies.execute();
	}

	/* (non-Javadoc)
	 * @see appCore.Capteur#getAlgo()
	 */
	@Override
	public AlgoStrategies getAlgo() {
		return this.strategies;
	}
	
	/**
	 * Sets the strategies.
	 *
	 * @param algo the new strategies
	 */
	public void setStrategies(AlgoStrategies algo){
		this.strategies = algo;
	}

}

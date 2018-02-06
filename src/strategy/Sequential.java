package strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

import appCore.Canal;
import appCore.Capteur;
import appCore.CapteurImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class Sequential.
 */
public class Sequential implements AlgoStrategies {

	/** The capteur. */
	private Capteur capteur;
	
	/** The list canal. */
	private List <Canal> listCanal = new ArrayList<Canal>();
	
	/** The ready. */
	private boolean ready = true;
	
	/** The lecture. */
	private boolean lecture = true;
	
	/** The value. */
	private int value;
	
	/** The copy. */
	private int copy;
	
	/** The compteur. */
	private int compteur = 0;
	
	/** The semaphore. */
	private Semaphore semaphore;
	
	
	/* (non-Javadoc)
	 * @see strategy.AlgoStrategies#configure(int)
	 */
	@Override
	public void configure(int nbCanal) {
		semaphore = new Semaphore(1);
	}

	/* (non-Javadoc)
	 * @see strategy.AlgoStrategies#execute()
	 */
	@Override
	public void execute() {
		if(ready){
			ready = false;
			for (Canal l : listCanal) {
				l.update(capteur);
			}
		}
	}

	/* (non-Javadoc)
	 * @see strategy.AlgoStrategies#setCapteur(appCore.CapteurImpl)
	 */
	@Override
	public void setCapteur(CapteurImpl capteur) {
		this.capteur = capteur;
	}

	/* (non-Javadoc)
	 * @see strategy.AlgoStrategies#addCanal(appCore.Canal)
	 */
	@Override
	public void addCanal(Canal canal) {
		listCanal.add(canal);
	}
	
	/* (non-Javadoc)
	 * @see strategy.AlgoStrategies#checkActionToDoBefore()
	 */
	@Override
	public int checkActionToDoBefore() {
		// TODO Auto-generated method stub
		try {
			semaphore.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(isReading()){
			this.copy = capteur.getValue();
			this.setValue(copy);
		}
		
		else{
			this.copy = this.getValue();
		}
		semaphore.release();
		
		return copy;
	}
	
	/* (non-Javadoc)
	 * @see strategy.AlgoStrategies#checkActionToDoAfter()
	 */
	@Override
	public void checkActionToDoAfter() {
		// TODO Auto-generated method stub
		return;
	}
	
	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * Gets the copy.
	 *
	 * @return the copy
	 */
	public int getCopy() {
		return copy;
	}
	

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public synchronized int getValue() {
		compteur++;
		if (compteur == listCanal.size() - 1) {
			lecture = true;
			compteur = 0;
			ready = true;
		}
		return value;
	}
	
	/**
	 * isReading.
	 *
	 * @return true, if successful
	 */
	public synchronized boolean isReading() {
		if (lecture) {
			lecture = false;
			return true;
		}
		return lecture;
	}

}

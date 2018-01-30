package appCore;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import strategy.AlgoStrategies;

// TODO: Auto-generated Javadoc
/**
 * The Class Canal.
 */
public class Canal implements Capteur, ObserverDeCapteur {

	/** The afficheur. */
	private Afficheur afficheur;
	
	/** The capteur. */
	private CapteurImpl capteur;

	/**
	 * Instantiates a new canal.
	 *
	 * @param capteur the capteur
	 * @param afficheur the afficheur
	 */
	public Canal (CapteurImpl capteur, Afficheur afficheur){
		this.capteur = capteur;
		this.afficheur = afficheur;
	}

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
		ValueCollector getValue = new ValueCollector(this.capteur);
		ScheduledThreadPoolExecutor schedule = new ScheduledThreadPoolExecutor(10);
		ScheduledFuture<Integer> future = schedule.schedule(getValue, (long)(Math.random() * 2000) + 1000, TimeUnit.MILLISECONDS);
		int ret = 0;
		try {
			ret = future.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return ret;
	}

	/* (non-Javadoc)
	 * @see appCore.Capteur#tick()
	 */
	@Override
	public void tick() {

	}

	/* (non-Javadoc)
	 * @see appCore.Capteur#getAlgo()
	 */
	@Override
	public AlgoStrategies getAlgo() {
		return this.capteur.getAlgo();
	}

	/* (non-Javadoc)
	 * @see appCore.ObserverDeCapteur#update(appCore.Capteur)
	 */
	@Override
	public void update(Capteur subject) {
		Update update = new Update(this.afficheur, this);
		ScheduledThreadPoolExecutor schedule = new ScheduledThreadPoolExecutor(10);
		schedule.schedule(update, (long)(Math.random() * 2000) + 1000, TimeUnit.MILLISECONDS);
	}

}

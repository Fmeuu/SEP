package appCore;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import strategy.AlgoStrategies;

public class Canal implements Capteur, ObserverDeCapteur {

	private Afficheur afficheur;
	private CapteurImpl capteur;

	public Canal (CapteurImpl capteur, Afficheur afficheur){
		this.capteur = capteur;
		this.afficheur = afficheur;
	}

	@Override
	public void attach(Observer o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void detach(Observer o) {
		// TODO Auto-generated method stub

	}

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

	@Override
	public void tick() {

	}

	@Override
	public AlgoStrategies getAlgo() {
		return this.capteur.getAlgo();
	}

	@Override
	public void update(Capteur subject) {
		Update update = new Update(this.afficheur, this);
		ScheduledThreadPoolExecutor schedule = new ScheduledThreadPoolExecutor(10);
		schedule.schedule(update, (long)(Math.random() * 2000) + 1000, TimeUnit.MILLISECONDS);
	}

}

package appCore;

import java.util.concurrent.Callable;


public class ValueCollector implements Callable<Integer> {

	private CapteurImpl capteur;
	
	public ValueCollector (CapteurImpl capteur){
		this.capteur = capteur;
	}
	@Override
	public Integer call() throws Exception {
		return this.capteur.getValue();	
		}

}

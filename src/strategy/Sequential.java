package strategy;

import java.util.ArrayList;
import java.util.List;

import appCore.Canal;
import appCore.Capteur;
import appCore.CapteurImpl;

/**
 * The Class Sequential.
 */
public class Sequential implements AlgoStrategies {

	private Capteur capteur;
	private List <Canal> listCanal = new ArrayList<Canal>();
	
	@Override
	public void configure(int nbCanal) {
	}

	@Override
	public void execute() {
	}

	@Override
	public void setCapteur(CapteurImpl capteur) {
		this.capteur = capteur;
	}

	@Override
	public void addCanal(Canal canal) {
		listCanal.add(canal);
	}

}

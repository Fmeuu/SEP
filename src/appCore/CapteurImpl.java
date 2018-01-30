package appCore;

import strategy.AlgoStrategies;

public class CapteurImpl implements Capteur {
	private AlgoStrategies strategies;
	private int compteur = 0;
	
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
		return compteur;
		}

	@Override
	public void tick() {
		compteur++;
		this.strategies.execute();
	}

	@Override
	public AlgoStrategies getAlgo() {
		return this.strategies;
	}
	
	public void setStrategies(AlgoStrategies algo){
		this.strategies = algo;
	}

}

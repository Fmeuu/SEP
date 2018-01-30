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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub

	}

	@Override
	public AlgoStrategies getAlgo() {
		// TODO Auto-generated method stub
		return strategies;
	}
	
	public void setAlgoDiff(AlgoStrategies algo){
		this.strategies = algo;
	}

}

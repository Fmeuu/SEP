package appCore;

import strategy.AlgoStrategies;

public interface Capteur {

	public void attach(Observer o);

	public void detach(Observer o);

	public int getValue();

	public void tick();


	public AlgoStrategies getAlgo();
}

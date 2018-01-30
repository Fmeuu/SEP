package appCore;

import java.util.concurrent.BrokenBarrierException;

import javax.swing.JLabel;

import strategy.AlgoStrategies;
import strategy.Atomic;
import strategy.Epoque;
import strategy.Sequential;


public class Afficheur extends JLabel implements ObserverDeCapteur {

	
	public Afficheur(String name){
		super(name);
	}
	
	@Override
	public void update(Capteur subject) {
		AlgoStrategies algo = subject.getAlgo();
		if(algo instanceof Atomic) {
			int val = subject.getValue();
			this.setText(String.valueOf(val));
			try {
				((Atomic) subject.getAlgo()).getBarrier().await();
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
		else if (algo instanceof Sequential) {
		}
		else if (algo instanceof Epoque) {
		}
	}

}

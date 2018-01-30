package strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import appCore.Canal;
import appCore.Capteur;
import appCore.CapteurImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class Atomic.
 */
public class Atomic implements AlgoStrategies {

	private Capteur capteur;
	private List <Canal> listCanal = new ArrayList<Canal>();
	private CyclicBarrier barrier;

	@Override
	public void configure(int nbCanal) {
		this.barrier = new CyclicBarrier(nbCanal+1);
	}

	@Override
	public void execute() {
		for(Canal canal : listCanal){
			canal.update(capteur);
		}

		try {
			this.barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void setCapteur(CapteurImpl capteur) {
		this.capteur = capteur;
	}

	@Override
	public void addCanal(Canal canal) {
		listCanal.add(canal);
	}

	public void releaseAll(){
		this.barrier.reset();
	}
	
	public CyclicBarrier getBarrier() {
		return this.barrier;
	}

}

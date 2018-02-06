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

	/** The capteur. */
	private Capteur capteur;
	
	/** The list canal. */
	private List <Canal> listCanal = new ArrayList<Canal>();
	
	/** The barrier. */
	private CyclicBarrier barrier;

	/* (non-Javadoc)
	 * @see strategy.AlgoStrategies#configure(int)
	 */
	@Override
	public void configure(int nbCanal) {
		this.barrier = new CyclicBarrier(nbCanal+1);
	}

	/* (non-Javadoc)
	 * @see strategy.AlgoStrategies#execute()
	 */
	@Override
	public void execute() {
		for(Canal canal : listCanal){
			canal.update(capteur);
		}

		this.checkActionToDoBefore();
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
	 * @see strategy.AlgoStrategies#checkWaiting()
	 */
	@Override
	public int checkActionToDoBefore() {
		// TODO Auto-generated method stub
		try {
			this.barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	/* (non-Javadoc)
	 * @see strategy.AlgoStrategies#checkActionToDoAfter()
	 */
	@Override
	public void checkActionToDoAfter() {
		// TODO Auto-generated method stub
		return;
	}

}

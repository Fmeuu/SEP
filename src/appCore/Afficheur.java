package appCore;

import javax.swing.JLabel;

import strategy.Sequential;

// TODO: Auto-generated Javadoc
/**
 * The Class Afficheur.
 */
@SuppressWarnings("serial")
public class Afficheur extends JLabel implements ObserverDeCapteur {

	
	/**
	 * Instantiates a new afficheur.
	 *
	 * @param name the name
	 */
	public Afficheur(String name){
		super(name);
	}
	
	/* (non-Javadoc)
	 * @see appCore.ObserverDeCapteur#update(appCore.Capteur)
	 */
	@Override
	public void update(Capteur subject) {
		int val = subject.getValue();
		int copy = subject.getAlgo().checkActionToDoBefore();
		
		if(copy == -1) {
		this.setText(String.valueOf(val));
		}
		else {
			System.out.println(((Sequential)subject.getAlgo()).getCopy());
			this.setText(String.valueOf(((Sequential)subject.getAlgo()).getCopy()));
		}
		subject.getAlgo().checkActionToDoAfter();
	}

}

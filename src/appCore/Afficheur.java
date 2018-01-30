package appCore;

import javax.swing.JLabel;

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
		this.setText(String.valueOf(val));
		subject.getAlgo().checkWaiting();
	}

}

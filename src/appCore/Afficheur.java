package appCore;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Afficheur extends JLabel implements ObserverDeCapteur {

	
	public Afficheur(String name){
		super(name);
	}
	
	@Override
	public void update(Capteur subject) {
		int val = subject.getValue();
		this.setText(String.valueOf(val));
		subject.getAlgo().checkWaiting();
	}

}

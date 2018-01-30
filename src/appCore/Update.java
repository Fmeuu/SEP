package appCore;

import java.util.concurrent.Callable;


// TODO: Auto-generated Javadoc
/**
 * The Class Update.
 */
public class Update implements Callable<Object> {

	/** The afficheur. */
	private Afficheur afficheur;
	
	/** The canal. */
	private Canal canal;

	/**
	 * Instantiates a new update.
	 *
	 * @param afficheur the afficheur
	 * @param canal the canal
	 */
	public Update (Afficheur afficheur, Canal canal){
		this.afficheur = afficheur;
		this.canal = canal;
	}

	/* (non-Javadoc)
	 * @see java.util.concurrent.Callable#call()
	 */
	@Override
	public Object call() throws Exception {
		afficheur.update(canal);
		return null;
	}
}

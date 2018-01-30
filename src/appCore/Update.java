package appCore;

import java.util.concurrent.Callable;


public class Update implements Callable<Object> {

	private Afficheur afficheur;
	private Canal canal;

	public Update (Afficheur afficheur, Canal canal){
		this.afficheur = afficheur;
		this.canal = canal;
	}

	@Override
	public Object call() throws Exception {
		afficheur.update(canal);
		return null;
	}
}

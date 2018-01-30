package appCore;

// TODO: Auto-generated Javadoc
/**
 * The Interface Observer.
 *
 * @param <T> the generic type
 */
public interface Observer<T> {
	
	/**
	 * Update.
	 *
	 * @param subject the subject
	 */
	public void update(T subject);
}

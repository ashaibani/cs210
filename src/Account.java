
// TODO: Auto-generated Javadoc
/**
 * The Class Account.
 */
public class Account {
	
	/** The id. */
	private int id;
	
	/** The pres. */
	private float arian, pres;
	
	/**
	 * Instantiates a new account.
	 *
	 * @param id the id
	 * @param arian the arian
	 * @param pres the pres
	 */
	public Account(int id, float arian, float pres) {
		this.id = id;
		this.arian = arian;
		this.pres = pres;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Gets the arian.
	 *
	 * @return the arian
	 */
	public synchronized float getArian() {
		return arian;
	}
	
	/**
	 * Gets the pres.
	 *
	 * @return the pres
	 */
	public synchronized float getPres() {
		return pres;
	}
	
	/**
	 * Sets the arian.
	 *
	 * @param arian the new arian
	 */
	public synchronized void setArian(float arian) {
		this.arian = arian;
	}
	
	/**
	 * Sets the pres.
	 *
	 * @param pres the new pres
	 */
	public synchronized void setPres(float pres) {
		this.pres = pres;
	}
}

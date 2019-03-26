import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Manager.
 */
public class Manager {
	
	/** The commands. */
	private CopyOnWriteArrayList<Command> commands;
	
	/** The accounts. */
	private List<Account> accounts;
	
	/** The conversion rate. */
	private float conversionRate;

	/**
	 * Instantiates a new manager.
	 */
	public Manager() {
		commands = new CopyOnWriteArrayList<Command>();
		accounts = Collections.synchronizedList(new ArrayList<Account>());

		commands.add(new Open(this));
		commands.add(new State(this));
		commands.add(new Rate(this));
		commands.add(new Convert(this));
		commands.add(new Transfer(this));
		
		conversionRate = 1.0f;
	}

	/**
	 * Process.
	 *
	 * @param command the command
	 * @param input the input
	 * @param out the out
	 */
	public void process(String command, String[] input, PrintWriter out) {
		for (Command cmd : commands) {
			if (cmd.isCommand(command)) {
				int inputLength = 0;
				if (input != null) {
					inputLength = input.length;
				}
				if (cmd.isValid(inputLength)) {
					try {
						cmd.process(input, out);
					} catch (Exception e) {
						e.printStackTrace();
						out.println(
								"An error occured trying to process that command, please check that you used the right syntax");
						out.println("Syntax: " + cmd.help());
					}
				} else {
					out.println("Invalid syntax! Not enough parameters supplied");
					out.println("Syntax: " + cmd.help());
				}
				return;
			}
		}
		out.println("There was no command found matching '" + command + "'");

	}

	/**
	 * Sets the conversion rate.
	 *
	 * @param rate the new conversion rate
	 */
	public synchronized void setConversionRate(float rate) {
		this.conversionRate = rate;
	}

	/**
	 * Creates the account.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	public boolean createAccount(int id) {
		if (getAccountById(id) == null) {
			accounts.add(new Account(id, 0, 0));
			return true;
		}
		return false;
	}

	/**
	 * Transfer.
	 *
	 * @param accountFrom the account from
	 * @param accountTo the account to
	 * @param arian the arian
	 * @param pres the pres
	 */
	public void transfer(int accountFrom, int accountTo, float arian, float pres) {
		Account from = getAccountById(accountFrom);
		Account to = getAccountById(accountTo);
		if(from == null || to == null) {
			return;
		}
		from.setArian(from.getArian() - arian);
		from.setPres(from.getPres() - pres);

		to.setArian(to.getArian() + arian);
		to.setPres(to.getPres() + pres);
	}
	
	/**
	 * Convert.
	 *
	 * @param accountId the account id
	 * @param arian the arian
	 * @param pres the pres
	 */
	public  void convert(int accountId, float arian, float pres) {
		// (A−a+p/r, P−p+a·r)
		Account acc = getAccountById(accountId);
		if(acc == null) {
			return;
		}
		float newArian = acc.getArian() - arian + pres / conversionRate;
		float newPres = acc.getPres() - pres + arian / conversionRate;
		
		acc.setArian(newArian);
		acc.setPres(newPres);
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public String getState() {
		String state = "";
		
		synchronized(accounts){
			for (Account acc : accounts) {
				state += acc.getId() + ": Arian " + acc.getArian() + ", Pres " + acc.getPres() + "\n";
			}
		}

		return state;
	}

	/**
	 * Gets the account by id.
	 *
	 * @param id the id
	 * @return the account by id
	 */
	public Account getAccountById(int id) {
		synchronized(accounts){
			for(Account acc : accounts) {
				if(acc.getId() == id) {
					return acc;
				}
			}
		}
		return null;
	}

}

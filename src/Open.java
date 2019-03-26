
import java.io.PrintWriter;

/**
 * The Class Open.
 */
public class Open extends Command {
	
	/**
	 * Instantiates a new open.
	 *
	 * @param manager the manager
	 */
	public Open(Manager manager) {
		super("open", 1, manager);
	}

	@Override
	public void process(String[] input, PrintWriter writer) {
		int accountId = Integer.parseInt(input[0]);
		if (manager.createAccount(accountId)) {
			writer.println("Opened account " + accountId);
		} else {
			writer.println("Failed to open account " + accountId + ", the account might already exist");
		}
	}

	@Override
	public String help() {
		return "Open <account no>";
	}

}

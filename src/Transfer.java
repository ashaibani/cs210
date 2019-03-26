import java.io.PrintWriter;

// TODO: Auto-generated Javadoc
/**
 * The Class Transfer.
 */
public class Transfer extends Command {

	/**
	 * Instantiates a new transfer.
	 *
	 * @param manager the manager
	 */
	public Transfer(Manager manager) {
		super("transfer", 3, manager);
	}

	@Override
	public void process(String[] input, PrintWriter writer) {
		int accountFrom = Integer.parseInt(input[0]);
		int accountTo = Integer.parseInt(input[1]);
		String[] currency = input[2].split(",");
		float arian = Float.parseFloat(currency[0].substring(1, currency[0].length()));
		float pres = Float.parseFloat(currency[1].substring(0, currency[0].length() - 1));
		
		manager.transfer(accountFrom, accountTo, arian, pres);
		writer.println("Transferred");
	}

	@Override
	public String help() {
		return "transfer <account from> <account to> (<a>,<p>)";
	}

}


import java.io.PrintWriter;

// TODO: Auto-generated Javadoc
/**
 * The Class Command.
 */
public abstract class Command {
	
	/** The command. */
	private String command;
	
	/** The parameters. */
	private int parameters;
	
	/** The manager. */
	protected Manager manager;
	
	/**
	 * Instantiates a new command.
	 *
	 * @param command the command 
	 * @param paramaters the minimum amount of paramaters this command expects
	 * @param manager the manager
	 */
	public Command(String command, int paramaters, Manager manager) {
		this.command = command;
		this.parameters = paramaters;
		this.manager = manager;
	}
	
	/**
	 * Checks if is the string passed matches the command.
	 *
	 * @param command the command
	 * @return true, if is command
	 */
	public boolean isCommand(String command) {
		if(this.command.equalsIgnoreCase(command)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Checks if there is a valid amount of parameters being passed.
	 *
	 * @param length the length
	 * @return true, if is valid
	 */
	public boolean isValid(int length) {
		return parameters <= length;
	}
	
	/**
	 * This method parses the input and accordingly processes it.
	 *
	 * @param input the input
	 * @param writer the writer
	 */
	public abstract void process(String[] input, PrintWriter writer);
	
	/**
	 * Returns the expected parameters and help for the command
	 *
	 * @return the help string
	 */
	public abstract String help();
}

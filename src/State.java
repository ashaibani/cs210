import java.io.PrintWriter;

// TODO: Auto-generated Javadoc
/**
 * The Class State.
 */
public class State extends Command{

	/**
	 * Instantiates a new state.s
	 *
	 * @param manager the manager
	 */
	public State(Manager manager) {
		super("state", 0, manager);
	}

	@Override
	public void process(String[] input, PrintWriter writer) {
		writer.println(manager.getState().trim());
	}

	@Override
	public String help() {
		return "State";
	}

}

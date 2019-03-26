import java.io.PrintWriter;

// TODO: Auto-generated Javadoc
/**
 * The Class Rate.
 */
public class Rate extends Command{

	/**
	 * Instantiates a new rate.
	 *
	 * @param manager the manager
	 */
	public Rate(Manager manager) {
		super("rate", 1, manager);
	}

	@Override
	public void process(String[] input, PrintWriter writer) {
		float rate = Float.parseFloat(input[0]);
		
		manager.setConversionRate(rate);
	}

	@Override
	public String help() {
		return "Rate <rate>";
	}

}

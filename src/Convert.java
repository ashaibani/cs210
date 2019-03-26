import java.io.PrintWriter;

// TODO: Auto-generated Javadoc
/**
 * The Class Convert.
 */
public class Convert extends Command{

	/**
	 * Instantiates a new convert.
	 *
	 * @param manager the manager
	 */
	public Convert(Manager manager) {
		super("convert", 2, manager);
	}

	@Override
	public void process(String[] input, PrintWriter writer) {
		int account = Integer.parseInt(input[0]);
		String[] currency = input[1].split(",");
		float arian = Float.parseFloat(currency[0].substring(1, currency[0].length()));
		float pres = Float.parseFloat(currency[1].substring(0, currency[0].length() - 1));
		
		manager.convert(account, arian, pres);
		writer.println("Converted");
	}

	@Override
	public String help() {
		return "Convert <account no> (<a>,<p>)";
	}

}

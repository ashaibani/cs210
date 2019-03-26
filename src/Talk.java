import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class Talk.
 */
public class Talk implements Runnable {
	
	/** The socket. */
	private Socket socket;
	
	/** The manager. */
	private Manager manager;

	/**
	 * Instantiates a new talk.
	 *
	 * @param manager the manager
	 * @param socket the socket
	 */
	public Talk(Manager manager, Socket socket) {
		this.manager = manager;
		this.socket = socket;
	}

	@Override
	public void run() {
		System.out.println("Connected: " + socket);
		try {
			Scanner in = new Scanner(socket.getInputStream());
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			while (in.hasNextLine()) {
				String line = in.nextLine();
				String[] input = line.split(" ");
				String command = input[0];
				if (input.length > 1) {
					input = Arrays.copyOfRange(input, 1, input.length);
				} else {
					input = null;
				}
				manager.process(command, input, out);
			}
			in.close();
		} catch (Exception e) {
			System.out.println("Error:" + socket);
		} finally {
			try {
				
				socket.close();
			} catch (IOException e) {
			}
			System.out.println("Closed: " + socket);
		}
	}
}

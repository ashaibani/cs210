import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// TODO: Auto-generated Javadoc
/**
 * The Class Server.
 */
public class Server {

    /**
     * Runs the server. When a client connects, the server spawns a new thread to do
     * the servicing.
     *
     * @param args the arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception {
    	Manager manager = new Manager();
        try (ServerSocket listener = new ServerSocket(4242)) {
	    ExecutorService pool = Executors.newFixedThreadPool(1000);
            while (true) {
            	Socket socket = listener.accept();
            	pool.execute(new Talk(manager, socket));
            }
        }
    }


}

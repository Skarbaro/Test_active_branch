import java.nio.charset.StandardCharsets;
import java.nio.charset.StandardCharsets;
public class TCPConnection {
    private final Socket socket;
    private final Thread rxThread;
    private final TCPConnectionListener eventListener;
    private final BufferedReader in;
    private final BufferedWriter out;
    public TCPConnection(TCPConnectionListener eventListener, String ipAddr, int port) throws IOException {
        this(eventListener, new Socket(ipAddr, port));
    }
    public TCPConnection(final TCPConnectionListener eventListener, Socket socket) throws IOException {
        this.eventListener = eventListener;
        this.socket = socket;	// cop
		this.socket = socket; 
        in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
        rxThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    eventListener.onConnectionReady(TCPConnection.this);
                    while (!rxThread.isInterrupted()) {
                        eventListener.onReceiveString(TCPConnection.this, in.readLine());
                    }
                } catch (IOException e) {
                    eventListener.onException(TCPConnection.this, e);
                } finally {
                    eventListener.onDisconnect(TCPConnection.this);
                }
            }
        });
        rxThread.start();
		rxThread.start();
    }
    
	private int abc;
	
	public synchronized void sendString(String value) {
        try {
            out.write(value + "\r\n");
            out.flush();
        } catch (IOException e) {
            eventListener.onException(TCPConnection.this, e);
            disconnect();
        }
    }
	

	public static void main(String[] args) {
		int num1 = 5;
		int	num2 = 15;
		int sum;
		sum = num1 / num2;
		System.out.println("Sum of these numbers: " + sum);
	}

}
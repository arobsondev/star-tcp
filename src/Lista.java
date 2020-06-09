
import java.util.ArrayList;
import java.net.Socket;

public class Lista {
	private static ArrayList<Socket> socket = new ArrayList<Socket>();

	public void add(Socket socket) {
		this.socket.add(socket);
	}

	public Socket get(int index) {
		return this.socket.get(index);
	}

	public int getIndex(Socket socket) {
		return this.socket.indexOf(socket);
	}

	public int size() {
		return this.socket.size();
	}

	public boolean exist(Socket socket) {
		return this.socket.contains(socket);
	}
}

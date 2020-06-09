
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.net.Socket;
import java.util.ArrayList;

public class SimplesConector implements Runnable {
	private String host;
	private int port;
	private final Lista destinatario;

	public SimplesConector(String host, int port, Lista destinatario) {
		this.host = host;
		this.port = port;
		this.destinatario = destinatario;
	}

	@Override
	public void run() {
		boolean aux = true;
		while(aux) {
			try {
				destinatario.add(new Socket(host, port));
				System.out.println("Conectado ao servidor: " + port + "\n");
				
				aux = false;
			}catch(UnknownHostException e) {
				System.err.println("\nServidor não encontrado");
			}catch(IOException e) {
				System.err.println("Tentando conectar ao servidor : " + port);
				try {
					Thread.sleep(5000);
				}catch(InterruptedException f) {
					System.err.println("erro inesperado de thread");
				}
			}
		}

	}
}


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Mestre {
	private String host;
	private int sPort;
	private ArrayList<Integer> cPort;
	private final Lista destinatario;

	public Mestre(String host, int sPort, ArrayList<Integer> cPort) {
		this.host = host;
		this.sPort = sPort;
		this.cPort = cPort;
		this.destinatario = new Lista();
	}

	public void execute() {
		try {
			ServerSocket servidor = new ServerSocket(this.sPort);
			System.out.println("\nServidor conectado: " + sPort + "\n");

			ExecutorService executorService = Executors.newCachedThreadPool();
			for(int i = 0; i < cPort.size(); i++) {
				executorService.execute(new SimplesConector(host, cPort.get(i), destinatario));
			}

			while(true) {
				Socket conexao = servidor.accept();

				executorService.execute(new Distribuidor(conexao, destinatario));
			}
		}catch(IOException e) {
			System.err.println("\nServidor não conectado.");
		}
		
	}
}

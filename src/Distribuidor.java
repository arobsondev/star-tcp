
import java.net.Socket;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintStream;

public class Distribuidor implements Runnable {
	private static ArrayList<Socket> listaRemetente = new ArrayList<Socket>();
	private Socket remetente;
	private final Lista destinatario;
	private int index;

	public Distribuidor(Socket remetente, Lista destinatario) {
		this.remetente = remetente;
		this.destinatario = destinatario;
		this.listaRemetente.add(this.remetente);
		this.index = this.listaRemetente.indexOf(this.remetente);
	}	

	public void run() {
		try {
			Scanner in = new Scanner(remetente.getInputStream());
			PrintStream out;
			Socket destino;

			while(in.hasNextLine()) {
				if(index == (destinatario.size() -1)) {
					destino = destinatario.get(0);	
				}else {
					destino = destinatario.get(index + 1);
				}

				out = new PrintStream(destino.getOutputStream());
				out.println(in.nextLine());
			}
		}catch(IOException e) {
			System.err.println("Erro na distribuição de mensagem");

		}

	}
}

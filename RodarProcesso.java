
 import java.util.Scanner;

 public class RodarProcesso {
	public static void main(String[] args) { 
		final String host = "127.0.0.1";
	 	int sPort = 0;
	 	final int cPort = 12345;	//porta do processo mestre
		boolean bool = true;

		Scanner in = new Scanner(System.in);

		while(bool) {
			System.out.print("Server Port: ");
			sPort = in.nextInt();

			if(cPort != sPort) {
				bool = false;
			}else {
				System.out.println("Porta ocupada");
			}
		}

		new Processo(host, sPort, cPort).execute();
		
	}
 }


import java.util.Scanner;
import java.util.ArrayList;

public class RodarMestre {
	public static void main(String[] args) {
		final String host = "127.0.0.1";
		final int sPort = 12345;
		ArrayList<Integer> cPort = new ArrayList<Integer>();

		Scanner in = new Scanner(System.in);

		System.out.print("Quantidade de client port: ");
		int qnt = in.nextInt();

		for(int i = 0; i < qnt; i++) {
			System.out.printf("\nClient port: ");
			cPort.add(in.nextInt());
		}

		new Mestre(host, sPort, cPort).execute();
	}
}

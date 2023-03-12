package Chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket s = new Socket("localhost", 5050);
		Scanner keyboard = new Scanner(System.in);
		Receive r=new Receive(s);
		PrintWriter pw = new PrintWriter(s.getOutputStream());
		System.out.println("saisir le nom");
		String nom=keyboard.nextLine();
		pw.println(nom);
		pw.flush();
		r.start();
		System.out.println("Chat:");
		while(true) {
			String message = keyboard.nextLine();
			pw.println(message);
			pw.flush();
		}
		
	}

}
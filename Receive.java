package Chat;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Receive extends Thread{
  Socket s;
	
	public Receive(Socket s) {
	this.s = s;
}

	public void run() {
		Scanner scannerSocket;
		try {
			while(true) {
				scannerSocket = new Scanner(s.getInputStream());
			System.out.println(scannerSocket.nextLine());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

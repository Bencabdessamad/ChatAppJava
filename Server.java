package Chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;

public class Server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Vector<User> users=new Vector<User>();
		ServerSocket ss = new ServerSocket(5050);
		System.out.println("Server Started ....");
		while(true) {
			Socket socket = ss.accept();
		
	          Scanner scanner = new Scanner(socket.getInputStream());
			
			String nom=scanner.nextLine();
			System.out.println(nom+" connected");
			users.add(new User(nom,socket));
			Upper th = new Upper(socket,users);
			
			th.start();
		}
		
	}

}

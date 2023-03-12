package Chat;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;

public class Upper extends Thread{
	Socket socket;
	Vector<User> users;
	public Upper(Socket socket,Vector<User> users) {
		this.socket = socket;
		this.users=users;
	}

	public void run() {
		try {
			Scanner scanner = new Scanner(socket.getInputStream());
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			String nom="hao";
		     for(User u:users) {
		    	 if(socket.equals(u.socket)) {
		    	 nom=u.nom;
		    	 }
		     }
			while(true) {
				String message = scanner.nextLine();
				if(message.contains("@")) {
					String[] tab=message.split(":");
					for(User u:users) {
						if(tab[0].substring(1).equals(u.nom)) {
							 pw = new PrintWriter(u.socket.getOutputStream());
					pw.println(nom+":"+tab[1]);
				pw.flush();
						}
					
				}
				}else if(message.contains("#join")) {
					String[] tab=message.split(" ");
					  for(User u:users) {
					    	 if(socket.equals(u.socket)) {
					    	   u.groupes.add(tab[1]);
					    	 }	     
					     }
				}else if(message.contains("$")) {
					String[] tab=message.split(":");
					
					for(User u:users) {
                        for(String group:u.groupes) {
                        	if(group.equals(tab[0].substring(1))) {
                        		 pw = new PrintWriter(u.socket.getOutputStream());
             					pw.println(nom+":"+tab[1]);
             				pw.flush();
                        	}
                        }	
				}
				}else if(message.contains("#quit")) {
					String[] tab=message.split(" ");
					 for(User u:users) {
				    	  if(u.socket.equals(socket)) {
				    		  for(int i=0;i<u.groupes.size();i++) {
				    			  if(u.groupes.get(i).equals(tab[1])) {
					    			  u.groupes.remove(i);
				    			  }
				    		  }
				    	  }
				     }
				} else  {
					String[] tab=message.split(":");
					for(User u:users) {
						 pw = new PrintWriter(u.socket.getOutputStream());
      					pw.println(nom+":"+message);
      				pw.flush();	
				}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

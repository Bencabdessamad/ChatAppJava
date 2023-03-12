package Chat;

import java.net.Socket;
import java.util.Vector;

public class User {
String nom;
Socket socket;
Vector<String> groupes;
public User(String nom, Socket socket) {
	this.nom = nom;
	this.socket = socket;
	groupes=new Vector<String>();
}


}

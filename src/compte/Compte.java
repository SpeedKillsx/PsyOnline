package compte;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import application.BaseDeDonnee;

public class Compte {
private String user;
private String pass;
private String type;

private static BaseDeDonnee bd;
public Compte(String user,String pass,String type) {
	this.user = user;
	this.pass = pass;
	this.type = type;
}

public String getUser() {
	return user;
}

public void setUser(String user) {
	this.user = user;
}

public String getPass() {
	return pass;
}

public void setPass(String pass) {
	this.pass = pass;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public static void AjouterUnCompte(String user ,String password,String type) {
	String add = "INSERT INTO COMPTE VALUES(?,?,?)";
	PreparedStatement p = null;
	
	
	try {
		Connection connect = bd.getConnection();
		p = connect.prepareStatement(add);
		p.setString(1, user);
		p.setString(2, password);
		p.setString(3, type);
		p.execute();
		connect.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		

}
}

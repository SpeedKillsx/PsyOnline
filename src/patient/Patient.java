package patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import application.BaseDeDonnee;

public class Patient {
private static int id;
private String name;
private String prenom;
private String email;
private String ville;
private static BaseDeDonnee bd;
public Patient (String name,String prenom,String email,String ville) {
	id++;
	this.name = name;
	this.prenom = prenom;
	this.email = email;
	this.ville = ville;
	AjouterPatient(name, prenom, email,ville);
}
public static int getId() {
	return id;
}
public static void setId(int id) {
	Patient.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom= prenom;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

public static void AjouterPatient(String nom,String prenom,String email,String ville){
	String ajout = "insert into patient (nom,prenom,email,ville)values('"+nom+"','"+prenom+"','"+email+"','"+ville+"')";
	PreparedStatement prepare = null;
	Connection connect;
	try {
		connect = bd.getConnection();
		
	prepare = connect.prepareStatement(ajout);
	
	prepare.executeUpdate();
	connect.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}


}

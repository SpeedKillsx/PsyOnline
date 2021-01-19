package psychiatre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.BaseDeDonnee;
import invitation.Invitation;

public class Psy {

private int id;
private String nom;
private String prenom;
private String ville;
private String email;
private static BaseDeDonnee bd;
private ArrayList<Invitation> ListeInvitation = new ArrayList<Invitation>();
public Psy(String nom,String prenom,String email,String ville) {
	
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.ville = ville;
	AjouterPsy(nom, prenom, email, ville);
}

public void SelectID() {
	String select_id = "Select count(*) from psy";
	Connection connect;
	PreparedStatement p=null;
	ResultSet resultat = null;
	try {
		connect = bd.getConnection();
	    
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public ArrayList<Invitation> getListeInvitation() {
	return ListeInvitation;
}
public void setListeInvitation(ArrayList<Invitation> listeInvitation) {
	ListeInvitation = listeInvitation;
}

//
public void Accepter(int idInvitationn,int idpatient) {
	String accept = "insert into abonnement VALUES(?,?)";
	PreparedStatement p = null;
	Connection connect;
	try {
		connect = bd.getConnection();
		p = connect.prepareStatement(accept);
		p.setInt(1, this.id);
		p.setInt(2, idpatient);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

}

public boolean Refuser(int idInvitation) {
	return false;
}

public void RepondreInvitation(int idInvitation, int idPatient) {
	String accept = "insert into abonnement VALUES(?,?)";
	PreparedStatement p = null;
	
	
	
	
}
public static void AjouterPsy(String nom,String prenom,String email,String ville) {
	String ajout = "insert into psy (nom,prenom,email,ville)values('"+nom+"','"+prenom+"','"+email+"','"+ville+"')";
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

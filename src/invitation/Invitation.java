package invitation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import application.BaseDeDonnee;

public class Invitation {
private static int idInvitation;
private int idPsy;
private int idPatient;
private BaseDeDonnee bd;
public Invitation(int idPsy,int idPatient) {
	
	idInvitation++;
	this.idPsy = idPsy;
	this.idPatient = idPatient;
}

public void EnvoyerInvitation(int idPsy,int idPatient) {
	String insert = "Insert into Invitation VALUES(?,?,?)";
	PreparedStatement prepareInsertion = null;;
	try {
		Connection connection = bd.getConnection() ;
		prepareInsertion = connection.prepareStatement(insert);
		prepareInsertion.setInt(1, idInvitation);
		prepareInsertion.setInt(2, idPsy);
		prepareInsertion.setInt(3, idPatient);
	    System.out.println("Ajouter");
		prepareInsertion.execute();
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
}
}

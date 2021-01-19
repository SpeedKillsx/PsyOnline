package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;



public class LoginModel {
  private Connection connection;

public LoginModel() {
	
   try {
	this.connection = BaseDeDonnee.getConnection();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
    if(connection==null) {
    	System.exit(1);
    }
    
	
}

public boolean isDbConnected() {
	return this.connection !=null;
}
// detecter type du compte
   public String getType(String name,String first) throws SQLException {
	   String type_req = "SELECT TYPE FROM COMPTE where user ='"+name+"' and pass ='"+first+"'";
	   PreparedStatement prepared = null;
	   ResultSet res = null;
	   String type = null;
	   try {
		prepared = connection.prepareStatement(type_req);
		res = prepared.executeQuery();
		if(res .next()) {
			
		type = res.getString("type");
		
		
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		   
		   connection.close();
		   prepared.close();
	   }
	   return type;
   }
    public boolean isLogin(String user,String pass) throws SQLException{
    	PreparedStatement preapredstatement = null;
    	ResultSet result=null;
    	//String type = "SELECT TYPE FROM COMPTE WHERE USER='"+user+"'";
    	String sql = "select * from compte where user = ? and pass = ?";
     
    	 try {
				preapredstatement = connection.prepareStatement(sql);
			    preapredstatement.setString(1, user);
			    preapredstatement.setString(2, pass);
			    
			    result= preapredstatement.executeQuery();
			if(result.next()) {
				System.out.println("yela");
				return true;
				}
			 JOptionPane.showMessageDialog(null, "Verrifiez vos informations (Mot de passe ou user inccorect)");
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
    	 finally {
    		 preapredstatement.close();


    	 }
    	
    	
		
    }


}


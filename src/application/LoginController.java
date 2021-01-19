package application;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import compte.CompteController;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;
import patient.PatientController;
import psychiatre.PsyController;

public class LoginController implements Initializable{
LoginModel loginModel = new LoginModel();
public LoginController() {
	// TODO Auto-generated constructor stub
}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		if(this.loginModel.isDbConnected()) {
			System.out.println("jjjj");
		}
	}
	
	@FXML 
	private VBox vbox;
	private Parent fxml;
	
	
	
	
	
	//--------
	@FXML
	private TextField user;
	@FXML
	private TextField pass;
	@FXML
	private ComboBox<Profil> TypeCompte;
	@FXML 
	private Button LoginButton;
	
	static  int rep ;
	
	@FXML
	public void Login(ActionEvent event) {
		
		try {
			if(this.loginModel.isLogin(user.getText(), pass.getText())) {
				  
			       Stage satge = (Stage)this.LoginButton.getScene().getWindow();
			       satge.close();
				   switch(this.loginModel.getType(user.getText(), pass.getText())) {
				   case "Psy":
					    PsyLogin();
					    break;
					    
				   case "Patient":
					   PatientLogin();
					   System.out.println("tt");
					   break;
			}
			}else {
				rep++;
				if(rep==3) {
					System.out.println("azul");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void PsyLogin() {
		try {
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = (Pane)loader.load(getClass().getResource("/psychiatre/psy.fxml").openStream());
			
			PsyController Psycontroller = (PsyController)loader.getController();

			Scene scene = new Scene(root);
			
			stage.setScene(scene);
			stage.setTitle("Psychiatre");
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

		
	}
	
	private void PatientLogin() {
		try {
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = (Pane)loader.load(getClass().getResource("/patient/patient.fxml").openStream());
			
			PatientController Patientncontroller = (PatientController)loader.getController();

			Scene scene = new Scene(root);
			
			stage.setScene(scene);
			stage.setTitle("Patient");
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	@FXML
	public void CreeCompte(ActionEvent event) {
		try {
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			AnchorPane root = (AnchorPane)loader.load(getClass().getResource("/compte/compte.fxml").openStream());
			
			CompteController Comptecontroller = (CompteController)loader.getController();

			Scene scene = new Scene(root);
			
			stage.setScene(scene);
			stage.setTitle("Création d'un nouveau compte");
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	  
}

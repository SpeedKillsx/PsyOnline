package compte;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import patient.Patient;
import psychiatre.Psy;

public class CompteController implements Initializable {
@FXML private TextField nom;
@FXML private TextField prenom;
@FXML private TextField user;
@FXML private TextField mot_de_passe;
@FXML private TextField mot_de_passe_verif;
@FXML private TextField email;
@FXML private TextField ville;
@FXML RadioButton psy;
@FXML RadioButton patient;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public CompteController() {
		// TODO Auto-generated constructor stub
	}
	
	
	@FXML
	public void AjouterCompte(ActionEvent event) {
		if(this.psy.isSelected()) {
			System.out.println("Psychiatre");
			if(mot_de_passe.getText().equals(mot_de_passe_verif.getText())) {
				  Compte.AjouterUnCompte(user.getText(), mot_de_passe.getText(), patient.getText());
				 new Psy (nom.getText(),prenom.getText(),email.getText(),ville.getText());
				 JOptionPane.showMessageDialog(null, "Compte créer avec succées");
				}else {
					JOptionPane.showMessageDialog(null, "Mot de passe non-identique");
				}
		}
		
		if(this.patient.isSelected()) {
			if(mot_de_passe.getText().equals(mot_de_passe_verif.getText())) {
			  Compte.AjouterUnCompte(user.getText(), mot_de_passe.getText(), patient.getText());
			 new Patient(nom.getText(),prenom.getText(),email.getText(),ville.getText());
			 JOptionPane.showMessageDialog(null, "Compte créer avec succées");
			}else {
				JOptionPane.showMessageDialog(null, "Mot de passe non-identique");
			}
		}
	}

}

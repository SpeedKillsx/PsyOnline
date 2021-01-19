package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			
			    Parent root = FXMLLoader.load(getClass().getResource("/application/Login.fxml"));        
		        Scene scene = new Scene(root);
		        scene.setFill(Color.TRANSPARENT);
		        stage.setScene(scene);
		       // stage.initStyle(StageStyle.TRANSPARENT);
		        stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

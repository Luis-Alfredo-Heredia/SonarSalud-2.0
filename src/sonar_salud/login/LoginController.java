package sonar_salud.login;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.controlsfx.control.Notifications;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import sonar_salud.Launch;
import sonar_salud.alerts.AlertsService;
import sonar_salud.startSession.InicioSesionSrvice;import sonar_salud.startSession.StartSessionControllerSliders;
import javafx.scene.Node;


public class LoginController implements Initializable {

	public static Stage stage = null;
	

	@FXML
	private AnchorPane parent;

	@FXML
	private Pane content_area;

	@FXML
	private JFXTextField textField_Email;

	@FXML
	private JFXPasswordField passField_Password;

	@Override
	public void initialize(URL url, ResourceBundle rb) {

	}

	@FXML
	private void open_registration(MouseEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../register/Register.fxml"));
		content_area.getChildren().removeAll();
		content_area.getChildren().setAll(root);
	}


	@FXML
	private void login_app(MouseEvent event) throws IOException {
		//List<String> messages = new ArrayList<>();
		boolean isUserByPassword = InicioSesionSrvice.isUserByPassword(textField_Email.getText(), passField_Password.getText());

		if (isUserByPassword) {

			//messages.add(ErrorsAndAlerts.ICICIO_SESION_CORRECTO);
			AlertsService.correct("Welcome");
			
			FXMLLoader loader= new FXMLLoader(getClass().getResource("../startSession/StartSessionSlider.fxml"));
			Parent root = loader.load();
			StartSessionControllerSliders startSessionControllerSliders= loader.getController();
			startSessionControllerSliders.showInformationStartSession(textField_Email.getText());
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));
			//stage.initStyle(StageStyle.UNDECORATED);
			stage.show();
			

		} else {
			//messages.add(ErrorsAndAlerts.USER_DONT_EXIT);
			AlertsService.error("Error password or user don't exist");
		}


	}


	@FXML
	private void close_app(MouseEvent event) {
		System.exit(0);
	}

}
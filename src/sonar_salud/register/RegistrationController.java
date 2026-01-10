package sonar_salud.register;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sonar_salud.constants.FilesFXML;

public class RegistrationController  {

	private Stage stage;
	private Scene scene;
	private Parent root;
	

    @FXML
    private JFXTextField register_username;

    @FXML
    private JFXPasswordField register_pass;

    @FXML
    private JFXTextField register_email;

    @FXML
    private JFXPasswordField register_passConfirm;

    @FXML
    private DatePicker register_birthDate;
	
    @FXML
    private JFXButton btn_register;
	
    
	@FXML
	private void close_app(MouseEvent event) {
		System.exit(0);
	}

	@FXML
	private void back_to_main(MouseEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource(FilesFXML.LOGIN_VIEW));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	
	}
	
    @FXML
    void registerNewUser(MouseEvent event) throws IOException {
    	boolean complete = RegisterService.createNewUser(register_username.getText(),
    								  register_email.getText(),
    								  register_pass.getText(),
    								  register_passConfirm.getText(),
    								  register_birthDate.getValue().toString()
    								  );
    	
    	if(complete) {
    		root = FXMLLoader.load(getClass().getResource(FilesFXML.LOGIN_VIEW));
    		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    		scene = new Scene(root);
    		stage.setScene(scene);
    		stage.show();
    	}else {
    		System.out.print("error");
    	}
    	/*root = FXMLLoader.load(getClass().getResource(FilesFXML.LOGIN_VIEW));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();**/
    	//System.out.print(register_birthDate.getValue().toString().getClass());
    }

}

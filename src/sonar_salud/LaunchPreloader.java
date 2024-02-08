package sonar_salud;

import java.io.IOException;

import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sonar_salud.constants.FilesCSS;
import sonar_salud.constants.FilesFXML;

public class LaunchPreloader extends Preloader {

	private Stage proloaderStage;

	@Override
	public void start(Stage primaryStage) throws IOException {

		this.proloaderStage = primaryStage;
		Parent root = FXMLLoader.load(getClass().getResource(FilesFXML.SPLASH_VIEW));
		Scene scene = new Scene(root);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setScene(scene);
		primaryStage.show();

		/*
		 * Parent root = FXMLLoader.load(getClass().getResource(FilesFXML.MAIN_VIEW));
		 * Scene scene = new Scene(root);
		 * scene.getStylesheets().add(getClass().getResource(FilesCSS.STYLE_MAIN).
		 * toExternalForm()); stage.initStyle(StageStyle.UNDECORATED);
		 * stage.setScene(scene); stage.show();
		 */
	}

	@Override
	public void handleStateChangeNotification(StateChangeNotification info) {
		if (info.getType() == StateChangeNotification.Type.BEFORE_START) {
			proloaderStage.hide();
		}
	}

}

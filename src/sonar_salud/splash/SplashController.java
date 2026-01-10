package sonar_salud.splash;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sonar_salud.Launch;
import sonar_salud.constants.FilesFXML;

public class SplashController implements Initializable {

	public static Stage stage = null;
	public Label labelLoadin;
	public static Label labelLoading;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		labelLoading = labelLoadin;

	}

	public String checkFunctions() {
		final String[] message = { "" };
		Thread t1 = new Thread(() -> {
			message[0] = "Loading resources...";
			Platform.runLater(() -> labelLoading.setText(message[0]));

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		});

		Thread t2 = new Thread(() -> {
			message[0] = "Wait...";
			Platform.runLater(() -> labelLoading.setText(message[0]));

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		});

		Thread t3 = new Thread(() -> {
			message[0] = "Welcome to Sonar Salud ...";
			Platform.runLater(() -> labelLoading.setText(message[0]));

			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					try {
						Thread.sleep(1000);
						Stage stage = new Stage();
						Parent root = FXMLLoader.load(getClass().getResource(FilesFXML.LOGIN_VIEW));
						Scene scene = new Scene(root);
						stage.initStyle(StageStyle.UNDECORATED);
						stage.setScene(scene);
						stage.show();

					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}

				}

			});

		});

		try {
			t1.start();
			t1.join();
			t2.start();
			t2.join();
			t3.start();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return message[0];
	}
}

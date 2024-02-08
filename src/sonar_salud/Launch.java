package sonar_salud;

import javafx.application.Application;
import javafx.stage.Stage;
import sonar_salud.splash.SplashController;
import javafx.scene.Scene;


public class Launch extends Application {

	public static Stage stage = null;
	public static Scene scene = null;

	@Override
	public void init() throws Exception {
		//correct();
		SplashController splash = new SplashController();
		splash.checkFunctions();
	}

	@Override
	public void start(Stage stage) throws Exception {
		Launch.stage = stage;

		// Crea el archivo, si no existe, en el que se almacenan los usuaris.
		// FileUtils.createFile(EndpointPaths.DATA_USERS);
	}

	public static void main(String[] args) {

		// launch(args);
		// LauncherImpl.launchApplication(Launch.class,LaunchPreloader.class,args);
		System.setProperty("javafx.preloader", LaunchPreloader.class.getCanonicalName());
		launch(args);

	}
	
	
	/*public void correct() {
		
		Notifications notification =  Notifications.create();
		
		//notification.title("Succes");
		//notification.text("Welcome");
		//notification.hideAfter(Duration.seconds(5));
	
		//notification.position(Pos.BASELINE_RIGHT);
		
		notification.show();
		System.out.print("error aqui");
	}*/

}

/*
 * Modify: 26 dic 2023
 * Author: Calle Serrano, Ángel
 * AlertsService.java
 */
package sonar_salud.alerts;

import org.controlsfx.control.Notifications;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;



// TODO: Auto-generated Javadoc
/**
 * The Class AlertsService.
 */
public class AlertsService {

	AlertsService() {
	}

	/**
	 * Genera el modal de las alertas y lo muestra.
	 *
	 * @param title      the title
	 * @param lvMessages the lv messages
	 */

	public static void error(String textError) {
		Image image= new Image("/sonar_salud/image/cancel.png");
		Notifications notification =  Notifications.create();
		notification.graphic(new ImageView(image));
		notification.title("Error");
		notification.text(textError);
		notification.hideAfter(Duration.seconds(5));
		notification.position(Pos.BASELINE_RIGHT);
		notification.show();
	}
	public static void correct(String textCorrect) {
		Image image= new Image("/sonar_salud/image/checked.png");
		Notifications notification =  Notifications.create();
		notification.graphic(new ImageView(image));
		notification.title("Succes");
		notification.text(textCorrect);
		notification.hideAfter(Duration.seconds(5));
		notification.position(Pos.BASELINE_RIGHT);
		notification.show();;;
	}
	
	
	
	
}
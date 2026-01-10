/*
 * Modify: 26 dic 2023
 * Author: Calle Serrano, Ángel
 * FilesFXML.java
 */
package sonar_salud.constants;

// TODO: Auto-generated Javadoc
/**
 * The Class FilesFXML.
 * 
 * In this class I know all the names of the FXML files that are needed
 * throughout the java code.
 */
public class FilesFXML {

	/** The Constant FXML_EXT. */
	public static final String FXML_EXT = ".fxml";

	/** The Constant SPLASH. */
	public static final String SPLASH = "splash/";

	/** The Constant LOGIN. */
	public static final String LOGIN = "login/";

	/** The Constant REGISTER. */
	public static final String REGISTER = "register/";
	
	/** The Constant REGISTER. */
	public static final String STARTSESSION = "startSession/";

	/** The Constant ALERTS. */
	public static final String ALERTS = "alerts/";

	/** The Constant REGISTER_VIEW. */
	// public static final String REGISTER_VIEW = REGISTER + "RegisterView" +
	// FXML_EXT;
	public static final String REGISTER_VIEW = REGISTER + "Register" + FXML_EXT;

	public static final String LOGIN_VIEW = "../"+LOGIN + "Login" + FXML_EXT;

	public static final String SPLASH_VIEW = SPLASH + "Splash" + FXML_EXT;
	
	public static final String STARTSESSION_VIEW = "../"+STARTSESSION + "StartSessionSlider" + FXML_EXT;

	/** The Constant ALERTS_VIEW. */
	public static final String ALERTS_VIEW = ALERTS + "AlertsView" + FXML_EXT;

	private FilesFXML() {
	}

}

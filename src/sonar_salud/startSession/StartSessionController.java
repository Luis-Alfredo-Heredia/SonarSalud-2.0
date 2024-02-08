package sonar_salud.startSession;

import java.net.URL;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class StartSessionController implements Initializable {

	@FXML
	private Button btn_profile;

	@FXML
	private Button btn_categories;

	@FXML
	private Button btn_analysis;

	@FXML
	private Button btn_settings;

	@FXML
	private Pane pnl_status;

	@FXML
	private Label label_tittle_panel;
	@FXML
	private GridPane pnl_analysis;

	@FXML
	private GridPane pnl_setting;

	@FXML
	private GridPane pnl_category;

	@FXML
	private GridPane pnl_profile;

	@Override
	public void initialize(URL url, ResourceBundle rs) {
		// TODO Auto-generated method stub

	}

	@FXML
	private void menuOptions(MouseEvent event) {

		if (event.getSource() == btn_profile) {
			label_tittle_panel.setText("Profile");
			pnl_profile.toFront();
		} else if (event.getSource() == btn_categories) {
			label_tittle_panel.setText("Categories");
			pnl_category.toFront();

		} else if (event.getSource() == btn_analysis) {
			label_tittle_panel.setText("Analysis");
			pnl_analysis.toFront();

		} else if (event.getSource() == btn_settings) {
			label_tittle_panel.setText("Settings");
			pnl_setting.toFront();

		}
	}

	@FXML
	private void close_app(MouseEvent event) {
		System.exit(0);
	}

}

package sonar_salud.startSession;

import java.io.*;
import javax.sound.sampled.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.animation.TranslateTransition;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import sonar_salud.constants.FilesFXML;
import sonar_salud.entity.User;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Timer;
import java.util.TimerTask;


public class StartSessionControllerSliders {

    //@FXML
    //private FontAwesomeIconView btn_exit;
	private AudioFormat audioFormat;
    private TargetDataLine targetDataLine;
    private ByteArrayOutputStream byteArrayOutputStream;
    private boolean recording = false;
    private long startTime;
    private Timer timer;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private User user;

    @FXML
    private Label btn_menu;

    @FXML
    private Label btn_menu_back;

    @FXML
    private AnchorPane slider;
    
    @FXML
    private AnchorPane pnl_analysis_anchor;

    @FXML
    private Button btn_profile;

    @FXML
    private Button btn_categories;

    @FXML
    private Button btn_analysis;

    @FXML
    private Button btn_settings;
    
    @FXML
    private Button buttonEdit;
    
    @FXML
    private JFXButton btn_SaveChanges;
    
    @FXML
    private Label label_tittle_panel;
    
    
    
    @FXML
    private Button recordButton;

    @FXML
    private Button sendButton;
    
    @FXML
    private Button btn_Start_Analysis;
    
    @FXML
    private Button btn_Restart_Diagnostic;
    
    @FXML
    private TextArea messageTextArea;
    @FXML
    private Text timerText;
    
    @FXML
    private Text numQuestion_Text;


    @FXML
    private AnchorPane pnl_profile;
    
    @FXML
    private AnchorPane pnl_editProfile;

    
    @FXML
    private AnchorPane pnl_category;

    @FXML
    private AnchorPane option_Depresion;

    @FXML
    private AnchorPane option_Ansiedad;

    @FXML
    private AnchorPane option_Esquizofrenia;

    @FXML
    private AnchorPane option_Bulimia;
    @FXML
    private AnchorPane pnl_setting;


    @FXML
    private StackPane menuOptionsSlider;
    

    @FXML
    private PieChart pieChartDiagnosis;
    
    @FXML
    private Label message_Text;

    @FXML
    private Label label_slide_name;
    
    @FXML
    private Label label_profile_name;

    @FXML
    private Label label_profile_username;

    @FXML
    private Label label_profile_age;

    @FXML
    private Label label_profile_gender;

    @FXML
    private Label label_profile_phone;

    @FXML
    private Label label_profile_email;
    
    @FXML
    private JFXTextField textField_name;

    @FXML
    private JFXTextField textField_username;

    @FXML
    private JFXTextField textField_nick;

    @FXML
    private JFXTextField textField_age;

    @FXML
    private JFXTextField textField_nationality;

    @FXML
    private JFXTextField textField_cp;

    @FXML
    private JFXTextField textField_profession;

    @FXML
    private JFXTextField textField_status;

    @FXML
    private JFXTextField textField_gender;

    @FXML
    private JFXTextField textField_phone;

    @FXML
    private JFXTextField textField_email;

    @FXML
    private JFXPasswordField textField_password;


    int numQuestion= 1;
    
	
	public void initialize() {
		
		writeText(numQuestion);
		initAudio();
		slider.setTranslateX(-250);
		pnl_profile.toFront();
		btn_menu_back.setVisible(false);

		btn_menu.setOnMouseClicked(event ->{
			TranslateTransition slide = new TranslateTransition();
			slide.setDuration(Duration.seconds(0.4));
			slide.setNode(slider);		
			slide.setToX(0);
			slide.play();		
			slider.setTranslateX(-250);	
			TranslateTransition menuOption = new TranslateTransition();
			menuOption.setDuration(Duration.seconds(0.4));
			menuOption.setNode(menuOptionsSlider);
			menuOption.setToX(250);
			menuOption.play();	
			menuOptionsSlider.setTranslateX(250);	
			slide.setOnFinished((ActionEvent e)->{
				btn_menu.setVisible(false);
				btn_menu_back.setVisible(true);
			});
			
		});
		
		btn_menu_back.setOnMouseClicked(event ->{
			TranslateTransition slide = new TranslateTransition();
			slide.setDuration(Duration.seconds(0.4));
			slide.setNode(slider);			
			slide.setToX(-250);
			slide.play();			
			slider.setTranslateX(0);
			TranslateTransition menuOption = new TranslateTransition();
			menuOption.setDuration(Duration.seconds(0.4));
			menuOption.setNode(menuOptionsSlider);		
			menuOption.setToX(0);
			menuOption.play();	
			menuOptionsSlider.setTranslateX(0);	
			slide.setOnFinished((ActionEvent e)->{
				btn_menu.setVisible(true);
				btn_menu_back.setVisible(false);
			});
			
		});
	}


    private void initAudio() {
        audioFormat = getAudioFormat();
        DataLine.Info dataLineInfo = new DataLine.Info(TargetDataLine.class, audioFormat);

        try {
            targetDataLine = (TargetDataLine) AudioSystem.getLine(dataLineInfo);
            if (targetDataLine != null) {
                targetDataLine.open(audioFormat);
                targetDataLine.start();
                byteArrayOutputStream = new ByteArrayOutputStream();
            } else {
                System.err.println("Error al obtener la línea de datos de audio.");
            }

        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        
    }

    private AudioFormat getAudioFormat() {
        float sampleRate = 8000.0F;
        int sampleSizeInBits = 16;
        int channels = 1;
        boolean signed = true;
        boolean bigEndian = false;

        return new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
    }

    public void toggleRecording() {
        if (recording) {
            stopRecording();
            recordButton.setText("Record");
        } else {
            startRecording();
            recordButton.setText("Stop");
        }
    }

    private void startRecording(){
 
        recording = true;
        startTime = System.currentTimeMillis();
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateTimer();
            }
        }, 0, 1000);


        byteArrayOutputStream = new ByteArrayOutputStream();
        new Thread(() -> {
            try {
            	
                byte[] tempBuffer = new byte[10000];
                while (recording) {
                	
                    int cnt = targetDataLine.read(tempBuffer, 0, tempBuffer.length);
                    System.out.print(cnt);
                    if (cnt > 0) {
                        byteArrayOutputStream.write(tempBuffer, 0, cnt);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            	stopRecording(); 
            }
        }).start();

    }

    private void stopRecording() {
        recording = false;
        timer.cancel();
        updateTimer();
        sendButton.setDisable(false);
        
        if(targetDataLine.isOpen()) {
        	   targetDataLine.stop();
               targetDataLine.close();

        }
        
    }
    
    private void updateTimer() {
        long elapsedTime = System.currentTimeMillis() - startTime;
        NumberFormat formatter = new DecimalFormat("00");
        long seconds = (elapsedTime / 1000) % 60;
        long minutes = (elapsedTime / (1000 * 60)) % 60;
        String time = formatter.format(minutes) + ":" + formatter.format(seconds);
        timerText.setText(time);
    }
    
    private void updateNumQuestion(int num) {
    	
    	if(num<=5) {
    		String question = num + "/" + "20";
    		numQuestion_Text.setText(question);
    	}
    	
    }

    public void sendAudio() {
    	
    	stopRecording(); 
    	
        if (byteArrayOutputStream != null || byteArrayOutputStream.size() == 0) {
            

            byte[] audioData = byteArrayOutputStream.toByteArray();
            String destinationFolder = "C:\\Users\\luis\\Documents\\Github\\Repository\\SonarSalud\\src\\sonar_salud\\voiceRecorder";
            File destinationDir = new File(destinationFolder);
            
            // Crear la carpeta si no existe
            if (!destinationDir.exists()) {
                destinationDir.mkdirs();
            }
            //File file = new File(destinationFolder, "audioRecording"+ new Date().getSeconds()+".wav");
            File file = new File(destinationFolder, "audioRecording"+numQuestion+".wav");
            saveAudioToFile(audioData, file);
            byteArrayOutputStream.reset();
            this.numQuestion+=1;
            writeText(numQuestion);
            updateNumQuestion(numQuestion);
            timerText.setText("00:00");
            sendButton.setDisable(true);
            enableDiagnosis(numQuestion);
            initAudio();
  
        } else {
        	sendButton.setDisable(true);
        	message_Text.setText("No hay datos de audio para enviar.");
        }
        

        
    }

    private void saveAudioToFile(byte[] audioData, File file) {
        try {
            AudioInputStream audioInputStream = new AudioInputStream(
                    new ByteArrayInputStream(audioData), audioFormat, audioData.length / audioFormat.getFrameSize());

            AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, file);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeText(int numPregunta) {
    	if(numPregunta<=5) {
    		String dato= InicioSesionSrvice.textData("pregunta", Integer.toString(numPregunta));
    		message_Text.setText(dato);
    	}else {
    	}
    	
    	
    	
    }

	@FXML
	private void close_app(MouseEvent event) {
		System.exit(0);
	}
	
	@FXML
	private void menuOptions(MouseEvent event) {

		if (event.getSource() == btn_profile) {
			label_tittle_panel.setText("Profile");
			pnl_profile.toFront();
		}else if (event.getSource() == btn_categories) {
			label_tittle_panel.setText("Categories");
			pnl_category.toFront();

		}else if (event.getSource() == btn_analysis) {
			label_tittle_panel.setText("Analysis");
			pnl_analysis_anchor.toFront();

		}else if (event.getSource() == btn_settings) {
			label_tittle_panel.setText("Settings");
			pnl_setting.toFront();

		}else if (event.getSource() == buttonEdit) {
			label_tittle_panel.setText("Edit your Profile");
			pnl_editProfile.toFront();

		}else if (event.getSource() == option_Depresion ||
			event.getSource() == option_Ansiedad ||
			event.getSource() == option_Esquizofrenia ||
			event.getSource() == option_Bulimia ) {
			label_tittle_panel.setText("Analysis");
			pnl_analysis_anchor.toFront();

		}
	}
	
	private void enableDiagnosis(int num) {
		if(num>5) {
            
			btn_Start_Analysis.setDisable(false);
			sendButton.setDisable(true);
			recordButton.setDisable(true);
			message_Text.setText("Hemos termidado con las preguntas, click en Analysis para ver las posibles causas");

		}else {
			
		}
	}
	
    @FXML
    void backOpcion(MouseEvent events) {
  	
    			TranslateTransition slide = new TranslateTransition();
    			slide.setDuration(Duration.seconds(0.4));
    			slide.setNode(slider);	
    			slide.setToX(-250);
    			slide.play();
    			slider.setTranslateX(0);
    			TranslateTransition menuOption = new TranslateTransition();
    			menuOption.setDuration(Duration.seconds(0.4));
    			menuOption.setNode(menuOptionsSlider);		
    			menuOption.setToX(0);
    			menuOption.play();	
    			menuOptionsSlider.setTranslateX(0);
    			slide.setOnFinished((ActionEvent e)->{
    				btn_menu.setVisible(true);
    				btn_menu_back.setVisible(false);
    			});
    	
    }

    @FXML
    void startDiagnosis(MouseEvent event) {
    	ObservableList<PieChart.Data>pieChartData=FXCollections.observableArrayList(
				new PieChart.Data("Estres", 10),
				new PieChart.Data("Depresion", 30),
				new PieChart.Data("Esquizofrenia", 5),
				new PieChart.Data("Anorexia", 55)
				);
		
		pieChartData.forEach(data->
			data.nameProperty().bind(
					Bindings.concat(data.getName(),": ",data.getPieValue(),"%")));
		
		pieChartDiagnosis.getData().addAll(pieChartData);
		btn_Start_Analysis.setDisable(true);
		btn_Restart_Diagnostic.setVisible(true);
    }
    

    @FXML
    void restartDiagnosis(MouseEvent event) {
    	this.numQuestion= 1;
    	writeText(numQuestion);
    	updateNumQuestion(numQuestion);
    	btn_Start_Analysis.setDisable(true);
    	recordButton.setDisable(false);
		btn_Restart_Diagnostic.setVisible(false);
		pieChartDiagnosis.getData().clear();

    }
    

    @FXML
    void backToLogin(MouseEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource(FilesFXML.LOGIN_VIEW));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }
    
    @FXML
    void updateUser(MouseEvent event) {
    	user.setName(textField_name.getText());
    	user.setPassword(textField_password.getText());
    	user.setPhone(textField_phone.getText());
    	user.setGender(textField_gender.getText());
    	user.setCivil_status(textField_status.getText());
    	user.setProfession(textField_profession.getText());
    	user.setPostal_code(textField_cp.getText());
    	user.setNationality(textField_nationality.getText());
    	user.setBirthDate(textField_age.getText());
    	user.setNick(textField_nick.getText());
    	user.setLastname(textField_username.getText());
    	InicioSesionSrvice.updateUserData(user);
    	label_tittle_panel.setText("Profile");
		pnl_profile.toFront();
		showInformationStartSession(user.getEmail());

		
    }
    
    public void showInformationStartSession(String email) {
    	user = InicioSesionSrvice.userData(email);
    	label_slide_name.setText(user.getName());
    	label_profile_name.setText(user.getName());
    	label_profile_username.setText(user.getLastname());
    	label_profile_age.setText(user.getAge());
    	label_profile_gender.setText(user.getGender());
    	label_profile_phone.setText(user.getPhone());
    	label_profile_email.setText(user.getEmail());

		textField_password.setText(user.getPassword());
		textField_email.setText(user.getEmail());
		textField_phone.setText(user.getPhone());
		textField_gender.setText(user.getGender());
		textField_status.setText(user.getCivil_status());
		textField_profession.setText(user.getProfession());
		textField_cp.setText(user.getPostal_code());
		textField_nationality.setText(user.getNationality());
		textField_age.setText(user.getBirthDate());
		textField_nick.setText(user.getNick());
		textField_username.setText(user.getLastname());
		textField_name.setText(user.getName());
    	
    }


}

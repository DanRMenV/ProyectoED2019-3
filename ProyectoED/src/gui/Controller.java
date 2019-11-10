package gui;

import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import business.*;
import data.*;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

public class Controller implements Initializable{
	static AdminManager lst_admin = new AdminManager();
	static EstudiantesManager lst_stud = new EstudiantesManager();
	
	//Login bienvenida
	@FXML private AnchorPane Login1;
	@FXML private AnchorPane Login2;
	@FXML private AnchorPane Prueba;

	@FXML private JFXTextField UserField;
	@FXML private JFXPasswordField PasswordField;
	
	@FXML private Label IngresarError;
	@FXML private Text bienvenida;
	
	//Anadir estudiante
	@FXML private AnchorPane AddEstudiante;
	
	@FXML private JFXTextField inIdEst;
	@FXML private JFXTextField inNomEst;
	@FXML private JFXTextField inApeEst;
	
	@FXML private JFXDatePicker inFecNac;
	@FXML private JFXComboBox<String> inCurso;
	
	ObservableList<String> comboCursos =
			FXCollections.observableArrayList(
	        "Primero", "Segundo", "Tercero", "Cuarto", "Quinto", "Sexto", "Septimo", "Octavo", 
	        "Noveno", "Decimo", "Once");
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Datos
		lst_admin.addAdminUser(new Admin("juanse","123456"));
		lst_admin.addAdminUser(new Admin("crack yo","09786"));
		lst_admin.addAdminUser(new Admin("babb","12345444"));
		lst_admin.addAdminUser(new Admin("nel","1245"));
		lst_admin.addAdminUser(new Admin("trolazo","696969"));
		
		//Elementos graficos
		inCurso.setItems(comboCursos);
		
	}
	
	public void onExitButtonClicked(MouseEvent event) {
		Platform.exit();
		System.exit(0);
	}
	
	public void onIngresarButtonClicked(MouseEvent event) {
		String temp_user="",temp_password="";
		temp_user = UserField.getText();
		temp_password = PasswordField.getText();
		boolean ver=lst_admin.ValUser(new Admin(temp_user,temp_password));	
		if(ver) {
			bienvenida.setText("Bienvenido "+temp_user+" que desea hacer?");
			Login1.setVisible(false);
			Login2.setVisible(false);
			Prueba.setVisible(true);
			
		}else {
			IngresarError.setVisible(true);
			UserField.setText("");
			PasswordField.setText("");	
		}	
	}
	
	public void onAnadirIcon(MouseEvent event) {
		Prueba.setVisible(false);
		AddEstudiante.setVisible(true);
	}
	
	
	public void onIngresoEstudiante() {		
		String temp_id="",temp_nombres="",temp_apellidos="",temp_curso="";
		
		int id=0;
		temp_id=inIdEst.getText();
		id=Integer.parseInt(temp_id);
		temp_nombres = inNomEst.getText();
		temp_apellidos = inApeEst.getText();
		
		LocalDate fecha_nac=inFecNac.getValue();
		int temp_day=fecha_nac.getDayOfMonth();
		int temp_month=fecha_nac.getMonthValue();
		int temp_year=fecha_nac.getYear();
		temp_curso=inCurso.getValue();
		
		Calendar fecha=new GregorianCalendar(temp_year,temp_month,temp_day);
		Estudiante tmpNew=new Estudiante(id,temp_nombres,temp_apellidos,fecha,temp_curso);
		lst_stud.addEstudiante(tmpNew);
		
		AddEstudiante.setVisible(false);
		Prueba.setVisible(true);
		
		lst_stud.listaEstudiantes();
	}


	
}
